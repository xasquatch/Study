<%@page import="java.util.Iterator"%>
<%@page import="sec01.ex01.MemberBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>member3</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	
	session.setAttribute("address", "부산");
	
%>
	<table border="1" align="center">
		<tr align="center">
			<td colspan="5"><img src="../popcorn.gif" Style="text-align:center;"></td>
		</tr>
		<tr align="center" bgcolor="powderblue">
			<td width="20"><b>ID</b></td>
			<td width="20"><b>PW</b></td>
			<td width="20"><b>NAME</b></td>
			<td width="20"><b>EMAIL</b></td>
			<td width="20"><b>ADDRESS</b></td>
		</tr>
		<tr align="center">
			<td>${id}</td>
			<td>${pwd}</td>
			<td>${name }</td>
			<td>${email }</td>
			<td>${address }</td>
		</tr>
	</table>
	
</body>
</html>