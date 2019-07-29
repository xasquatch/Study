package com.spring.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/mem.do")
public class MemberServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response); System.out.println("accept GET");}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response); System.out.println("accept POST");}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		MemberDAO dao = new MemberDAO();
//		String name = dao.selectName();
//		int pwd = dao.selectPwd();
		
		
		
		List memberList = dao.selectAllMemberList();
		
		
		request.setAttribute("membersList", memberList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("test01/listMembers.jsp");
		dispatcher.forward(request, response);
		
//		PrintWriter writer = response.getWriter();
//		writer.write("<script>");
//		writer.write("alert('이름:"+name+"')");
//		writer.write("alert('비밀번호:"+pwd+"')");
//		writer.write("</script>");
		
	}
}
