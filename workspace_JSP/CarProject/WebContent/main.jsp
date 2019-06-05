<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:out value="${center }"/>
	<c:set var="center" value="${param.center }"></c:set><%-- ${request.center } --%>
	
	<c:if test="${empty center }">
		<c:set var="center" value="Center.jsp"></c:set>
	</c:if>
	
	<center>
		<table width="1000px">
			<tr align="center">
				<td>
					<jsp:include page="Top.jsp"></jsp:include>
				</td>
			</tr>
			<tr>
				<td>
					<jsp:include page="${center}"></jsp:include>
				</td>
			</tr>
			<tr>
				<td>
					<jsp:include page="Bottom.jsp"></jsp:include>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>