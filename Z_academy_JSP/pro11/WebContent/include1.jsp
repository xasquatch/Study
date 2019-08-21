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
	안녕하세요. JSP시작입니다.
	<BR>
<!-- 	duke_image.jsp를 동적으로 포워딩합니다. -->
	<jsp:include page="./duke_image.jsp">
		<jsp:param name="name" value="코난" />
		<jsp:param name="imgName" value="rrr.jpg"/>
	</jsp:include>
	<br>
	끝입니다.
</body>
</html>