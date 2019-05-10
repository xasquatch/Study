package com.willtoto.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.willtoto.dao.MemberDAO;

public class CommandJoin implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pwc");
		String e_mail = request.getParameter("email");
		String find_q = request.getParameter("findq");
		String find_a = request.getParameter("finda");
		
		MemberDAO dao = new MemberDAO();
		boolean result = dao.memberjoin(name, id, pw, e_mail, find_q, find_a);
		request.setAttribute("join_result", result);
		
	}

}
