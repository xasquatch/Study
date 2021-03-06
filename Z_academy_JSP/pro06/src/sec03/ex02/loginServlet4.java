package sec03.ex02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login4")
public class loginServlet4 extends HttpServlet {

	
	
	//GET방식의 요청일 경우 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메소드호출");
		doHandle(request, response); //GET방식으로 요청시 다시 doHandle()을 호출함
	}
	
	//POST방식의 요청일 경우 호출	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 메소드호출");
		doHandle(request, response); //POST방식으로 요청시 다시 doHandle()을 호출함
	}

	//클라이언트가 GET방식으로 요청하든 POST방식으로 요청하든 모든 호출방식에 대해서 처리할 수 있는 메소드
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doHandle 메소드 호출");
		
		
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		System.out.println("ID : "+user_id);
		System.out.println("PW : "+user_pw);
		
	}


}
