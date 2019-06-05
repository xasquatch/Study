package com.willtoto.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.willtoto.dao.MemberDAO;
import com.willtoto.dao.Point_game1DAO;
import com.willtoto.dto.MemberDTO;

public class CommandPointGame1ok implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		try {
			PrintWriter out = response.getWriter();

			int lotto = Integer.parseInt(request.getParameter("puzzle"));
			int my_point = Integer.parseInt(request.getParameter("my_point"));
			String my_id = request.getParameter("my_id");

			if (my_point < 1000) {
				out.println("<script>");
				out.println("alert('포인트가 부족합니다');");
				out.println("location.href='point_game1.do'");
				out.println("</script>");
				out.close();
			} else {

				Point_game1DAO dao = new Point_game1DAO();
				MemberDAO dao2 = new MemberDAO();
				int chk = dao.getGame1ok(lotto, my_point, my_id);
				MemberDTO dto;
				if (chk == 1) {
					dto = dao2.getMember(my_id);

					out.println("<script>");
					out.println("alert('유니크 당첨 (15000포인트 지급)');");
					out.println("location.href='point_game1.do'");
					out.println("</script>");
					out.close();
				} else {
					dto = dao2.getMember(my_id);
					out.println("<script>");
					out.println("alert('꽝');");
					out.println("location.href='point_game1.do'");
					out.println("</script>");
					out.close();
				}

				session.setAttribute("user_member", dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
