package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트가 웹브라우저로 이용해 주소창에 주소를 입력하고 요청을 했을 때 호출되는 서블릿 클래스
@WebServlet("/thrid")	//어노테이션 기호를 이용하여 클라이언트가 요청한 주소와 현재 서블릿 클래스를 매핑시킴

//ThridServlet서블릿 클래스를 만들 때.. HttpServlet클래스를 상속받아 만들어야 함.
public class ThridServlet extends HttpServlet {

	//서블릿 클래스 직렬화를 위해 이클립스에서 자동으로 지정한 상수입니다.
	//사용하지 않으므로 삭제합니다.
//	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("ThridServlet init 메소드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ThridServlet doGet 메소드 호출");
	}

	public void destroy() {
		System.out.println("ThridServlet destroy 메소드 호출");
	}
	
}
