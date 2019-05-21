<%@page import="flower.OrderDTO"%>
<%@page import="flower.OrderDAO"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css" rel="stylesheet" href="../css/common.css" />
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/bookmark.js"></script>
<title>주문 완료</title>
</head>
<%
	// request영역을 전달받아 request영역의 데이터 중 한글이 있다면 한글 인코딩 처리하기
	// 한글 깨짐 방지 처리
	request.setCharacterEncoding("UTF-8");
%>
    <jsp:useBean id="odto" class="flower.OrderDTO"/>	
    <jsp:setProperty property="*" name="odto"/> 
<%
    odto.setOrderdate(new Timestamp(System.currentTimeMillis()));
	OrderDAO odao = new OrderDAO();
	odao.insertOrder(odto);
%>
	<script type="text/javascript">
		alert("주문 완료!");
		location.href="orderList.jsp";
	</script>
<body>
</body>
</html>