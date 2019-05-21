<%@page import="board.BoardDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>reWrite_pro.jsp</title>
</head>
<body>
<h1>reWrite_pro.jsp</h1>
<%
	request.setCharacterEncoding("UTF-8");

%>
<jsp:useBean id="bBean" class="board.BoardBean"/>
<jsp:setProperty property="*" name="bBean"/>
<%
	bBean.setDate(new Timestamp(System.currentTimeMillis()));
	bBean.setIp(request.getRemoteAddr());
	
	// 객체 생성
	BoardDAO dbao = new BoardDAO();
	
	// (자식글 답변내용,부모글의 그룹번호,들여쓰기번호,위치번호)를 지니고 있는 bBean객체 넘기기
	dbao.reInsertBoard(bBean); 
	
	response.sendRedirect("board.jsp");
%>

</body>
</html>