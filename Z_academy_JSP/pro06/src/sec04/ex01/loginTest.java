package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//loginTest서블릿의 주요역할
//ID나 비밀번호를 제대로 입력하지 않으면 오류 메세지를 출력한 후 
//다시 로그인 창으로 이동이 되도록 설정.

@WebServlet("/loginTest")
public class loginTest extends HttpServlet {

	/*
	 * 구성 명령지정자 리턴값 메소드명(서블릿request request변수, 서블릿response response변수) throws
	 * exception(runtime exception제외)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 요청받은 데이터들은 request객체 영역에 저장되어 있으므로
		// 한글이 하나라도 존재하면 한글 깨짐방지를 위한 문자셋 방식을 utf-8로 지정함
		request.setCharacterEncoding("utf-8");
		// 클라이언트에게 응답할 때 어떤 데이터를 응답할지 response객체에 마임타입을 설정
		response.setContentType("text/html;charset = utf-8");
		// 클라이언트 웹브라우저로 출력역할을 함 객체생성
		PrintWriter out = response.getWriter();

		// 클라이언트가 입력한 id,pw를 request영역에서 꺼내오기
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");

		// 아이디를 입력했다면
		if (id != null && (id.length() != 0)) {
			out.print("<html>");
			out.print("<body>");
			out.print(id + "님 로그인 하셨습니다.");
			out.print("</body>");
			out.print("</html>");
		} else {	//아이디 입력 안했다면
			out.print("<html>");
			out.print("<body>");
			out.print("아이디를 입력하세요");
			out.print("<BR>");
			out.print("<a href='http://localhost:8090/pro06/login.html'>로그인화면으로 이동</a>");
			out.print("</body>");
			out.print("</html>");
		}

	}

}
