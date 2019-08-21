<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%--
	JSTL의 fmt란? 국제화/형식화 기능을 제공해주는 JSTL라이브러리 종류중 하나
		국제화 : 다국어 내용처리기능 제공
		형식화 : 날짜와 숫자형식 등을 처리
		
	JSTL fmt라이브러리를 사용할 때는 core라이브러리를 사용할 때 처럼
	JSP페이지에 태그 라이브러리를 등록 해 주어야한다.
 --%>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>숫자르 원하는 형태로 출력하기 위한 formatting라이브러리</h1>
	<div bgcolor="gray">
	숫자를 뿌려보자 <br>
	100000<br>
	</div>
	<hr>
	
	<div bgcolor="gray">위 숫자를 3자리마다 ,로 구분하여 나타내기 > groupingUsed="true"를 사용함
	groupingUsed="false"로 하면 3자리마다 ,로 구분하지 않음</div><br>
	<c:set value="100000" var="num" />
	<fmt:formatNumber value="${num }" groupingUsed="true"/><hr>
	<fmt:formatNumber value="${num }" groupingUsed="false"/><hr>	
	
	<% double pi = Math.PI; %>
	<%=pi%>를 소수점 자리수 2자리 까지만 표현하기
	pattern속성에 숫자에 대응하는 문자는 #으로 처리하고 자리수는 .으로 소수점 자리수를 표현함
	<!-- pattern속성 소수점 표현방식
		# : 공백은 미출력
		0 : 공백을 0으로 출력
	 -->
	
	<hr>
	<fmt:formatNumber value="<%=pi%>" pattern="#.##"/>
	<hr>
		10.5는 소수점 1번째자리까지 있는데 소수점 2번째 까지 나타내려면<br>
	<fmt:formatNumber value="10.5" pattern="#.00"/>
	<hr>
	type이라는 속성에 percent(퍼센트), currency(통화량) 지정<br>
	 그러면 value속성값을 백분율 단위로 계산해서 처리해준다.<br>
	 <!-- 주의  percent타입 설정시 100%는 1과 같음 10을
	  퍼센트로 변환시 1000출력-->
	<fmt:formatNumber value="0.5" type="percent"/><br>
	<fmt:formatNumber value="0.5" type="currency"/>
	<hr>
	type이라는 속성에 통화량(currency)를 지정하면 지정한 표시로 설정됨(groupingUsed는 미설정시 기본값 true)<br>
	<fmt:formatNumber value="25000000" type="currency" currencySymbol="메소"/><br>
	<hr>
	<h2>날짜 형식 지정</h2>
	<br>
	<c:set var="date" value="<%=new Date()%>"></c:set>
	<fmt:formatDate value="${date }" type="both" /><br>
	<fmt:formatDate value="${date }" type="date" /><br>
	<fmt:formatDate value="${date }" type="time" /><br>
	<br><br><br>
	<fmt:formatDate value="${date }" dateStyle="full"/>
	<hr>
	<fmt:formatDate value="${date }" dateStyle="long"/>
	<hr>
	<fmt:formatDate value="${date }" dateStyle="medium"/>
	<hr>
	<fmt:formatDate value="${date }" dateStyle="short"/>
	<hr>
	<br><BR><BR>
	<fmt:formatDate value="${date }" type="time" timeStyle="full"/>
	<hr>
	<fmt:formatDate value="${date }" type="time" timeStyle="long"/>
	<hr>
	<fmt:formatDate value="${date }" type="time" timeStyle="medium"/>
	<hr>
	<fmt:formatDate value="${date }" type="time" timeStyle="short"/>
	<hr>
	<BR><BR><BR>
	예제1: <fmt:formatDate value="${date }" type="both" pattern="YYYY년 MM월 dd일 (E) a hh시 mm분 ss초"/>
	
	<BR><BR><BR>
	예제2: <fmt:formatDate value="${date }" type="date" pattern="YYYY/MM/dd (E)"/>
	
	<BR><BR><BR>
	예제3: <fmt:formatDate value="${date }" type="time" pattern="(a) hh:mm:ss"/>
	
	
	<div id="id"></div>
	<script type="text/javascript">
		location = "http://localhost:8090/pro14/test05/formatNumber.jsp#id";
	</script>
</body>
</html>