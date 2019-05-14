<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

	String userid = request.getParameter("userid");
	String passwd = request.getParameter("passwd");
	
	String jsonData = "{'userid':'"+userid+"','passwd':'"+passwd+"'}"; 
	
	out.println(jsonData);//클라이언트의 웹브라우저로 응답
	
%>

