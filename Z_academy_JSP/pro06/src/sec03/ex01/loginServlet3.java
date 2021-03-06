package sec03.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//흐름 : 클라이언트가 웹브라우저 주소창에 http://localhost:8090/pro6/login3.html 입력후
//		정적인 페이지 login3.html을 톰캣에 요청
//		정적인 login3.html페이지가 웹브라우저 화면에 나오면 클라이언트는 아이디와, 비밀번호를 입력 후 
//		로그인 버튼으로 LoginServlet3를 요청한다.
//		POST방식으로 요청이 일어나면 서블릿을 요청한 매핑 주소는 <form>태그의 action속성의 값으로 login3이다
//		이 떄 입력한 데이터는 웹브라우저를 통해 LoginServlet3의  doPost메소드의 인자로 전달되게 된다.

@WebServlet("/login3") //서블릿 요청하기 위한 매핑주소
public class loginServlet3 extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("init 메소드 호출됨");
	}

	//POST방식으로 전송된 데이터를 처리하기 위해 doPost()메소드를 이용합니다.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청받은 데이터툴은 request객체 영역에 저장되어 전달되므로
		//한글 깨짐 처리를 위한 이코딩 방식의 값을 utf-8로 지정
		request.setCharacterEncoding("utf-8");
		
		//login3.html에서 입력한 요청값 받기
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		System.out.println("아이디 : "+user_id);
		System.out.println("패스워드 : "+user_pw);
	}

	@Override
	public void destroy() {
		System.out.println("destroy 메소드 호출됨");
	}
	
	
}
