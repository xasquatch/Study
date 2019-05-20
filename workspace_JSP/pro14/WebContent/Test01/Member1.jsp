<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	//표현식으로 출력하기 위해 request객체의 getparameter()메소드를 이용해
	//요청한 회원정보를 가져옴
	
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>입력한 회원정보 출력창</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="gray">
			<td width="20%"><b>ID</b></td>
			<td width="20%"><b>PW</b></td>
			<td width="20%"><b>NAME</b></td>
			<td width="20%"><b>EMAIL</b></td>
		</tr>
		<!-- ▽getparameter()메소드로 가져온 회원정보를 표현식으로 출력 -->
		<tr>
			<td><%=id %></td>
			<td><%=pwd %></td>
			<td><%=name %></td>
			<td><%=email %></td>
		</tr>
		<!-- ▽param내장객체를 이용해 request내장객체에 접근하고
			getparameter()메소드를 이용하지 않고 바로 회원정보를 출력
		-->
		<tr>
			<td>${param.id}</td>
			<td>${param.pwd}</td>
			<td>${param.name}</td>
			<td>${param.email}</td>
		</tr>
	</table>
</body>
</html>