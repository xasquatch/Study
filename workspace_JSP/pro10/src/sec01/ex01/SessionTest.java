package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess")
public class SessionTest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		//Session객체영역얻기
		HttpSession session =  request.getSession();
		//Session객체영역에 값을 바인딩합니다.
		session.setAttribute("name", "이순신");
		out.println("<html><body>");
		out.println("<h1>세션영역에 name에 해당하는 이순신을 바인딩 했습니다</h1>");
		out.println("<a href='/pro10/test01/session1.jsp'>첫 번째 JSP페이지로 이동하기</a><BR>");
		out.println("<a href='/pro10/test01/session2.jsp'>두 번째 JSP페이지로 이동하기</a>");
		out.println("</body></html>");
		
		out.println("<form action='' name='' method=''>");
		out.println("ID<input type='text' name='id'>");
		out.println("PW<input type='password' name='pw'>");
		out.println("</form>");
	}

}
