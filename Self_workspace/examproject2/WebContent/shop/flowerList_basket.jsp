<%@page import="java.util.Vector"%>
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
<link type="text/css" rel="stylesheet" href="../css/index.css" />
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/bookmark.js"></script>
<title>▒ BASKET ▒</title>
</head>
<%
	request.setCharacterEncoding("UTF-8");

	FlowerDAO fdao = new FlowerDAO();
	Vector<FlowerDTO> v = fdao.getFlowerlist();
	
%>
<body>

	<%@ include file="../bootstrap/header.jsp"%>
	<div style="height: 50px;"></div>
	<%@ include file="../bootstrap/menulink.jsp"%>
	<div style="height: 50px;"></div>
	<!-- 본문 -->
	<div class="container">
		<br><br>
		<div class="itembox">
		<hr class="featurette-divider">
			<div class="row featurette">
		<%
			for(int i=4;i<6;i++){
		%>	
			<div class="col-md-4">
				<a href="../shop/flower.jsp?num=<%=v.get(i).getNum()%>">
					<img class="featurette-image img-responsive" src="../img/<%=v.get(i).getImg()%>"
						 style="height: 300px;" alt="Generic placeholder image">
				</a>		 
				<p class="featurette-heading" style="font-size: 13px;">
					[<%=v.get(i).getCategory()%>] <%=v.get(i).getName()%><br>
					￦<%=v.get(i).getPrice()%>
				</p>
			</div>
		<%
			}
		%>	
			</div>
		</div>
	</div>
	<!-- 본문 끝 -->
	<div style="height: 111px;"></div>
	<%@ include file="../bootstrap/footer.jsp"%>
</body>
</html>

