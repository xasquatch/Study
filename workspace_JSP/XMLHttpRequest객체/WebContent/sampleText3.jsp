<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//클라이언트에 전달된 값 한글처리
	request.setCharacterEncoding("utf-8");

	String userid = request.getParameter("userid");
	String passwd = request.getParameter("passwd");
	
%>
<%=userid%>, <%=passwd%>