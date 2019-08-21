package com.willtoto.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.willtoto.dao.MemberDAO;
import com.willtoto.dto.MemberDTO;

public class CommandPointTrade implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.getAttribute("user_member");
				
		String id = request.getParameter("id");
		int trade_point = Integer.parseInt(request.getParameter("trade_point"));
		String send_id = request.getParameter("user_id");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.point_trade(id, trade_point, send_id);
		session.setAttribute("user_member", dto);
		request.setAttribute("trade_check", dto);
		
	}

}
