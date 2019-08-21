<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>fmt라이브러리에 속한 formatNumber태그를 이용한 숫자 포맷팅 예제</h2>
	숫자로 표시:
		<c:set value="100000000" var="price"/>
		<fmt:formatNumber type="number" value="${price}"  var="priceNumber"/>
	<hr>
		일반 숫자로 표현시 : ${priceNumber}
	<hr>
	<!-- currencySymbol="￦" 원하는 문자로 표시합니다
		groupingUsed="true" 세자리 숫자마다 콤마(,)로 표시(생략된 기본값이 true속성)
		
	 -->
	통화로 표시:
		<fmt:formatNumber type="currency" value="${price}" currencySymbol="￦" groupingUsed="true" />
	<hr>
	퍼센트로 표시:
		<fmt:formatNumber type="percent" value="${price/100000000 }" groupingUsed="false"/>
	<hr>
	<h2>formatdate 예제</h2>
	
	<c:set var="now" value="<%=new Date() %>"/>
		<!-- dateStyle : 날자 표현범위
				- ex) 기본값 = 2019년 5월 27일 
				- full = 2019년 5월 27일 월요일
				- short = 19. 5. 27
			 type : 표현형식 범위
				- ex) date = 기본값
				- time = 오후 4:17:02
				- both = 2019. 5. 27 오후 4:18:17 (날짜 시간 둘다)
				- 그 외 pattern 키워드로 표현형식 직접 설정가능
		 -->
	
			날짜로 표현 : <fmt:formatDate value="${now }" type="date" dateStyle="full"/>
		<HR>
			타입(short) :<fmt:formatDate value="${now }" type="date" dateStyle="short"/>
		<HR>
			타입(time) :<fmt:formatDate value="${now }" type="time"/>
		<HR>
			<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>
		<hr>
			<fmt:formatDate value="${now }" pattern="YYYY-MM-dd hh:mm:ss"/>
		<hr>
			한국 현재 시간:
			<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>
		<BR>
			<!-- timeZone : value속성에 따라 현재 시간에서 시차가 계산되어 출력됨 -->
			<fmt:timeZone value="America/New York">
				뉴욕 현재 시간: <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>
			</fmt:timeZone>
		
		
		
		
		
		
		
		
		
		
		
		
		
</body>
</html>