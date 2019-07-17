<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSTL core라이브러리 태그 사용을 위한 지시자 선언 -->    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="black">

<center>
	<!-- 파라미터를 통하여 (left값 센터값이 있느냐에 따라 화면 구성을 틀리게) -->
	<c:set var="center" value="${center}"/>
	<c:set var="left" value="${left }"/>
	
	<!-- 만약 ~ 처음 ShoppingMain.jsp메인화면을 요청하면  자동으로 center값이 null이기에..
	      초기값으로 Centger.jsp값을 넣어줌
	 -->
	 <c:if test="${center==null}">
	 	<c:set var="center" value="Center.jsp"/>
	 </c:if>
	 
	 <table width="1000">
	 	<!-- Top 설정 부분 -->
	 	<tr height="80" align="center">
	 		<td align="center" colspan="2"><jsp:include page="Top.jsp"/></td>
	 	</tr>
	 
	 	<!-- 센터 설정 부분 -->
	 	<tr height="470" align="center"  valign="top">
	 		<c:if test="${left == null }">
	 			<td align="center">
	 				<jsp:include page="${center}"/>
	 			</td>
	 		</c:if>
	 		<c:if test="${left != null}">
	 			<td align="center" width="200">
	 				<jsp:include page="${left}"/>	
	 			</td>
	 			<td align="center" width="800">
	 				<jsp:include page="${center}"/>
	 			</td>
	 		</c:if>
	 		
	 	</tr>
	 
	 	<!-- Bottom 설정 부분 -->
	 	<tr height="80" align="center">
	 		<td align="center" colspan="2">
	 			<jsp:include page="Bottom.jsp"/>
	 		</td>
	 	</tr> 
	 </table>
</center>	 
	
	
	
</body>
</html>












