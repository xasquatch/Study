<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%request.setCharacterEncoding("utf-8");
	
	List ulist = (List)request.getAttribute("list");
	session.setAttribute("id", ulist.get(0));
	session.setAttribute("name", ulist.get(2));
	session.setAttribute("email", ulist.get(3));
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width-device-width, user-scalable=no">
<title>Insert title here</title>
</head>
<body align="center">
	
	아이디 ${list[0]}로 회원가입이 완료되었습니다.<BR>
	${list[2]}님의 ${list[3]} 이메일 계정으로 계정확인바란다. 
</body>
</html>