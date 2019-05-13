package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트페이지 ajax1.html페이지에서 Ajax기술로 메세지를 보내면
//처리를 하는 서블릿 입니다.
@WebServlet("/ajaxTest1")
public class AjaxTest1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
						throws ServletException, IOException {
		doHandle(request, response);
	}	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
						  throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) 
			  throws ServletException, IOException {
		
		//한글처리
		request.setCharacterEncoding("UTF-8");
		//응답할 데이터타입 지정
		response.setContentType("text/html; charset=utf-8");
		//getParameter()메소드를 이용해 ajax로 전송된 값을 얻는다.
		String param = request.getParameter("param");
		System.out.println("param=" + param);
		
		//PrintWriter의 print()메소드를 이용해 브라우저에 응답 메세지를 보냅니다.
		PrintWriter writer = response.getWriter();
		writer.print("안녕하세요! 서버입니다.");
		
	}
		
}









