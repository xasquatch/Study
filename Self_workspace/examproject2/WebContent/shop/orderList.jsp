<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Vector"%>
<%@page import="flower.OrderDAO"%>
<%@page import="flower.OrderDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/common.css" />
<link type="text/css" rel="stylesheet" href="../css/board.css" />
<link type="text/css" rel="stylesheet" href="../css/join.css" />
<link type="text/css" rel="stylesheet" href="../css/order.css" />
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/bookmark.js"></script>
<script type="text/javascript" src="../js/orderCheck.js"></script>
<script type="text/javascript" src="../js/address.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<title>▒ 주문내역 ▒</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String id = (String) session.getAttribute("id");
		if (id == null)
			response.sendRedirect("login.jsp");

		OrderDAO odao = new OrderDAO();
		Vector<OrderDTO> v = odao.getOrderlist(id);

		// 날짜 포맷
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	%>
	<%@ include file="../bootstrap/header.jsp"%>
	<div style="height: 50px;"></div>
	<%@ include file="../bootstrap/menulink.jsp"%>
	<div style="height: 50px;"></div>

	<div id="contentWrapper">
		<div id="contentWrap">
			<div id="content">
				<div id="join_test">
					<div class="page-body">
						<div class="box-wrap">
							<ul class="join-form">
								<%
									if (v.size() > 0) {
										for (int i = 0; i < v.size(); i++) {
								%>
								<li style="height: 180px;">
									<table height="180px">
										<tr>
											<td width="90"><%=sdf.format(v.get(i).getOrderdate())%>&nbsp;
												<form action="orderListDelete.jsp" method="post">
													<input type="hidden" name="orderno" value="<%=v.get(i).getOrderno()%>"> 
													<input type="submit" value="주문취소" class="board_btn01"
														   onclick="return confirm('주문 취소하시겠습니까?')">
												</form></td>
											<td class="line" rowspan="6" width="190">
												<img src="../img/<%=v.get(i).getFlowerimg()%>" width="160" height="160"></td>
											<td class="line">
												[<%=v.get(i).getFlowercategory()%>] <%=v.get(i).getFlowername()%>
												x <%=v.get(i).getFlowerqty()%></td>
											<td class="line" width="130">
												￦ <%=v.get(i).getFlowerprice()%></td>
											<td class="line">
												<%=v.get(i).getMembername()%><br>
												<%=v.get(i).getMemberphone()%><br> 
												<%=v.get(i).getMemberaddress()%>
												<%=v.get(i).getMemberaddress2()%></td>
										</tr>
									</table>
								</li>
								<%
									}
									} else {
								%>
								<li style="height: 350px;">주문 내역이 없습니다.</li>
								<%
									}
								%>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container" align="center"></div>
	<div style="height: 134px;"></div>
	<%@ include file="../bootstrap/footer.jsp"%>
	
</body>
</html>