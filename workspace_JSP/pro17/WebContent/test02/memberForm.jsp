<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%request.setCharacterEncoding("utf-8");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>JOIN FORM</h2>
	<form action="${pageContext.request.contextPath }/member/addMember.do" method="POST" align="center">
		ID : <input type="text" name="userid"><BR>
		PassWord : <input type="password" name="userpw"><BR>
		Full Name : <input type="text" name="username"><BR>
		email : <input type="text" name="useremail"><BR>
		<input type="submit" value="JOIN"><input type="reset" value="RESET">
	</form>
	<h2 align="center">${notice}</h2>
</body>
</html>