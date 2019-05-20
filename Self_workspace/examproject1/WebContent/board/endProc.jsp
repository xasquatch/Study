<%@page import="myboard.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../inc/loginCheck.jsp" %>
<% 
request.setCharacterEncoding("utf-8"); 

int no = Integer.parseInt(request.getParameter("no"));

BoardDao dao = new BoardDao();
dao.endBoard(no);
%>

<script>
	alert("판매가 종료되었습니다.");
	location.href = "board.jsp";
</script>