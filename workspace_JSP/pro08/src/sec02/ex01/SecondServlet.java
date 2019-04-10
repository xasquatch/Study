package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//이전 firstServlet서블릿에서 전달된 값을 getParameter()메서드를 이용해 가져와
//클라이언트의 웹브라우저로 응답하는 두 번째 서블릿임.
@WebServlet("/second4")
public class SecondServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		//name으로 이전 서블릿에서 전달된 값 lee를 받습니다.
		String name = request.getParameter("name");
		out.println("이름 : "+ name + "<br>");
		out.println("</body></html>");
	}

}
