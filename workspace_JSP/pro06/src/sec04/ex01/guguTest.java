package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/guguTest")
public class guguTest extends HttpServlet {
       
	public void init() {
		System.out.println("init 메서드 호출");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		int dan = Integer.parseInt(req.getParameter("dan"));
		
			out.print("<html>");
			out.print("<body>");
			out.print("<amg href='70a.jpg'>");
			out.print("<table border = '1px solid'>");
			out.print("<tr bgcolor='yellow' width=300'><td colspan = 2>"+dan+"단 출력</td> </tr>");
			for(int i = 1; i < 10; i++) {
				out.print("<tr>");
				out.print("<td>"+dan+" × "+i+"</td>");
				out.print("<td>"+dan*i+"</td>");
				out.print("</tr>");
			}
			out.print("</table>");
			out.print("</body>");
			out.print("</html>");
		
	}
	
}
