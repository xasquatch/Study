<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//세션객체에 바인딩된 name값과 address값을 꺼내옴
		String name = (String)session.getAttribute("name");
		String address = (String)session.getAttribute("address");
		
	%>
	<h1><%= name + " / " + address %></h1>

</body>
</html>