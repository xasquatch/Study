<%@page import="java.util.List"%>
<%@page import="sec01.ex01.MemberBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	
	request.setAttribute("id", "hong");
	request.setAttribute("pwd", "1234");
	session.setAttribute("name", "hongildong");
	application.setAttribute("email", "hong@test.com");
	//request내장객체에 address속성 이름으로 바인딩
	
	request.setAttribute("address", "서울");
// 	response.sendRedirect("./member4.jsp");
%>
	<jsp:forward page="member4.jsp"></jsp:forward>
</body>
</html>