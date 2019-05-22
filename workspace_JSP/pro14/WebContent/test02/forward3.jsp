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
	
	List list = new ArrayList();
	
	MemberBean bean1 = new MemberBean("lee","1234","이순신","lee@test.com",new Date(System.currentTimeMillis()));
	MemberBean bean2 = new MemberBean("son","1224","손흥민","son@test.com",new Date(System.currentTimeMillis()));
	
	list.add(bean1);
	list.add(bean2);
	
	request.setAttribute("memberlist", list);
%>
	<jsp:forward page="member3.jsp"></jsp:forward>
</body>
</html>