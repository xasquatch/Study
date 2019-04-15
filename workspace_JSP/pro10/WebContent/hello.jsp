<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
// 	선언문을 이용해 멤버변수 name과 멤버 메서드 getName()을 선언합니다.
	String name = "duke";		//변수 선언
	public String getName(){	//메소드 선언
		return name;
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 	표현식태그를 이용해 선언문에서 선언한 name변수의 값을 출력합니다. -->
	<h1>안녕하세요<%= name %>님 환영합니다.</h1>
</body>
</html>