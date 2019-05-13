<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="model1.BoardDao" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>BOARD REMOVE ACTION(모델1 방식)</title>
</head>
<body>
<%
	// boardNo 나 boardPw값이 넘어오지 않으면 boardList.jsp로 이동
	if(request.getParameter("boardNo") == null || request.getParameter("boardPw") == null) {
	    response.sendRedirect(request.getContextPath()+"/model1_board/boardList.jsp");
	} else {
	    int boardNo = Integer.parseInt(request.getParameter("boardNo"));
	    // System.out.println("boardNo :"+boardNo);
	    String boardPw = request.getParameter("boardPw");
	    // System.out.println("boardPw :"+boardPw);
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