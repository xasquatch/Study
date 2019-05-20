<%@page import="board.FileBoardDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>freWrite_pro.jsp</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");

%>
<jsp:useBean id="fdto" class="board.FileBoardDTO"/>
<jsp:setProperty property="*" name="fdto"/>
<%
	fdto.setDate(new Timestamp(System.currentTimeMillis()));
	fdto.setIp(request.getRemoteAddr());
	
	// 객체 생성
	FileBoardDAO fdao = new FileBoardDAO();
	
	// (자식글 답변내용,부모글의 그룹번호,들여쓰기번호,위치번호)를 지니고 있는 bBean객체 넘기기
	fdao.reInsertfBoard(fdto); 
	
	response.sendRedirect("fboard.jsp");
%>

</body>
</html>