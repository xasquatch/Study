<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String contextPath = request.getContextPath();
	request.setCharacterEncoding("UTF-8");
	
	//다운로드할 파일 이름 얻기
	String file1 = request.getParameter("param1");
	String file2 = request.getParameter("param2");
	
	
%>
파일 내려받기<BR>
<a href="<%=contextPath%>/download.do?filename=<%=URLEncoder.encode(file1,"utf-8")%>">file1 click!</a><br>
<a href="<%=contextPath%>/download.do?filename=<%=URLEncoder.encode(file2,"utf-8")%>">file2 click!</a><br>

<a href="<%=contextPath%>/download.do?filename=<%=file1%>">node ver. click!</a><br>

</body>
</html>