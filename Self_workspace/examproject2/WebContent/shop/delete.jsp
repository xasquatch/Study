<%@page import="board.BoardBean"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css" rel="stylesheet" href="../css/common.css" />
<link type="text/css" rel="stylesheet" href="../css/write.css" />
<link type="text/css" rel="stylesheet" href="../css/board.css" />
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/bookmark.js"></script>
<title>▒ 게시판 글 삭제 ▒</title>
</head>
<body>
	<%@ include file="../bootstrap/header.jsp"%>
	<div style="height: 50px;"></div>
	<%@ include file="../bootstrap/menulink.jsp"%>
	<div style="height: 180px;"></div>
	
	<% 
		String id = (String) session.getAttribute("id");
		if(id==null){
			response.sendRedirect("login.jsp");
		}
		// content.jsp(글 상세보기)에서 삭제할 글 번호, 페이지 넘버 가져오기
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
	
	%>
	<div class="container" style="text-align: center;">
		<article style="font-size: 15px;">Notice Delete<br>
		<br>
		<form action="delete_pro.jsp?pageNum=<%=pageNum %>" method="post">
			<input type="hidden" name="num" value="<%=num%>">
			<table id="notice" align="center">
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="passwd"></td>
				</tr>
			</table><br><br>
			<div id="table_search" style="float: none">
				<input type="submit" value="삭제하기" class="board_btn01"> 
				<input type="button" value="목록보기" class="board_btn01" onclick="location.href='board.jsp?pageNum=<%=pageNum%>'">
			</div>
		</form>
		<div class="clear"></div>
		<div id="page_control"></div>
		</article>
	</div>

	<div style="height: 205px;"></div>
	<%@ include file="../bootstrap/footer.jsp"%>
</body>
</html>
