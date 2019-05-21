<%@page import="java.sql.Date"%>
<%@page import="sec01.ex01.MemberBean"%>
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
	MemberBean bean = new MemberBean("lee","1234","이순신","lee@test.com",new Date(System.currentTimeMillis()));
	
	request.setAttribute("member", bean);
%>
<jsp:forward page="member2.jsp"></jsp:forward>
</body>
</html>