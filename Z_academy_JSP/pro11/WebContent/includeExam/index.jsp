<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int i = 10;
%>
<!-- 헤더 -->
<%@include file="../includes/header.jsp" %>
<!-- 본문 -->
<HR>
<h1>include 액션태그 예제1</h1>
이 페이지는 action tag를 이용한 include를 사용하고 있습니다.
<HR>
<!-- 하단 -->
<jsp:include page="/includes/footer.jsp"/>