<%@page import="board.CommentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>댓글</title>
</head>
<body>

<%
	request.setCharacterEncoding("utf-8");
%>
	<jsp:useBean id="cb" class="board.CommentDTO" />
	<jsp:setProperty property="*" name="cb" />
<%
	String num = request.getParameter("ref");
	String pageNum = request.getParameter("page");

	CommentDAO cdao = new CommentDAO();
	cdao.insertComment(cb);
%>
<!-- 댓글 정보 새로고침 -->
<meta http-equiv="Refresh" content="0; url=fcontent.jsp?num=<%=num%>&pageNum=<%=pageNum%>">

</body>
</html>