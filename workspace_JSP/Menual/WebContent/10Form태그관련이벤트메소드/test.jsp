<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
	String name = request.getParameter("a");	
	out.println("입력한값 : " + name);
	System.out.println(name);
%>