<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="model1.BoardDao" %>
<%@ page import="model1.Board" %>
<%
	/* *** ���� API ��� **************************************************************** 
		request.setCharacterEncoding() - request�ȿ� ����ִ� �Ű��������鿡 ���� ���ڵ� ����
		request.getParameter() - �Ű��������� ������ ���Ǵ� getter�ż���
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
	// boardDao.insertBoard()�޼��忡 �Ű������� �Է��� ���� ����
	Board board = new Board();
	board.setBoardPw(boardPw);
	board.setBoardTitle(boardTitle);
	board.setBoardContent(boardContent);
	board.setBoardUser(boardUser);
	
	int row = boardDao.insertBoard(board); // row�� 1�̸� �Է¼���, �ƴϸ� �Է½���
	
	response.sendRedirect(request.getContextPath()+"/model1_board/boardList.jsp");
%>