package com.spring.ex03;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mem3.do")
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
		
		String nextpage = "index.jsp";
		String action = request.getParameter("action");
		
		if (action == null || action.equals("listMembers")) {
			
			List memberList = dao.selectAllMemberList();
			
			request.setAttribute("membersList", memberList);
			nextpage = "test02/listMembers.jsp";
			
		}else if (action.equals("selectMemberById")) {
			
			String value = request.getParameter("value");
			
			MemberVO vo = dao.selectMemberById(value);
			request.setAttribute("member", vo);
			
			nextpage = "test02/memberInfo.jsp";
			
			
		}else if (action.equals("selectMemberByPwd")) {

			String value = request.getParameter("value");
			
			List member = dao.selectMemberByPwd(value);
			request.setAttribute("membersList", member);
			
			nextpage = "test02/listMembers.jsp";
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextpage);
		dispatcher.forward(request, response);
		
		
	}
}
