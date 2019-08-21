<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//param액션태그로 전달된 값을 getParameter()메소드를 이용하여 가져옴
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String img = request.getParameter("imgName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br><br>
	<h1>내 이름은 <%=name %></h1><BR><BR>
	<img src="./image/<%=img %>"/>
	
	
</body>
</html>