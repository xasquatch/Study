<%@page import="mymember.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String id = (String)session.getAttribute("id");
String pass = request.getParameter("pass");

MemberDao dao = new MemberDao();
boolean check = dao.checkUser(id, pass);

if(check) {
	response.sendRedirect("change_info.jsp");
} else {
	%>
	<script>
		alert("비밀번호가 틀립니다.");
		history.back();
	</script>
	<%
}
%>