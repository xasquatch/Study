package com.willtoto.command;

import com.willtoto.dao.MemberDAO;
import com.willtoto.dto.MemberDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandLogin implements Command{
  public void execute(HttpServletRequest request, HttpServletResponse response)
  {
	HttpSession session = request.getSession();
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");

    MemberDAO dao = new MemberDAO();
    MemberDTO dto = dao.memberlogin(id, pw);
    session.setAttribute("user_member", dto);
  }
}