<%@page import="com.sun.org.apache.regexp.internal.recompile"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSP페이지 주석 --%>
<!-- HTML페이지 주석 -->

<%-- 선언문을 이용하여 name변수 선언, getname()메소드 선언 --%>
<%!
	String name = "이순신";
	String name1 = "장보고";
	public String getname(){
		return name;
	}
%>
<%-- 스크립트릿 태그영역에서 자바코드를 작성합니다 --%>
<%
	String age = request.getParameter("age");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>안녕하세요 <%= name %>님</h1>
	<div><%=name1 %>왔다</div>
<!-- 	표현식 태그를 이용해서 전송된 나이를 출력 -->
	<h1>나이는 <%= age %>살입니다</h1>
</body>
</html>


