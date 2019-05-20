<%@ page import="board.BoardDAO"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>write_pro.jsp</title>
</head>
<body>
<%
	String id = (String) session.getAttribute("id");
	if(id==null)
		response.sendRedirect("login.jsp");
	request.setCharacterEncoding("utf-8");

%>
	<jsp:useBean id="bBean" class="board.BoardBean"/>
	<jsp:setProperty property="*" name="bBean"/>
<%	
	bBean.setDate(new Timestamp(System.currentTimeMillis()));
	bBean.setIp(request.getRemoteAddr());
%>

<%
	BoardDAO bdao = new BoardDAO();
	
	bdao.insertBoard(bBean);
	
	response.sendRedirect("board.jsp");

%>

</body>
</html>