<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css" rel="stylesheet" href="../css/common.css" />
<link type="text/css" rel="stylesheet" href="../css/write.css" />
<link type="text/css" rel="stylesheet" href="../css/board.css" />
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/bookmark.js"></script>
<title>▒ 게시판 글쓰기 ▒</title>
</head>
<body>
	<%@ include file="../bootstrap/header.jsp"%>
	<div style="height: 50px;"></div>
	<%@ include file="../bootstrap/menulink.jsp"%>
	<div style="height: 50px;"></div>
	<%
		String id = (String) session.getAttribute("id");
		if (id == null)
			response.sendRedirect("login.jsp");
	%>
	<!-- 게시판 -->
	<div class="container" style="text-align: center;">
		<article> Notice Write
		<form action="write_pro.jsp" method="post">
			<table id="notice" align="center">
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="<%=id%>" readonly></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="passwd" required="required"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="subject" required="required"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="content" rows="13" cols="40" required="required"></textarea></td>
				</tr>
			</table>
			<br>
			<div id="table_search" style="float: none">
				<input type="submit" value="글쓰기" class="board_btn01"> 
				<input type="reset" value="다시쓰기" class="board_btn01"> 
				<input type="button" value="글목록" class="board_btn01" onclick="location.href='board.jsp'">
			</div>
		</form>
		</article>
	</div>
	<!-- 게시판 끝 -->
	
	<div style="height: 25px;"></div>
	<%@ include file="../bootstrap/footer.jsp"%>
</body>
</html>