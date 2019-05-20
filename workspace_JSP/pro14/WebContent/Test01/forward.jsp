<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	//회원가입창의 request내장객체영역에 다시 새로운 주소정보를 바인딩합니다.
	request.setAttribute("address", "부산시 동래구");
	
%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- member2.jsp로 포워딩합니다. -->
	<jsp:forward page="member2.jsp"></jsp:forward>
</body>
</html>