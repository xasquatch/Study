<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	th{
		font-size: 35;
	}
</style>

<title>Insert title here</title>
</head>
<body>
<%--<c:if>
 	└ 자바에서 if문과 같은 역할을 하는 JSTL태그
 		JSTL if문에는 else가 없음(대신 cause when 사용)
 		
 	<c:if>태그형식
 		<c:if test="${ 조건식 }" var="변수이름" scope="변수의 접근범위(page,request,session, application)"> 
			위의테스트속성에 조건식이 만족하면 실행될 문장;
 		</c:if>
--%>	
	<c:set var="id" value="hong" scope="page"/>
	<c:set var="pwd" value="1234" scope="page"/>
	<c:set var="name" value="${'홍길동'}" scope="page"/>	<!-- ← 갑분 EL식 -->
	<c:set var="age" value="${22 }" scope="page"/>
	<c:set var="height" value="${177 }" scope="page"/>
	<table border="1" align="center">
		<tr>
		<c:if test="${true }" var="오잉?"> <!-- 조건식의 값의 true이므로 실행문을 실행함 -->
			<th>항상 참</th>
		</c:if>
		</tr>
		<tr>
		<c:if test="${11==11}" var="엥?">
			<th>둘다 같음</th>
		</c:if>
		</tr>
		<tr>
		<c:if test="${11 != 31}">
			<th>같지않음</th>
		</c:if>
		</tr>
		<tr>
		<c:if test="${((id=='hong')&&(name=='홍길동'))}">
			<th>아이디 : ${id}, 이름 : ${name}</th>
		</c:if>
		</tr>
		<tr>
		<c:if test="${age == 22}">
			<th>나이 : ${age }</th>
		</c:if>
		</tr>
		<tr>
		<c:if test="${height > 160}">
			<th>${name}의 키는 160보다 큰  ${height}입니다</th>
		</c:if>
		</tr>
		
	</table>
	
	
	
</body>
</html>