package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹브라우저를 이용해  첫 번째 서블릿을 요청할 주소 : http://localhost:8090/pro08/first
@WebServlet("/first")
public class FirstServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//response객체의 sendRedirect()메서드를 이용해 웹브라우저에게
		//다른 서블릿인 second라는 매핑주소로 재요청을 하게 전달함.
		response.sendRedirect("second");
		
	}

}
