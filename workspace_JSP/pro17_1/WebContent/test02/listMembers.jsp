<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    

<%
	request.setCharacterEncoding("UTF-8");
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>request영역에 바인딩된 검색한 회원정보 출력창</title>
	<style type="text/css">
		.cls1{
			font-size: 40px;
			text-align: center;
		}
		.cls2{
			font-size: 20px;
			text-align: center;
		}
	</style>
</head>
<body>
	<p class="cls1">회원정보</p>
	<table align="center" border="1">
		<tr align="center" bgcolor="yellow">
			<td width="7%"><b>아이디</b></td>
			<td width="7%"><b>비밀번호</b></td>
			<td width="7%"><b>이름</b></td>
			<td width="7%"><b>이메일</b></td>
			<td width="7%"><b>가입일</b></td>		
		</tr>
<c:choose>
	<c:when test="${list == null }">
		<tr>
			<td colspan="5"><b>등록된 회원이 없습니다.</b></td>
		</tr>
	</c:when>	
	<c:when test="${list != null }">
		<c:forEach var="memberVO" items="${list}">
		<tr>
			<td>${memberVO.id}</td>
			<td>${memberVO.pwd}</td>
			<td>${memberVO.name}</td>
			<td>${memberVO.email}</td>
			<td>${memberVO.joinDate}</td>
		</tr>		
		</c:forEach>
	</c:when>
</c:choose>
	</table>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<a href="${contextPath}/member/memberForm.do"><p class="cls2">회원가입하기</p></a>
</body>
</html>









