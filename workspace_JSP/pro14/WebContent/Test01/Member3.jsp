<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="bean" class="sec01.ex01.MemberBean"></jsp:useBean>
<!-- 전송된 회원정보를 빈의 속성에 설정합니다. -->
<jsp:setProperty property="*" name="bean"/>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table border="1" align="center">
		<tr align="center" bgcolor="gray">
			<td width="20%"><b>ID</b></td>
			<td width="20%"><b>PW</b></td>
			<td width="20%"><b>NAME</b></td>
			<td width="20%"><b>EMAIL</b></td>
		</tr>
		<!-- 표현식을 이용해 회원정보 출력.-->
		<tr>
			<td><%= bean.getId()%></td>
			<td><%= bean.getPwd()%></td>
			<td><%= bean.getName()%></td>
			<td><%= bean.getEmail()%></td>
		</tr>
		<!-- bean의 id와 속성 이름으로 접근해 회원정보를 출력합니다.-->
		<tr>
			<td>${bean.id}</td>
			<td>${bean.pwd}</td>
			<td>${bean.name}</td>
			<td>${bean.email}</td>
		</tr>
		
		
	</table>
</body>
</html>