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
		//session영역의 바인딩값을 가져옴
		String name = (String)session.getAttribute("name");
		//다시 세션객체영역에 address키에 해당하는 "서울시 강남구" 값을 저장
		session.setAttribute("address", "서울시 강남구");	
	
	%>
	<h1>이름은 <%=name %></h1><BR>
	<a href="/pro10/test01/session2.jsp">두 번째 JSP페이지로 이동하기</a>
	
</body>
</html>