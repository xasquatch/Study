<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/common.css" />
<link type="text/css" rel="stylesheet" href="../css/mypage.css" />
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/bookmark.js"></script>
<title>▒ 마이페이지 ▒</title>
</head>
<body>
	<%@ include file="../bootstrap/header.jsp"%>
	<div style="height: 50px;"></div>
	<%@ include file="../bootstrap/menulink.jsp"%>
	<div style="height: 148px;"></div>
	<hr />
	<hr />

	<div class="container">
	<div class="myshopMain">
		<div class="shopMain">
			<a href="orderList.jsp"> 
				<span class="tit">ORDER LIST<br>(주문내역)</span>
			</a>
		</div>
		<div class="shopMain">
			<a href="modify.jsp"> 
				<span class="tit">MODIFY<br>(정보변경)</span>
			</a>
		</div>
		
		<div class="shopMain">
			<a href="board.jsp"> 
				<span class="tit">BOARD<br>(게시판)</span>
			</a>
		</div>

		<div class="shopMain">
			<a href="deleteMember.jsp"> 
				<span class="tit">USER EXIT<br>(회원탈퇴)</span>
			</a>
		</div>
	</div>
	</div>

	<div style="height: 150px;"></div>
	<%@ include file="../bootstrap/footer.jsp"%>

</body>
</html>