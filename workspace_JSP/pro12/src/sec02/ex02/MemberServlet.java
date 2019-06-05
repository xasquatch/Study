package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mem2")
public class MemberServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest Request, HttpServletResponse Response)
			throws ServletException, IOException {doHandle(Request, Response);	}
	@Override
	protected void doPost(HttpServletRequest Request, HttpServletResponse Response)
			throws ServletException, IOException {doHandle(Request, Response);	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		//t_member테이블로부터 회원정보를 검색하기 위해 DB작업을 하는 MemberDAO객체 생성
		MemberDAO dao = new MemberDAO();
		
		List memberlist = dao.listMembers();
		
		String result = null;//xml데이터 저장할 변수 선언

		//조회한 회원정보를 XML 문자여로 만든다
		result = "<main>";
		
		for (int i= 0; i<memberlist.size() ; i++) {
			MemberVO vo = (MemberVO)memberlist.get(i);
			String id = vo.getId();
			String name = vo.getName();
			String email = vo.getEmail();
			Date date = vo.getJoinDate();
			String pwd = vo.getPwd();
					
			result += "<member>"+"<id>"+id+"</id>"+"<name>"+name+"</name>"+"<email>"+email+"</email>"
					+"<date>"+date+"</date>"+"<pwd>"+pwd+"</pwd>"+"</member>";
			
		}
		
		result += "</main>";
		
		PrintWriter writer = response.getWriter();
		writer.print(result);
		
		
		
		
		
		
		
		
	}

}
