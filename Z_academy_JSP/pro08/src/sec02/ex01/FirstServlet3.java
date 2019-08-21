package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹브라우저를 이용해  첫 번째 서블릿을 요청할 주소 : http://localhost:8090/pro08/first4

//주제 : redirect 방식을 이용하면 웹브라우저를 통해 다른 서블릿을 호출하면서 원하는 데이터를 전달 할 수도 있다.
//예제 : redirect 방법으로 최초 요청한 서블릿에서 GET방식으로 다른 서블릿으로 데이터를 전달하는 예제
@WebServlet("/first6")
public class FirstServlet3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.print("<script type='text/javascript'>");
		out.print("location.href='second6?name=lee';");
		
		out.print("</script>");
	}

}
