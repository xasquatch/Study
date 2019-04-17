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
	String name = (String)request.getAttribute("name");
	String address = (String)request.getAttribute("address");
%>
	<h1>이름은 <%=name %></h1>
	<h2>주소는 <%=address %></h2>
</body>
</html>