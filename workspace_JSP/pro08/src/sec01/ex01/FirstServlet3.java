package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹브라우저를 이용해  첫 번째 서블릿을 요청할 주소 : http://localhost:8090/pro08/first3
@WebServlet("/first3")
public class FirstServlet3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.print("<script type='text/javascript'>");
		//자바스크립트의 location객체의 href속성에 요청할 서블릿 매핑주소를 설정 재요청합니다.
		//마찬가지로 웹브라우저를 거쳐서 두번째 서블릿(second3)을 요청함
		out.print("location.href = 'second3';");
		
		out.print("</script>");
	}

}
