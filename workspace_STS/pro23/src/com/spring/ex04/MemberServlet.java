package com.spring.ex04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mem4.do")
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
		
		MemberVO vo = new MemberVO();
		
		if (action == null || action.equals("listMembers")) {
			
			List memberList = dao.selectAllMemberList();
			
			request.setAttribute("membersList", memberList);
			nextpage = "test03/listMembers.jsp";
			
		}else if (action.equals("selectMemberById")) {
			
			String value = request.getParameter("value");
			
			vo = dao.selectMemberById(value);
			request.setAttribute("member", vo);
			
			nextpage = "test03/memberInfo.jsp";
			
			
		}else if (action.equals("selectMemberByPwd")) {

			String value = request.getParameter("value");
			
			List member = dao.selectMemberByPwd(value);
			request.setAttribute("membersList", member);
			
			nextpage = "test03/listMembers.jsp";
			
		}else if (action.equals("insertMember")) {
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setName(name);
			vo.setEmail(email);
			
			int result = dao.insertMember(vo);
			
			if (result < 1) {
				nextpage = "test03/memberForm.jsp";
			}else {
				nextpage = "mem4.do?action=listMembers";
			}
		}else if (action.equals("insertMember2")) {
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			Map memberMap = new HashMap();
			
			memberMap.put("id", id);
			memberMap.put("pwd", pwd);
			memberMap.put("name", name);
			memberMap.put("email", email);
			
			int result = dao.insertMember2(memberMap);
			
			if (result < 1) {
				nextpage = "/test03/memberForm.jsp";
			}else {
				nextpage = "/mem4.do?action=listMembers";
			}
		}else if (action.equals("updateMember")) {
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");

			vo.setId(id);
			vo.setPwd(pwd);
			vo.setName(name);
			vo.setEmail(email);
			
			int result = dao.updateMember(vo);
			
			if (result < 1) {
				nextpage = "/mem4.do?action=updateMember";
			}else {
				nextpage = "/mem4.do?action=listMembers";	
			}
		}else if (action.equals("deleteMember")) {
			
			String id = request.getParameter("id");			
			
			int result = dao.deleteMember(id);
			
			nextpage = "/mem4.do?action=listMembers";
		
		}else if (action.equals("searchMember")) {
			
			String name = request.getParameter("name");			
			String email = request.getParameter("email");
			
			vo.setName(name);
			vo.setEmail(email);
			
			List membersList = dao.searchMember(vo);
			request.setAttribute("membersList", membersList);
			nextpage = "/mem4.do?action=listMembers";

		}else if (action.equals("foreachSelect")) {

			String name = request.getParameter("name");
			List<MemberVO> memList = dao.foreachSelect(name);
			
			request.setAttribute("memList", memList);
			
			nextpage = "test03/listMembers.jsp";
			
		}else if (action.equals("foreachInsert")) {
			
			List<MemberVO> memList = new ArrayList<MemberVO>();
			memList.add(new MemberVO("m1","1234","È«±æÀ×µ¿","m1@test.com"));
			memList.add(new MemberVO("m2","1234","È«À×µ¿","m2@test.com"));
			memList.add(new MemberVO("m3","1234","±æÀ×µ¿","m3@test.com"));
			
			int result = dao.foreachInsert(memList);
			
			nextpage = "test03/listMembers.jsp";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextpage);
		dispatcher.forward(request, response);
		
		
	}
}
