<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--순서1. Post.jsp페이지에서 요청받은 쓴글 내용 한글처리--%>
 <%
 	request.setCharacterEncoding("UTF-8");
 %>

<%--순서2. Post.jsp페이지에서 입력한 추가할 글내용을 전달받아..BoardDto에 저장 --%>
<jsp:useBean id="dto" class="com.bean.board.BoardDto"/>
<jsp:setProperty property="*" name="dto"/>
<%
	//BoardDto객체의 변수에 추가 적으로  글쓴 시간 저장 
	dto.setRegdate(new Timestamp(System.currentTimeMillis()));
%>

<%--순서3. 글추가 DB작업을 위한 dao객체 생성 --%>
<jsp:useBean id="dao" class="com.bean.board.BoardDaoImpl"/>
<%
	//DB에 글을 추가 하기 위해 dao의 insertBoard()메소드 호출시 dto전달 
	dao.insertBoard(dto);
	
	//게시판에 insert에 성공 했다면  다시 List.jsp로 이동
	response.sendRedirect("List.jsp");
%>








