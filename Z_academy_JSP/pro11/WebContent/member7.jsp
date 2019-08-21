<%@page import="java.util.List"%>
<%@page import="sec01.ex01.MemberDAO"%>
<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	//memberForm.html페이지에서 요청한 회원내용을 전달 받기 전 request영역에 들어있는 데이터 한글처리
	request.setCharacterEncoding("utf-8");
	
%>
<!-- memberForm.html에서 요청한 값을 받아와 memberBean객체의 변수에 각각 셋팅 -->
	<jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page" />
		<jsp:setProperty name="m" property="*" />


	
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center" width="100%">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%">아이디</td>
			<td width="7%">비밀번호</td>
			<td width="5%">이름</td>
			<td width="11%">이메일</td>
<!-- 			<td width="5%">가입일</td> -->
		</tr>
		<tr align = "center">
<%-- 		<jsp:usebean> 액션태그로 생성한 MemberBean객체의 getter메소드를 호출하여 리턴값을 각자리에 출력 --%>
<%-- 			<td> <jsp:getProperty property="*" name="m"/> </td> --%>
			<td> <jsp:getProperty property="id" name="m"/> </td>
			<td> <jsp:getProperty property="pwd" name="m"/> </td>
			<td> <jsp:getProperty property="name" name="m"/> </td>
			<td> <jsp:getProperty property="email" name="m"/> </td>
		</tr>
</body>
</html>











