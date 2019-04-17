<%@page import="java.util.Date"%>
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
	
	Date date1 = (Date)request.getAttribute("currTime");
	
%>
	현재 시간은 <%=date1 %><BR><BR>
<%
	request.setAttribute("currTime", new Date());

	date1 = (Date)request.getAttribute("currTime"); 
%>
	현재 시간은 <%=date1 %><BR><BR>
<%

	request.removeAttribute("currTime");
	
	date1 = (Date)request.getAttribute("currTime"); 
%>
	현재 시간은 <%=date1 %>

</body>
</html>