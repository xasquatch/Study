<%@page import="java.sql.Timestamp"%>
<%@page import="com.bean.board.BoardDTO"%>
<%@page import="com.bean.board.BoardDAOImpl"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	
%>

	<jsp:useBean id="dto" class="com.bean.board.BoardDTO"></jsp:useBean>
	<jsp:setProperty property="*" name="dto"/>
<%
	dto.setRegdate(new Timestamp(System.currentTimeMillis()));
	
	
%>
	<jsp:useBean id="dao" class="com.bean.board.BoardDAOImpl"></jsp:useBean>
	
<%
	dao.insertBoard(dto);
	
	response.sendRedirect("List.jsp");
	
	
%>