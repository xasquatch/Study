package sec03.ex01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first7")
public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//dispatch방법을 이용해 두 번째 서블릿은 재요청함.
		request.setCharacterEncoding("utf-8");
		//getRequestDispatcher메소드 호출시 포워딩할 페이지 주소를 전달하여
		//그 주소를 RequestDispatcher객체에 저장하여 RequestDispatcher객체 자체를 리턴함
		RequestDispatcher dispatch = request.getRequestDispatcher("second7?name=lee");
		//GET방식으로 데이터를 전달합니다.
		//RequestDispatcher객체의 forward를 이용하여 이동 시 request객체영역, response객체영역을 같이 전달함.
		dispatch.forward(request, response);
		
	}

}
