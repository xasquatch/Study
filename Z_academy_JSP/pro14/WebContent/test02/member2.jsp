<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" style="background-color:black; color:white;">
			<td width="20"><b>ID</b></td>
			<td width="20"><b>PW</b></td>
			<td width="20"><b>NAME</b></td>
			<td width="20"><b>EMAIL</b></td>
		</tr>
		<tr align="center">
			<td>${requestScope.member.id }</td>
			<td>${requestScope.member.pwd }</td>
			<td>${requestScope.member.name }</td>
			<td>${requestScope.member.email }</td>
		</tr>
	</table>
</body>
</html>