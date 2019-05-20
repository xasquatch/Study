<%@page import="mymember.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
String pass = request.getParameter("pass");

MemberDao dao = new MemberDao();

boolean check = dao.checkUser(id, pass);
if(check) {
	session.setAttribute("id", id);
	%>
	<script>
		opener.location.href = "../index.jsp";
		window.close();
	</script>
	<%
} else {
	%>
	<script>
		alert("아이디 또는 비밀번호가 틀립니다.");
		history.back();
	</script>
	<%
}
%>