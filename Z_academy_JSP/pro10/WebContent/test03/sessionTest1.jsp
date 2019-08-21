<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기는 sessionTest1.jsp입니다.</h1>
	<%
		session.setAttribute("sessionVal", "이것은 세션영역에 저장할 값");
		
		
	%>
</body>
</html>