<%@page import="mybean.SawonDTO"%>
<%@page import="dbcp.DBConnectionMgr"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
	
	<jsp:useBean id="dto" class="mybean.SawonDTO"></jsp:useBean>
	<jsp:setProperty property="*" name="dto"/>
	<jsp:useBean id="dao" class="mybean.SawonDAO"></jsp:useBean>
<%
	dao.modifysawon(dto);
%>

	<script>
	alert("수정에 성공하였습니다");
	location.href = "index.jsp";
	</script>

	