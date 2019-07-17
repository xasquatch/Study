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
		//web.xml에 확장자가 .do의 요청주소를 전달하여 재요청
		//response.sendRedirect("hello.do");
	
		response.sendRedirect("index.do");
	
	%>


</body>
</html>





