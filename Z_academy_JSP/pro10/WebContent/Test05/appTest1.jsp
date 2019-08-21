<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//session 내장객체 영역에 값을 저장
	session.setAttribute("name", "이순신"); //웹브라우저가 닫기기 전까지 계속 유지되는 session 영역

	//어플리케이션 내장객체 영역에 값 저장
	application.setAttribute("address", "서울시 강남구"); //웹 어플리케이션이 중지되기 전까지 유지되는 application 영역(ex : tomcat stop)
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이름과 주소 각각의 내장객체 영역에 저장</h1>
	<a href="./appTest2.jsp">두 번째 웹페이지로 재요청</a>
</body>
</html>