<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set value="<%=new Date()%>" var="date"></c:set>
	<h2>우리나라</h2>
	<fmt:setLocale value="ko_kr" />
	
	<!-- 숫자로 출력할 떄는 우리나라는 ￦표시로 출력된다. -->
	금액 : <fmt:formatNumber value="100000000" type="currency"/><BR>
	날짜 : <fmt:formatDate value="${date }" dateStyle="full"/><BR><BR>
	시간 : <fmt:formatDate value="${date }" timeStyle="full"/><BR><BR>
	
	<h2>남의나라1</h2>
	<fmt:setLocale value="en_us" />
	
	금액 : <fmt:formatNumber value="100000000" type="currency"/><BR>
	날짜 : <fmt:formatDate value="${date }" dateStyle="full"/><BR><BR>
	시간 : <fmt:formatDate value="${date }" timeStyle="full"/><BR><BR>
	
	<h2>남의나라2</h2>
	<fmt:setLocale value="ja_jp" />
	
	금액 : <fmt:formatNumber value="100000000" type="currency"/><BR>
	날짜 : <fmt:formatDate value="${date }" dateStyle="full"/><BR><BR>
	시간 : <fmt:formatDate value="${date }" timeStyle="full"/><BR><BR>
	
	<hr>
	<h1>세계시간</h1>
	서울 : <fmt:formatDate value="${date }" type="both"/><BR><BR>
	<fmt:timeZone value="asia/Hong_Kong">
		홍콩 : <fmt:formatDate value="${date }" type="both"/><BR><BR>
	</fmt:timeZone>
	<fmt:timeZone value="Euroup/London">
		런던 : <fmt:formatDate value="${date }" type="both"/><BR><BR>
	</fmt:timeZone>
	
	
	
	
	
	
	
	
	<div id="end"><b>END</b></div>
	<script type="text/javascript">
		location = "http://localhost:8090/pro14/test05/setLocale.jsp#end" 
	</script>
	
</body>
</html>