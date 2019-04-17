<%@page import="sun.rmi.server.Dispatcher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//request객체영역에 setAttribute()를 이용해 name키, address키에 해당되는 값을 각각 쌍으로 저장
	request.setAttribute("name", "이순신");
	request.setAttribute("address","부산시 부산진구");
	
// 	RequestDispatcher dispatcher = request.getRequestDispatcher("request2.jsp");
	
// 	dispatcher.forward(request, response);
	
	response.sendRedirect("request2.jsp");
%>