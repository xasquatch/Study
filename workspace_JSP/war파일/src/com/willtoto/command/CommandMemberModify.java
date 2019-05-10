package com.willtoto.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.willtoto.dao.MemberDAO;
import com.willtoto.dto.MemberDTO;

public class CommandMemberModify implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw;
		if(request.getParameter("newpwc") == ""){
			pw = request.getParameter("nowpw");
		}else{
			pw = request.getParameter("newpwc");
		}
		String email = request.getParameter("email");
		String find_q = request.getParameter("find_q");
		String find_a = request.getParameter("find_a");
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.Member_Modify(id, name, pw, email, find_q, find_a);
		session.setAttribute("user_member", dto);
	}

}
