<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- JSTL태그라이브러리 내부의 core라이브러리에 속한 태그들을 사용하기 위한 지시자 선언 -->
<%
	request.setCharacterEncoding("utf-8");
%>
	<%--
	 <c:set>태그를 이용해 변수를 선언합니다
	 value속성에는 표현언어(EL)을 사용해서 초기화 할 수 있음 
	--%>
<c:set var="id" value="홍길동" scope="page" />
<c:set var="pwd" value="1234" scope="page"></c:set>
<c:set var="name" value="${'홍길동'}" scope="page"></c:set>
<c:set var="age" value="${22}" scope="page"/>
<c:set var="height" value="${177 }" scope="page"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
			<!-- 표현언어 EL태그로 변수에 바로 접근하여 값을 얻어 출력 -->
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