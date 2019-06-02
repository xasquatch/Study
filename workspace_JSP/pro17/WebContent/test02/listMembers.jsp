<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request영역에 바인딩된 검색한 회원정보 출력창</title>
<style type="text/css">
	.cls1{
		font-size:100px;
		text-align:center;
		font-family: fantasy;
		margin : 0px;
	}
	.cls2{
		font-size:20px;
		text-align:center;
		text-decoration: none;
		color : black;
		font-weight: bold;
	}
</style>
</head>
<body>
	
	<p class="cls1">
	<img src="http://localhost:8090/pro17/img/popcorn.gif" width="100px" height="100px">
	Client Information List
	</p>
	<table border="1" align="center">
		<tr align="center" bgcolor="green">
			<th width="7%">ID</th>
			<th width="7%">PassWord</th>
			<th width="7%">Full NAME</th>
			<th width="7%">Contactable EMAIL</th>
			<th width="7%">Join DATE</th>
		</tr>
		<tr><th colspan="5">CORE-forEach print</th></tr>
		<c:choose>	
			<c:when test="${empty list}">
				<tr><th colspan="5">등록된 회원이 없습니다.</th></tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list}" var="memberVO">
					<tr align="center">
						<td>${memberVO.id }</td>
						<td>${memberVO.pwd }</td>
						<td>${memberVO.name }</td>
						<td>${memberVO.email }</td>
						<td>${memberVO.joindate }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<c:choose>
		<c:when test="${empty session.id}">
			<a href="${pageContext.request.contextPath}/member/memberForm.do" class="cls2">
			<p>JOIN US NOW!</p></a>
		</c:when>
	</c:choose>
	
</body>
</html>