package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//SecondServlet2클래스는 첫 번째 서블릿(FirstServlet2클래스)에서 요청을 받아 실행하는 두번째 서블릿입니다.
@WebServlet("/second2")
public class SecondServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("response객체의 addHeader()메소드를 이용한 Refresh실습입니다.");
		out.println("</body></html>");
	}
	
}
