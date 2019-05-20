<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보 출력창</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="gray">
			<td width="20%"><b>ID</b></td>
			<td width="20%"><b>PW</b></td>
			<td width="20%"><b>NAME</b></td>
			<td width="20%"><b>EMAIL</b></td>
			<td width="20%"><b>Address</b></td>
			<td width="20%"><b color="red">requestScope</b></td>
			<td width="20%"><b color="red">param</b></td>			
		</tr>
		<tr>
			<td>${param.id}</td>
			<td>${param.pwd}</td>
			<td>${param.name}</td>
			<td>${param.email}</td>
			<!-- requestScope를 이용해 바인딩된 주소 정보를 얻어 출력합니다 -->
			<td>${requestScope.address}</td>
			<td>${requestScope}</td>
			<td>${param}</td>
		</tr>
	</table>
		
</body>
</html>