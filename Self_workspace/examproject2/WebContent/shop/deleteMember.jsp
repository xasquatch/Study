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
<title>▒ 회원 탈퇴  ▒</title>
</head>
<body>
	<%@ include file="../bootstrap/header.jsp"%>
	<div style="height: 50px;"></div>
	<%@ include file="../bootstrap/menulink.jsp"%>
	<div style="height: 190px;"></div>
	
	<div class="container" align="center">
		<p style="font-size: 13px;">
			Member Delete<br><br>
		</p>
		<form action="deleteMember_pro.jsp" method="post">
			비밀번호 :&nbsp;&nbsp;
			<input type="password" name="password" id="pw" /> 
			<input type="submit" value="회원탈퇴" class="board_btn01" onclick="return confirm('정말로 탈퇴하시겠습니까?')"> 
			<input type="button" value="취소" class="board_btn01" onclick="location='../bootstrap/index.jsp'">
		</form>
	</div>
	<div style="height: 310px;"></div>
	<%@ include file="../bootstrap/footer.jsp"%>
</body>
</html>
