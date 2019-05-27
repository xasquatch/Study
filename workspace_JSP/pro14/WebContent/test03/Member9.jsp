<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center" border="1">
		<tr align="center" bgcolor="lightgray">
			<th width="7%">ID</th>
			<th width="7%">PW</th>
			<th width="7%">NAME</th>
			<th width="7%">EMAIL</th>
		</tr>
<c:choose>
	<c:when test="${empty param.id }">
		<tr align="center">
			<th colspan="5">아이디를 입력하세</th>
		</tr>
	</c:when>
	<c:otherwise>
		<tr align="center">
			<td><c:out value=" ${param.id }"></c:out></td>
			<td><c:out value=" ${param.pwd }"></c:out></td>
			<td><c:out value=" ${param.name }"></c:out></td>
			<td>${param.email }</td>
		</tr>
	</c:otherwise>
</c:choose>
	</table>

</body>
</html>