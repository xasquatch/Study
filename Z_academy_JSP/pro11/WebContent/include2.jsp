<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	HELLO   &lt;start&gt;<BR><BR>
		
		<jsp:include page="duke_image.jsp">
			<jsp:param value="시저" name="name"/>
			<jsp:param value="rr.jpg" name="imgName"/>
		</jsp:include>
	
	BYE		&lt;end&gt;<BR><BR>
</body>
</html>