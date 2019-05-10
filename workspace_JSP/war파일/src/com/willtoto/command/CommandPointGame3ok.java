package com.willtoto.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.willtoto.dao.MemberDAO;
import com.willtoto.dao.Point_game2DAO;
import com.willtoto.dto.MemberDTO;

public class CommandPointGame3ok implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		try {
			PrintWriter out = response.getWriter();
			String my_id = request.getParameter("my_id");
			
			int game_num1 = Integer.parseInt(request.getParameter("game_num1"));
			int game_num2 = Integer.parseInt(request.getParameter("game_num2"));
			int game_num3 = Integer.parseInt(request.getParameter("game_num3"));
			int game_num4 = Integer.parseInt(request.getParameter("game_num4"));
			int game_num5 = Integer.parseInt(request.getParameter("game_num5"));
			int game_num6 = Integer.parseInt(request.getParameter("game_num6"));
			int game_num7 = Integer.parseInt(request.getParameter("game_num7"));
			int game_num8 = Integer.parseInt(request.getParameter("game_num8"));
			int game_num9 = Integer.parseInt(request.getParameter("game_num9"));
			int result_num = Integer.parseInt(request.getParameter("result_num"));
			
			int count = 0;
			if(result_num == game_num1){
				count++;
			}
			if(result_num == game_num2){
				count++;
			}
			if(result_num == game_num3){
				count++;
			}
			if(result_num == game_num4){
				count++;
			}
			if(result_num == game_num5){
				count++;
			}
			if(result_num == game_num6){
				count++;
			}
			if(result_num == game_num7){
				count++;
			}
			if(result_num == game_num8){
				count++;
			}
			if(result_num == game_num9){
				count++;
			}
			
			int get_point = 0;
			
			if(count == 0){
				get_point = -500;	
			}else if(count >= 1 && count <=2){
				get_point = 500;
			}else if(count == 3){
				get_point = 3000;
			}else if(count == 4){
				get_point = 5000;
			}else if(count == 5){
				get_point = 10000;
			}else if(count >= 6 && count <=9){
				get_point = 100000;
			}else{
				get_point = -999999999;
			}
			Point_game2DAO dao = new Point_game2DAO();
			dao.getGame2ok(get_point, my_id);
			
			MemberDAO member = new MemberDAO();
			MemberDTO dto = member.getMember(my_id);
			session.setAttribute("user_member", dto);
			if(count == 0){
				out.println("<script>");
				out.println("alert('일치 개수 : 0개');");
				out.println("alert('차감포인트 : -500');");
				out.println("location.href='point_game3.do'"); 
				out.println("</script>");
				out.close();
			}else if(count == 1){
				out.println("<script>");
				out.println("alert('일치 개수 : 1개');");
				out.println("alert('획득포인트 : 500');");
				out.println("location.href='point_game3.do'"); 
				out.println("</script>");
				out.close();
			}else if(count == 2){
				out.println("<script>");
				out.println("alert('일치 개수 : 2개');");
				out.println("alert('획득포인트 : 500');");
				out.println("location.href='point_game3.do'"); 
				out.println("</script>");
				out.close();
			}else if(count == 3){
				out.println("<script>");
				out.println("alert('일치 개수 : 3개');");
				out.println("alert('획득포인트 : 3000');");
				out.println("location.href='point_game3.do'"); 
				out.println("</script>");
				out.close();
			}else if(count == 4){
				out.println("<script>");
				out.println("alert('일치 개수 : 4개');");
				out.println("alert('획득포인트 : 5000');");
				out.println("location.href='point_game3.do'"); 
				out.println("</script>");
				out.close();
			}else if(count == 5){
				out.println("<script>");
				out.println("alert('일치 개수 : 5개');");
				out.println("alert('획득포인트 : 10000');");
				out.println("location.href='point_game3.do'"); 
				out.println("</script>");
				out.close();
			}else if(count == 6){
				out.println("<script>");
				out.println("alert('일치 개수 : 6개');");
				out.println("alert('획득포인트 : 100000');");
				out.println("location.href='point_game3.do'"); 
				out.println("</script>");
				out.close();
			}else if(count == 7){
				out.println("<script>");
				out.println("alert('일치 개수 : 7개');");
				out.println("alert('획득포인트 : 100000');");
				out.println("location.href='point_game3.do'"); 
				out.println("</script>");
				out.close();
			}else if(count == 8){
				out.println("<script>");
				out.println("alert('일치 개수 : 8개');");
				out.println("alert('획득포인트 : 100000');");
				out.println("location.href='point_game3.do'"); 
				out.println("</script>");
				out.close();
			}else if(count == 9){
				out.println("<script>");
				out.println("alert('일치 개수 : 9개');");
				out.println("alert('획득포인트 : 100000');");
				out.println("location.href='point_game3.do'"); 
				out.println("</script>");
				out.close();
			}
			
			}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
