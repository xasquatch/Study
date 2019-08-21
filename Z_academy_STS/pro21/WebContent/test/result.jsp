<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextpath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
			<table class="table table-hover">
			<tr>
				<td colspan="2">결과</td>
			</tr>
			<tr>
				<td>ID</td>
				<td>PWD</td>
			</tr>
			<tr>
				<td>${userID}</td>
				<td>${passWD}</td>
			</tr>
		</table>
	
	
</body>
</html>