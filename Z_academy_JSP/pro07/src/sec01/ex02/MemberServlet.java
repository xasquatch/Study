package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8090/pro07/member 주소를 웹브라우저에 작성하여 요청함
@WebServlet("/member")
public class MemberServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 클라이언트에게 응답할 response객체에 응답할 데이터 타입을 지정
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");

		// DB작업(오라클DB와 연동,SELECT문으로 회원검색)할 MemberDAO클래스에 대한 객체 생성
		MemberDAO dao = new MemberDAO();
		// DB로부터 검색해온 결과물 ArrayList배열 ← 클라이언트에게 응답할 데이터
		// listMembers()메소드를 호출하여 검색한 회원정보를 각각의 MemberVO 객체에 저장하여
		// 각각의 MemberVO객체들을 최종적으로 ArrayList가변길이 배열에 저장 후
		// DB에서 검색한 회원정보를 반환 받는다.
		ArrayList list = dao.listMembers();

		//클라이언트의 웹브라우저로 응답할 수 있는 출력 객체 얻기
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		out.print("<table border='1'>");
		out.print("<tr align = 'center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td>");
		out.print("</tr>");
		
		for (int i = 0; i < list.size(); i++) {
			//조회한 회원정보는 ArrayList라는 가변길이 배열 공간에 젖아되어 있으므로
			//ArrayList 가변길이 배열에 저장된 검색한 회원정보를 하나씩 얻는다.
			MemberVO memberVO = (MemberVO)list.get(i);	//new MemberVO()는 자신객체
			
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			
			//조회한 회원 정보를 바깥 for문과 <tr>태그를 이용해 리스트로 출력합니다.
			out.print("<tr><td>"+id+"</td>");
			out.print("<td>"+pwd+"</td>");
			out.print("<td>"+name+"</td>");
			out.print("<td>"+email+"</td>");
			out.print("<td>"+joinDate+"</td>");
			

			out.print("</tr>");
		};
		
		out.print("</table>");
		out.print("</body></html>");
	}

}
