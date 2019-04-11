package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//httpServletRequest의 setAttribute(키,값)메소드를 이용해 
//(address,"서울시 성북구")메소드로 httpServletRequest객체영역에 바인딩합니다.
@WebServlet("/first9")
public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//웹브라우저에서 요청한 request객체에 address의 값으로 "서울시 성북구" 값을 바인딩 합니다.
		request.setAttribute("address", "서울시 성북구");
		
		//바인딩된 request객체영역을 다시 두 번째 서블릿으로 포워드합니다
		//이 때 second9라고 적은 것은 두 번째 서블릿을 요청할 매핑 주소입니다.
		RequestDispatcher ssxx = request.getRequestDispatcher("second9");
		
		ssxx.forward(request, response);
		
	}

}
