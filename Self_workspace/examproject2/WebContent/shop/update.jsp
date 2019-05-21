<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.BoardBean"%>
<%@page import="java.util.List"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css" rel="stylesheet" href="../css/common.css" />
<link type="text/css" rel="stylesheet" href="../css/board.css" />
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/bookmark.js"></script>
<title>▒ 게시판 글 수정 ▒</title>
</head>
<%
	// id 세션 값 가져오기
	String id = (String) session.getAttribute("id");
	if (id == null)
		response.sendRedirect("login.jsp");

	request.setCharacterEncoding("UTF-8");

	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");

	BoardDAO dao = new BoardDAO();

	// 글 번호를 넘겨서 DB로부터 글 정보 가져오기
	BoardBean boardBean = dao.getBoard(num);

	int DBnum = boardBean.getNum();
	String DBName = boardBean.getName();
	String DBSubject = boardBean.getSubject();
	String DBContent = ""; // 글 내용

	// 글 내용이 존재한다면 내용 엔터 처리
	if(boardBean.getContent() != null)
		DBContent = boardBean.getContent().replace("\r\n", "<br>");
%>
<body>

	<%@ include file="../bootstrap/header.jsp"%>
	<div style="height: 50px;"></div>
	<%@ include file="../bootstrap/menulink.jsp"%>
	<div style="height: 50px;"></div>
	<!-- 게시판 -->
	<div class="container" style="text-align: center;">
		<article> Notice Update
			<form action="update_pro.jsp?pageNum=<%=pageNum%>" method="post" name="fr">
				<input type="hidden" name="num" value="<%=num%>">
				<table id="notice" align="center">
					<tr>
						<td>이름</td>
						<td><input type="text" name="name" value="<%=DBName%>"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="passwd"></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="subject" value="<%=DBSubject%>"></td>
					</tr>
					<tr>
						<td>글내용</td>
						<td><textarea name="content" rows="13" cols="40"><%=DBContent %></textarea></td>
					</tr>
				</table><br><br>
				<div id="table_search">
					<input type="submit" value="글수정" class="board_btn01"> 
					<input type="reset" value="다시작성" class="board_btn01"> 
					<input type="button" value="목록보기" class="board_btn01"
						   onclick="location.href='board.jsp?pageNum=<%=pageNum%>'">
				</div>
			</form>
			<div class="clear"></div>
			<div id="page_control"></div>
		</article>
	</div>
	<!-- 게시판 끝 -->

	<div style="height: 80px;"></div>
	<%@ include file="../bootstrap/footer.jsp"%>


</body>
</html>