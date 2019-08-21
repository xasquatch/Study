package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//httpServletRequest의 setAttribute(키,값)메소드를 이용해 
//(address,"서울시 성북구")메소드로 httpServletRequest객체영역에 바인딩합니다.
@WebServlet("/first8")
public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//웹브라우저에서 요청한 request객체에 address의 값으로 "서울시 성북구" 값을 바인딩 합니다.
		request.setAttribute("address", "서울시 성북구");
		//두 번째 서블릿으로 값을 전달하기 위해 response객체의 sendRedirect()메소드를 호출함.
		response.sendRedirect("second8");
		
		
	}

}
