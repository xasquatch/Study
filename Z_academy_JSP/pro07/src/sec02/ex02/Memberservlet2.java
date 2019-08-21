package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//memberForm.html페이지에서 가입할 회원내용을 입력하고
//입력한 내용들을 request객체영역에 저장 후
//MemberrServlt2서블릿을 요청시 request영역을 전달하게 된다.
//입력한 회원내용을 DB에 추가해주세요 하는 요청이 들어옴
//command값을 먼저 받아와 addMember이면 값이 전송된 회원정보를 받습니다.
//회원 정보를 MemberVO객체에 설정한 후 MemberDAO의 메소드로 전달해 SQL문을 이용하여 테이블에 추가합니다.
@WebServlet("/member3")
public class Memberservlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);

	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 클라이언트의 요청 값 한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// DB작업을 담당할 객체 생성
		MemberDAO dao = new MemberDAO();
		// 클라이언트의 웹브라우저로 응답하기 위한 출력스트림 객체 생성
		PrintWriter out = response.getWriter();

		// 클라이언트의 요청값 전달받기
		// 클라이언트가 어떤 요청을 했는지 받아옵니다. 그 값은 addMember(회원가입 요청)입니다.
		// 클라이언트가 어떤 요청을 했는지 받아옵니다. 그 값은 delMember(회원정보 삭제)입니다.
		String command = request.getParameter("command");

		// 회원가입 창에서 전송된 command가 addMember이면 전송된 값들을 모두 받아옵니다.
		if (command != null || "addMember".equals(command)) {
			// 흐름 :
			// 회원가입창에서 전송된 값들을 얻어와 MemberVO객체에 저장한 후
			// SQL문을 이용해 DB에 insert함.
			String _id = request.getParameter("id");
			String _pwd = request.getParameter("pwd");
			String _name = request.getParameter("name");
			String _email = request.getParameter("email");

			MemberVO vo = new MemberVO();
			vo.setId(_id);
			vo.setPwd(_pwd);
			vo.setName(_name);
			vo.setEmail(_email);
			
			// SQL문을 이용해 DB에 insert함.			
			dao.addMember(vo);
			
		//command 변수 값이 delmember인 경우 ID를 가져와 SQL문으로 전달해서 삭제
		} else if(command !=null && command.equals("delmember")){
			String id = request.getParameter("id");
			//DB와 연결하여 회원 정보를 삭제하기 위해 MemberDAO객체의 delMember()메서드 호출
			//메소드 호출시 위의 삭제할 id변수 값을 전달하여 DB작업 하기(DELETE)
			dao.delMember(id);
		}

		//흐름 : 
		//listMembers()메소드를 호출하여 검색한 회원정보를 MemberVO객체에 저장하여
		//각각의 MemberVO객체들을 최종적으로 ArrayList가변길이 배열공간에 저장후 
		//DB에서 검색한 회원정보를 반환 받는다.
		ArrayList list = dao.listMembers();
		
		//클라이언트에게 응답할 response객체에 응답할 데이터 타입을 지정
		response.setContentType("text/html;charset=utf-8");
		
		//클라이언트의 웹브라우저로 응답을 할수 있는 출력 객체 얻기
		PrintWriter out2= response.getWriter();
		
		out2.print("<html><body>");
		out2.print("<table border='1'>");
		out2.print("<tr align='center' bgcolor='lightgreen'>");
		out2.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td>");
		out2.print("<td>가입일</td><td>삭제</td>");	
		out2.print("</tr>");
		for(int i=0;  i<list.size(); i++){
			//조회한 회원정보는 ArrayList라는 가변길이 배열 공간에 저장되어 있으므로
			//ArrayList 가변길이 배열에 저장된 검색한 회원정보를 하나씩 얻는다
			MemberVO memberVO = (MemberVO)list.get(i); //new MemberVO();
			
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();			
		//조회한 회원 정보를 바깥 for문과  <tr>태그를 이용해 리스트로 출력 합니다.
		out2.print("<tr>");
		out2.print("<td>"+ id +"</td>");
		out2.print("<td>"+ pwd +"</td>");
		out2.print("<td>"+ name + "</td>");
		out2.print("<td>" + email + "</td>");
		out2.print("<td>" + joinDate +"</td>");
		out2.print("<td><a href='http://localhost:8090/pro07/member3?command=delmember&id="+id+"'>삭제</a></td>");
		out2.print("</tr>");
		}//for 끝 
		out2.print("</table>");
		out2.print("</body></html>");
		
		out2.print("<a href='http://localhost:8090/pro07/memberForm.html'>새 회원 등록하기</a>");
	}//doHandle 닫는 부분

}//memberServlet2 닫는부분
