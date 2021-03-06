package sec03.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost메소드 호출");
		
		/*순서1. 요청값 전달받기*/
		//요청 값은 request영역에 저장되어 있으므로 한글 깨짐을 방지하기 위해 문자셋 방식 지정
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		//input type이 hidden인 태그의 값을 호출
		String address = request.getParameter("user_address");

		/*순서2. 응답값 마련해서 클라이언트가 사용하는 웹브라우저에 응답하기*/
		response.setContentType("text/html;charset=utf-8");
		
		//출력객체 얻기
		PrintWriter out = response.getWriter();
		String data = "<html>";
				data += "<body>";
				data += "아이디 : " + id +"<br>";
				data += "비밀번호 : " + pw +"<br>";	
				data += "주소 : " + address +"<br>";
				data += "</body>";
				data += "</html>";
				
		//마련한 응답값을 클라이언트의 웹브라우저로 전송해 출력
				out.print(data);
	}

}
