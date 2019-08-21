package net.member.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberbBean;

public class MemberJoinAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		request.setCharacterEncoding("UTF-8");
		
		MemberbBean mb = new MemberbBean();
		mb.setId(request.getParameter("id"));
		mb.setPass(request.getParameter("pass"));
		mb.setName(request.getParameter("name"));
		mb.setAddress(request.getParameter("address"));
		mb.setEmail(request.getParameter("email"));
		mb.setMobile(request.getParameter("mobile"));
		mb.setPhone(request.getParameter("phone"));
		mb.setDate(new Timestamp(System.currentTimeMillis()));
		
		return null;
	}

}
