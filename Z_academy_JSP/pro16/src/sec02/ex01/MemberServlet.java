package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트페이지 ajax2.html페이지에서 Ajax기술로 메세지를 보내면
//처리를 하는 서블릿입니다.

@WebServlet("/mem1")
public class MemberServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		String id = request.getParameter("id");
		
		//ajax3.html에서 입력한 ID값이 DB에 저장되어 있는지 파악하기 위해 MemberDAO객체 생성
		MemberDAO dao = new MemberDAO();
		
		//ID중복여부를 체크하기 위해 MemberDAO의 메소드 호출
		boolean overlappedID = dao.overlappedID(id);
		
		if (overlappedID) {
			writer.print("not_useble");
		}else{
			writer.print("useble");
		}
		
		
		
	}
}
