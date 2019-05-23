<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("utf-8"); %>
	<c:set var="id" value="hong" scope="page"/>
	<c:set var="pwd" value="1234" scope="page"/>
	<c:set var="name" value="${'홍길동'}" scope="page"/>	<!-- ← 갑분 EL식 -->
	<c:set var="age" value="${22 }" scope="page"/>
	<c:set var="height" value="${177 }" scope="page"/>
<%--
	<c:choose>태그
	-> 자바의 switch문의 기능을 수행함

	<c:choose>
		<c:when test="${조건식}">
			결과
		</c:when>
		<c:when test="${조건식}">
			결과
		</c:when>
		<c:otherwise>
			default 출력
		</c:otherwise>
	</c:choose>
	
 --%>
 	<table border="1" align="center">
 	<c:choose>
 		<%-- <c:when test="${name == null }">이름입력좀</c:when> --%>
 		<c:when test="${empty name}"><td>이름입력좀<td></c:when>
 		<c:otherwise><td>${id}</td><td>${pwd}</td><td>${name}</td><td>${age}</td><td>${height}</td></c:otherwise>
 	</c:choose>
 	</table>	
 
	
</body>
</html>