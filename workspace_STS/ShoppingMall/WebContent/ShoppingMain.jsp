<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!-- CSS START LINE-->
<style type="text/css">
	body{
		background-color: black;
		
		
		
		
		
	}
</style>
<!-- CSS END LINE-->
</head>
<body>
<!-- 	파라미터 값을 통하여 (left값 center값이 있느냐에 따라 화면구성을 틀리게) -->
		<c:if test="${center == null}">
			<c:set var="center" value="${center }"/>
		</c:if>	
		<c:if test="${not(center == null)}">
			<c:set var="center" value="Center.jsp"/>
		</c:if>
	<c:set var="left" value="${left}"/>
	
	
	
<center>	
	<table width="1000">
		<!-- TOP부분 설정 -->
		<tr height="80" align="center">
			<td align="center" colspan="2"><c:import url="Top.jsp"></c:import><td> 
		</tr>
		<!-- Center설정 부분 -->
		<tr height="470">
			<c:if test="${left == null }">
				<td align="center">
					<jsp:include page="Center.jsp"></jsp:include> 
				</td>
			</c:if>
			<c:if test="${left != null }">
				<td align="center" width="200">
					<c:import url="${left.jsp}"></c:import> 
				</td>
				<td align="center" width="800">
					<c:import url="${Center.jsp}"></c:import> 
				</td>
			</c:if>
		</tr>
		<!-- Bottom설정부분 -->
		<tr height="80" align="center">
			<td align="center" colspan="2">
				<c:import url="Bottom.jsp"></c:import>
			</td>
		</tr>
	</table>
	
	
	<!-- 만약, 처음 shoppingmain.jsp메인화면을 호출하면 자동으로 center화면이 null값이기에
	초기값으로 center.jsp값을 넣어줌 -->
	
</center>

</body>
</html>