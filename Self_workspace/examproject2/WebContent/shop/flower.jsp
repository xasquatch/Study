<%@page import="flower.FlowerDTO"%>
<%@page import="flower.FlowerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/common.css" />
<link type="text/css" rel="stylesheet" href="../css/board.css" />
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/bookmark.js"></script>
<title>▒ 상세 정보  ▒</title>
</head>
<%
	request.setCharacterEncoding("UTF-8");

	int num = Integer.parseInt(request.getParameter("num"));
	/* 	String pageNum = request.getParameter("pageNum");
		String search = request.getParameter("search"); */

	FlowerDAO fdao = new FlowerDAO();

	FlowerDTO fdto = fdao.getFlower(num);
%>
<body>

	<%@ include file="../bootstrap/header.jsp"%>
	<div style="height: 50px;"></div>
	<%@ include file="../bootstrap/menulink.jsp"%>
	<div style="height: 50px;"></div>
	<hr />
	<hr />
	<!-- 본문 -->
	<div class="container" style="text-align: center;">
		<article> Flower Info <br><br>
		<form action="flowerOrder.jsp" method="post">
			<input type="hidden" name="num" value="<%=fdto.getNum()%>">
			<table id="notice" align="center">
				<tr style="border-top: 1px dotted gray;">
					<td rowspan="4"><img src="../img/<%=fdto.getImg()%>"
						width="300" height="300"></td>
					<td>◇ <%=fdto.getName()%> ◇
					</td>
				</tr>
				<tr>
					<td>￦<%=fdto.getPrice()%></td>
				</tr>
				<tr>
					<td><%=fdto.getCategory()%></td>
				</tr>
				<tr>
					<td>
						<select name="flowerqty">
							<option value="1">1 개
							<option value="2">2 개
							<option value="3">3 개
							<option value="4">4 개
							<option value="5">5 개
						</select>
					</td>
				</tr>
			</table><br><br>
			<div class="clear"></div>
			<input type="submit" value="주문하기" class="board_btn01"> 
		</form>
		</article>
	</div>
	<div style="height: 78px;"></div>
	<%@ include file="../bootstrap/footer.jsp"%>
</body>
</html>

