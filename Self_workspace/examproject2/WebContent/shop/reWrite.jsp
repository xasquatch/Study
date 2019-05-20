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
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/bookmark.js"></script>
<title>▒ 답글 달기 ▒</title>
</head>
<%
	// id 세션 값 가져오기
	String id = (String)session.getAttribute("id");
	if(id==null)
		response.sendRedirect("login.jsp");
	
	request.setCharacterEncoding("UTF-8");

	int num = Integer.parseInt(request.getParameter("num"));
	int re_ref = Integer.parseInt(request.getParameter("re_ref"));
	int re_lev = Integer.parseInt(request.getParameter("re_lev"));
	int re_seq = Integer.parseInt(request.getParameter("re_seq"));
%>
<body>

	<%@ include file="../bootstrap/header.jsp"%>
	<div style="height: 50px;"></div>
	<%@ include file="../bootstrap/menulink.jsp"%>
	<div style="height: 80px;"></div>
	<hr />
	<hr />
	<!-- 게시판 -->
	<div class="container" style="text-align: center;">
		<article>
		<h1>Notice Reply</h1>
		<form action="reWrite_pro.jsp" method="post" name="fr">
			<input type="hidden" name="num" value="<%=num%>">
			<input type="hidden" name="re_ref" value="<%=re_ref%>">
			<input type="hidden" name="re_lev" value="<%=re_lev%>">
			<input type="hidden" name="re_seq" value="<%=re_seq%>">
		
			<table id="notice" align="center">
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="<%=id%>" readonly></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="passwd"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="subject" value="[답글]"></td>
				</tr>
				<tr>
					<td>글내용</td>
					<td><textarea name="content" rows="13" cols="40"></textarea></td>
				</tr>
			</table>
		<div id="table_search">
			<input type="submit" value="답글작성" class="board_btn01">
			<input type="reset" value="다시작성" class="board_btn01">
			<input type="button" value="목록보기" class="board_btn01" onclick="location.href='board.jsp'">
		</div>
		</form>
		
		<div class="clear"></div>
		</article>
	</div>
	<!-- 게시판 끝 -->

	<div style="height: 100px;"></div>
	<%@ include file="../bootstrap/footer.jsp"%>

</body>
</html>