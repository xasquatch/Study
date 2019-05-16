<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//세션값 초기화
	session.invalidate();

	//로그아웃 메시지창 띄움
	//index.jsp 메인페이지 이동
%>
<script>
	alert("로그아웃");
	location.href = "../index.jsp";
</script>