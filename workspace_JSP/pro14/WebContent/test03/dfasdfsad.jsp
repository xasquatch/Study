<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${1+1 == 2}">
		<h1>연산출력</h1>
	</c:if>
	<c:if test="${true}">
		<h1>true조건출력</h1>
	</c:if>
	<BR><BR>
	<c:choose>
		<c:when test="${false}">false</c:when>
		<c:when test="${1==2}">true</c:when>
		<c:otherwise>default 출력</c:otherwise>
	</c:choose>
	<BR><BR>
</body>
</html>