package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹브라우저에서 전달받은 ID와 비밀번호를 HTML태그로 만든 후 다시 브라우저로 응답하는 역할
@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {
       
	//클라이언트가 웹브라우저를 통해 GET방식으로 요청했을 때 호출되는 메소드로서
	//매개변수로 요청한 클라이언트에 관한 정보를 저장한 request객체영역과 응답할 response객체를 전달 받음.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//웹브라우저에서 전송된 데이터의 인코딩방식 설정
		request.setCharacterEncoding("utf-8");
		//웹브라우저로 응답하기 위해
		//response객체의 setContentType()을 이용해 응답할 데이터 종류를 HTML태그로 설정
		response.setContentType("text/html;charset=utf-8");
		
		//response객체의 getWrite()를 호출하면 반환객체로 PrintWrite객체를 리턴 받음
		//PrintWriter객체는 클라이언트의 웹브라우저로 출력통로를 가지고 있는 객체임
		//또한 print(), println() 메소드들을 지니고 있다.
		PrintWriter out = response.getWriter();
		
		//클라이언트의 요청값 받기
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		//요청값을 받은 후 응답데이터 생성하기
		//(브라우저로 출력할 응답데이터를 문자열로 연결해서 HTML태그로 만듬)
		String data = "<html>";
			data += "<body>";
			data += "아이디 : "+ id;
			data += "<br>";
			data += "패스워드 : " + pw;
			data += "</body>";
			data += "</html>";
		//---------PrintWriter객체의 print()를 이용해 HTML태그 문자열을 웹브라우저로 출력(응답)
		out.print(data);
			
	}

}
