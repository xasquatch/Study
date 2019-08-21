<%@page import="mybean.SawonDTO"%>
<%@page import="dbcp.DBConnectionMgr"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	int no = Integer.parseInt(request.getParameter("no"));
%>	
	<jsp:useBean id="dao" class = "mybean.SawonDAO"></jsp:useBean>
<%
	dao.delsawon(no);
%>	
		<script type="text/javascript">
			alert("삭제완료");
			location.href = "index.jsp";
		</script>
		