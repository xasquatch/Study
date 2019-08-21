<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%request.setCharacterEncoding("UTF-8");%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MEMBER INFORMATION RESULT</title>
</head>
<body>
	<table border="1" align="center" width="100%">
		<tr align="center" bgcolor="lightgray">
			<th>ID</th>
			<th>PASSWORD</th>
			<th>NAME</th>
			<th>EMAIL</th>
		</tr>
		<tr align="center">
			<td>${id}</td>
			<td>${pwd}</td>
			<td>${name}</td>
			<td>${email}</td>
		</tr>
	</table>
	
	
	
</body>
</html>