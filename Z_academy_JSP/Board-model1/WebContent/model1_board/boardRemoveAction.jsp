<%@page import="model1.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>BOARD REMOVE ACTION(��1 ���)</title>
</head>
<body>
<%
	// boardNo �� boardPw���� �Ѿ���� ������ boardList.jsp�� �̵�
	if(request.getParameter("boardNo") == null || request.getParameter("boardPw") == null) {
	    response.sendRedirect(request.getContextPath()+"/model1_board/boardList.jsp");
	} else {
	    int boardNo = Integer.parseInt(request.getParameter("boardNo"));
	    // System.out.println("boardNo :"+boardNo);
	    String boardPw = request.getParameter("boardPw");
	    //System.out.println("boardPw :"+boardPw);
	    BoardDao boardDao = new BoardDao();
        if(boardDao.deleteBoard(boardNo, boardPw)==1){
            response.sendRedirect(request.getContextPath()+"/model1_board/boardList.jsp");
        } else {
            response.sendRedirect(request.getContextPath()+"/model1_board/boardRemoveForm.jsp?boardNo="+boardNo);
        }
	}
%>
</body>
</html>