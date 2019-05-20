<%@page import="flower.OrderDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>flowerOrderDelete_pro</title>
</head>
<body>
<%
	int orderno = Integer.parseInt(request.getParameter("orderno"));
	OrderDAO odao = new OrderDAO();
	
	int check = odao.deleteOrder(orderno);
	if(check==1){
%>	
	<script type="text/javascript">
		alert("주문 취소 완료!");
		location.href="orderList.jsp";
	</script>
<% 		
	}else{
%>
	<script type="text/javascript">
		alert("주문 취소 실패");
		history.back();
	</script>
<%		
	}
%>

</body>
</html>