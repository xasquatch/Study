package com.willtoto.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.willtoto.dao.MemberDAO;
import com.willtoto.dao.Point_game2DAO;
import com.willtoto.dto.MemberDTO;

public class CommandPointGame2ok implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		try {
			PrintWriter out = response.getWriter();

			int game_num = Integer.parseInt(request.getParameter("game_num"));
			String my_id = request.getParameter("my_id");
			int get_point = 0;
			
			if(game_num == 1){
				get_point = 5000;
			}else if(game_num >= 2 && game_num <= 89){
				get_point = -500;
			}else if(game_num >=90 && game_num <= 99){
				get_point = 500;
			}else if(game_num == 100){
				get_point = 3000;
			}else if(game_num >=101 && game_num <= 199){
				get_point = -500;
			}else if(game_num == 200){
				get_point = 4000;

			}else{
				get_point = 0;
			}
			Point_game2DAO dao = new Point_game2DAO();
			int result = dao.getGame2ok(get_point, my_id);
			
			MemberDAO member = new MemberDAO();
			MemberDTO dto = member.getMember(my_id);
			session.setAttribute("user_member", dto);
			
			if(result == 5000){
				out.println("<script>");
				out.println("alert('획득포인트 : 5000');");
				out.println("location.href='point_game2.do'"); 
				out.println("</script>");
				out.close();
			}else if(result == 4000){
				out.println("<script>");
				out.println("alert('획득포인트 : 4000');");
				out.println("location.href='point_game2.do'"); 
				out.println("</script>");
				out.close();
			}else if(result == 3000){
				out.println("<script>");
				out.println("alert('획득포인트 : 3000');");
				out.println("location.href='point_game2.do'"); 
				out.println("</script>");
				out.close();
			}else if(result == 500){
				out.println("<script>");
				out.println("alert('획득포인트 : 500');");
				out.println("location.href='point_game2.do'"); 
				out.println("</script>");
				out.close();
			}else if(result == -500){
				out.println("<script>");
				out.println("alert('차감포인트 : -500');");
				out.println("location.href='point_game2.do'"); 
				out.println("</script>");
				out.close();
			}
			
			}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
