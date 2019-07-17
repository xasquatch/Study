<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="800" border="0" height="470">
		<c:set var="j" value="0"/>
		
		<c:forEach items="${list}" var="subean" >
			<c:if test="${j % 4 == 0}">
				<tr align="center">
			</c:if>
					<td width="200" height="300">
						<a href="suinfo.do?suno=${subean.suno}">
							<img src="img/${subean.suimg}" width="190" height="180">
						</a>
						<font color="white" size="2">
							공구명 : ${subean.suname}<br>
							판매금액 : ${subean.suprice}원<br>
						</font>
					</td>
			<c:set var="j" value="${j+1}"/>
			
		</c:forEach>
			<tr/>
	</table>
	
	
</body>
</html>