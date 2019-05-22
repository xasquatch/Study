<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="id" value="홍길동" scope="page" />
<c:set var="pwd" value="1234" scope="page"></c:set>
<c:set var="name" value="${'홍길동'}" scope="page"></c:set>
<c:set var="age" value="${22}" scope="page"/>
<c:set var="height" value="${177 }" scope="page"></c:set>

<c:remove var="age" scope="page"/>
<c:remove var="height" scope="page"/>
<!-- 
변수값을 제거 후 출력시에 
JAVA코드와는 다르게 변수 제거시 NULLPOINTEXCEPTION 예외가 발생하지 않고 알아서 공백처리됨
-->

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>member3.jsp</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="lightgray">
			<td width="7%"><b>ID</b></td>
			<td width="7%"><b>PW</b></td>
			<td width="7%"><b>NAME</b></td>
			<td width="7%"><b>AGE</b></td>
			<td width="7%"><b>HEIGHT</b></td>
		</tr>
		<tr>
			<td>${id }</td>
			<td>${pwd }</td>
			<td>${name }</td>
			<td>${age }</td>
			<td>${height }</td>
		</tr>
	</table>

</body>
</html>