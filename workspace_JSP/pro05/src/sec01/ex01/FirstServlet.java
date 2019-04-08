package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트가 웹브라우저를 통해서 요청할 서블릿 클래스 만들기
public class FirstServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet메서드호출");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy메서드호출");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init메서드호출");
	} //HttpServlet클래스를 상속 받아야함

	//메소드 오버라이드 단축키 : alt + shift + s + v
	
	
	
}
