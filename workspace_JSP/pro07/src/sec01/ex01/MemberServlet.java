package sec01.ex01;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//http://localhost:8090/pro07/member 주소를 웹브라우저에 작성하여 요청함
@WebServlet("/member")
public class MemberServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//클라이언트에게 응답할 response객체에 응답할 데이터 타입을 지정
		response.setContentType("text/html);charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//DB작업(오라클DB와 연동,SELECT문으로 회원검색)할 MemberDAO클래스에 대한 객체 생성
		MemberDAO dao = new MemberDAO(); 
		//DB로부터 검색해온 결과물 ArrayList배열 ← 클라이언트에게 응답할 데이터 
		ArrayList list = dao.listMembers();
	}
	
	
	
}
