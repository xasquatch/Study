<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pass = request.getParameter("passwd");

	MemberDAO dao = new MemberDAO();

	int check = dao.userCheck(id,pass);//4. 1 -> 아이디 비밀번호 맞음 , 0 -> 아이디맞음비밀번호 틀림 , -1 -> 아이디틀림
	
	//5.
	if(check == 1){	//로그인화면에서 입력한 아이디비밀번호가 DB에 저장되어 있을 때
					//로그인화면에서 입력한 아이디값을 "세션영역에 세션값으로 저장"
		session.setAttribute("id", id);
		response.sendRedirect("../index.jsp");
	}else if(check == 0){
		%><script>alert("pw틀림");history.back();</script><!-- 이전페이지로 이동 --><%
	}else{
		%><script>alert("id틀림");history.back();</script><!-- 이전페이지로 이동 --><%
	}
	
%>
