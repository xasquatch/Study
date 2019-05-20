<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 로그아웃을 위해..세션영역의 값 초기화 
	session.invalidate(); // 세션영역의 값 모두 제거
%>
<!-- <script type="text/javascript">
	alert("로그아웃!");
	location.href="../bootstrap/index.jsp"; // 다시 메인페이지
</script> -->
<%		
	// 다시 메인페이지로 이동되도록 페이지 흐름 바꾸기 
	response.sendRedirect("../bootstrap/index.jsp"); 
%>
