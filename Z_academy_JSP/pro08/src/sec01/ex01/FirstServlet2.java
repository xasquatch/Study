package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹브라우저를 이용해  첫 번째 서블릿을 요청할 주소 : http://localhost:8090/pro08/first2
@WebServlet("/first2")
public class FirstServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//response객체의 addHeader()메소드에 Refresh를 설정하고
		//1초 후 url=second2에 지정한 second2매핑주소에 해당하는 서블릿을 재요청
		response.addHeader("Refresh", "5;url=second2");
	}

}
