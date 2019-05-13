<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="model1.Board" %>
<%@ page import="model1.BoardDao" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>BOARD MODIFY ACTION(모델1 방식)</title>
</head>
<body>
<%
	request.setCharacterEncoding("euc-kr");
	if(request.getParameter("boardNo") == null || request.getParameter("boardPw") == null) {
	    response.sendRedirect(request.getContextPath()+"/jsp_board/boardList.jsp");
	} else {
	    int boardNo = Integer.parseInt(request.getParameter("boardNo"));
	    //System.out.println("boardModifyAction param boardNo :"+boardNo);
	    String boardPw = request.getParameter("boardPw");
	    //System.out.println("boardModifyAction param boardPw :"+boardPw);
	    String boardTitle = request.getParameter("boardTitle");
	    //System.out.println("boardModifyAction param boardTitle :"+boardTitle);
	    String boardContent = request.getParameter("boardContent");
	    //System.out.println("boardModifyAction param boardContent :"+boardContent);
	    
	    // 요청정보를 이용하여 매개변수로 보내어 질 Board객체생성
	    Board board = new Board();
	    board.setBoardNo(boardNo);
	    board.setBoardPw(boardPw);
	    board.setBoardTitle(boardTitle);
	    board.setBoardContent(boardContent);
	    BoardDao boardDao = new BoardDao();
	    boardDao.updateBoard(board);
	    response.sendRedirect(request.getContextPath()+"/model1_board/boardView.jsp?boardNo="+boardNo);
	}	
%>
</body>
</html>