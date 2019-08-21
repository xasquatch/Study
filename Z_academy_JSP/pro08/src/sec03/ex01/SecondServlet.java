package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second7")
public class SecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<html><body>");
		//다른 서블릿에서 전달된 데이터를 가져온다
		out.println("이름 : "+req.getParameter("name"));
		out.println("<br>");
		out.println("dispatch를 이용한 forward 실습입니다.");
		out.println("</body></html>");
		
	}

}
