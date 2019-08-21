<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	//login.jsp페이지에서 요청한 값 한글 인코딩 방식 지정
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty param.userID }">
		아이디 입력하세요<BR>
		<a href="Login.jsp">로그인창으로</a>
	</c:if>
	<c:if test="${not empty param.userID }">
		<h1>환영함 <c:out value="${param.userID }"/>!! </h1>
	</c:if>
</body>
</html>