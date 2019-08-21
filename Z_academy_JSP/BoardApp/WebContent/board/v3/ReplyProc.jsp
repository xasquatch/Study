<%@page import="com.bean.board.BoardDTO"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.bean.board.BoardDAOImpl"%>
<%@ page language="java" contentType="text.html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	
%>
<jsp:useBean id="dao" class="com.bean.board.BoardDAOImpl"></jsp:useBean>
<jsp:useBean id="dto" class="com.bean.board.BoardDTO"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<%
	dto.setRegdate(new Timestamp(System.currentTimeMillis())); //dto setProperty currentTime 
	
	int num = Integer.parseInt(request.getParameter("num"));
	String keyWord = request.getParameter("keyWord");
	String keyField = request.getParameter("keyField");
	
	BoardDTO parentdto = dao.getBoardInfo(num);
	dao.replyUpPos(parentdto.getPos());
	
	dto.setPos(parentdto.getPos());//부모글--답변글
	dto.setDepth(parentdto.getDepth());//들여쓰기
	
	//부모글의 pos,depth값 + 입력한 답변글 내용을 담고 있는 BoardDTO객체를 dao객체의 replyboard()메소드 호출 시 전달
	dao.replayBoard(dto);
	
	response.sendRedirect("List.jsp");
	
	
	
	
	
	
%>