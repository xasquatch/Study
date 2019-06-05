package com.willtoto.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.willtoto.dao.MemberDAO;
import com.willtoto.dao.Point_game2DAO;
import com.willtoto.dto.MemberDTO;

public class CommandPointGame4ok implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		try {
			PrintWriter out = response.getWriter();
			String my_id = request.getParameter("my_id");
			
			int num = Integer.parseInt(request.getParameter("num"));
			int dividend_point = Integer.parseInt(request.getParameter("dividend_point"));
			int result = Integer.parseInt(request.getParameter("result"));
			
			int get_point = 0;
			
			if(num == result){
				get_point = dividend_point * 3;
			}else{
				get_point = dividend_point * -1;
			}
			
			Point_game2DAO dao = new Point_game2DAO();
			dao.getGame2ok(get_point, my_id);
			
			MemberDAO member = new MemberDAO();
			MemberDTO dto = member.getMember(my_id);
			session.setAttribute("user_member", dto);
			
			if(num == result){
				out.println("<script>");
				out.println("alert('배팅포인트 금액 3배 획득');");
				out.println("location.href='point_game4.do'"); 
				out.println("</script>");
				out.close();
			}else{
				out.println("<script>");
				out.println("alert('배팅포인트 금액 차감');");
				out.println("location.href='point_game4.do'"); 
				out.println("</script>");
				out.close();
			}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
						
			}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
