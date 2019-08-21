<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	//request내장 객체 영역에 바인딩
	request.setAttribute("id", "hong");
	request.setAttribute("pwd", "1234");
	
	//session내장객체영역에 바인딩
	session.setAttribute("name", "홍길동");
	//application내장객체영역에 바인딩
	application.setAttribute("email", "hong@test.com");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 	member1.jsp로  포워딩 -->
<jsp:forward page="member1.jsp"></jsp:forward>
</body>
</html>