<%@page import="com.bean.board.BoardDto"%>
<%@page import="com.oracle.webservices.internal.api.EnvelopeStyle.Style"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Reply.jsp에서 요청한 데이터 한글처리
	request.setCharacterEncoding("UTF-8");
%>
	<%--답변달기 insert DB작업을 위한 BoardDaoImpl객체 생성 --%>
	<jsp:useBean id="dao" class="com.bean.board.BoardDaoImpl"/>

	<%--Reply.jsp에서 요청한 입력한 (답변글내용 ) + 주글정보를  request객체영역에서 꺼내서 
		BoardDto객체의 각변수에 저장--%>
	<jsp:useBean id="dto" class="com.bean.board.BoardDto"/>
	<jsp:setProperty property="*" name="dto"/>
<%
	dto.setRegdate(new Timestamp(System.currentTimeMillis())); //답변글을 작성한 날짜 저장
	
	//Reply.jsp 답변달기 디자인 페이지에서 등록 버튼을 눌렀을때.. 전달 받은 3개의 값 저장
	int num = Integer.parseInt(request.getParameter("num"));//주글 번호
	String keyField = request.getParameter("keyField");//검색기준값
	String keyWord = request.getParameter("keyWord");//검색어 
	
	//부모글 번호를 getBoardInfo()메소드 호출시 전달하여 DB로부터 검색한 부모글정보를 가져온다
	BoardDto ParentDto = dao.getBoardInfo(num);
	
	//부모글에 대한 pos값을 넘겨서 .. 부모글보다 큰 pos값에 1을 더해서 글 수정하기
	dao.replyUpPos(ParentDto.getPos());
	
	//검색해온 부모글의 pos값을  dto객체에 저장
	dto.setPos(ParentDto.getPos());
	//검색해온 부모글의 depth값을 dto객체에 저장
	dto.setDepth(ParentDto.getDepth());
	
	//부모글의 pos,depth값 + 입력한 답변글 내용을 담고 있는  
	//BoardDto객체를 dao객체의 replyBoard()메소드 호출시 전달 
	dao.replayBoard(dto); //답변달기 insert
	
	//답변달기 insert에 성공 하면 다시 List.jsp로 이동
	response.sendRedirect("List.jsp");
%>
	
	
	
	
	
	