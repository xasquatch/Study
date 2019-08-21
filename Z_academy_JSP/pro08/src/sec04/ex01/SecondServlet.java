package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//httpServletRequest객체의 getAttribute()메소드를 이용해
//첫 번째 서블릿으로 부터 전달된 address에 해당하는 값을 꺼내서 얻을 수 있다.??? 없어요~~
@WebServlet("/second8")
public class SecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		String address = (String)request.getAttribute("address");
		
		PrintWriter out = response.getWriter();
		
		out.write("<html><body>");
		
		out.write("주소 : "+address+"<BR>");
		out.write("redirect방식을 이용한 바인딩 실습입니다.");
		out.write("</body></html>");
	}

}
