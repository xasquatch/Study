<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="model1.BoardDao" %>
<%@ page import="model1.Board" %>
<%
	/* *** 사용된 API 요약 **************************************************************** 
		request.setCharacterEncoding() - request안에 들어있는 매개변수값들에 대한 인코딩 설정
		request.getParameter() - 매개변수값을 읽을때 사용되는 getter매서드
	********************************************************************************** */
	request.setCharacterEncoding("euc-kr");
	String boardPw = request.getParameter("boardPw");
	//System.out.println("param boardPw:"+boardPw);
	String boardTitle = request.getParameter("boardTitle");
	//System.out.println("param boardTitle:"+boardTitle);
	String boardContent = request.getParameter("boardContent");
	//System.out.println("param boardContent:"+boardContent);
	String boardUser = request.getParameter("boardUser");
	//System.out.println("param boardUser:"+boardUser);
	
	BoardDao boardDao = new BoardDao();
	// boardDao.insertBoard()메서드에 매개변수로 입력할 값을 설정
	Board board = new Board();
	board.setBoardPw(boardPw);
	board.setBoardTitle(boardTitle);
	board.setBoardContent(boardContent);
	board.setBoardUser(boardUser);
	
	int row = boardDao.insertBoard(board); // row가 1이면 입력성공, 아니면 입력실패
	
	response.sendRedirect(request.getContextPath()+"/model1_board/boardList.jsp");
%>