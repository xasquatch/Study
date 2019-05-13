package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mem")
public class MemberServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
						 throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		//요청 값 전달 받기(ajax3.html에서 입력한 ID)
		String id = request.getParameter("id");
		
		//ajax3.html에서 입력한 ID값이 DB에 저장되어 있는지 파악 하기 위해 MemberDAO객체 생성
		MemberDAO memberDAO = new MemberDAO();
		
		//ID중복 여부를 체크 하기 위해 MmemberDAO의 메소드 호출
		boolean overlappedID = memberDAO.overlappedID(id);
		
		if(overlappedID == true){
			writer.print("not_usable");
		}else{
			writer.print("usable");
		}
	}
	
	
}







