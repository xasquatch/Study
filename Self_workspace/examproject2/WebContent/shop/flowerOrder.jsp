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
<link type="text/css" rel="stylesheet" href="../css/join.css" />
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/bookmark.js"></script>
<script type="text/javascript" src="../js/orderCheck.js"></script>
<script type="text/javascript" src="../js/address.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<title>▒ 주문하기 ▒</title>
<style type="text/css">
input {
	line-height: normal;
}
.line {
	/* border-top: 1px solid lightgray; */
	border-left: 1px solid lightgray;
	padding: 0 20px;
	font-family: inherit;
	font-size: 13px;
}
.left_line {
	border-left: 1px solid lightgray;
	padding: 0 20px;
	font-family: inherit;
	font-size: 13px;
}
</style>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String id = (String) session.getAttribute("id");
	int num = Integer.parseInt(request.getParameter("num"));
	int flowerqty = Integer.parseInt(request.getParameter("flowerqty"));
	
	if (id == null)
		response.sendRedirect("login.jsp");

	MemberDao dao = MemberDao.getInstance();
	MemberDto member = dao.getUserInfo(id);
	
	FlowerDAO fdao = new FlowerDAO();
	FlowerDTO fdto = fdao.getFlower(num);
	
%>
	<%@ include file="../bootstrap/header.jsp"%>
	<div style="height: 50px;"></div>
	<%@ include file="../bootstrap/menulink.jsp"%>
	<div style="height: 50px;"></div>
	<hr />
	<hr />
	<div style="clear: both;"></div>
	<div id="contentWrapper">
		<div id="contentWrap">
			<div id="content">
				<div id="join_test">
					<div class="page-body">
						<form name="f" method="post" id="join_form" action="flowerOrder_pro.jsp" onsubmit="return orderCheck()">
							<input type="hidden" name="flowerno" value="<%=fdto.getNum()%>">
							<input type="hidden" name="flowername" value="<%=fdto.getName()%>">
							<input type="hidden" name="flowerimg" value="<%=fdto.getImg()%>">
							<input type="hidden" name="flowerqty" value="<%=flowerqty%>">
							<input type="hidden" name="flowerprice" value="<%=fdto.getPrice()*flowerqty%>">
							<input type="hidden" name="flowercategory" value="<%=fdto.getCategory()%>">
							<input type="hidden" name="memberid" value="<%=member.getId()%>">
							<div class="box-wrap">
								<ul class="join-form">
									<li style="height: 220px; padding: 0px 12px" >
										<table height="220px">
										<tr>
											<td width="200"><img src="../img/<%=fdto.getImg()%>" width="215" height="200"></td>
											<td class="line" width="380" >[<%=fdto.getCategory()%>]
															  <%=fdto.getName()%> x <%=flowerqty%></td>
											<td class="line" width="200">￦ <%=fdto.getPrice()*flowerqty%></td>	
										</tr>		
										</table>
									</li>
									<li>
										<label>주문자명&nbsp;&nbsp;&nbsp;</label> 
										<input type="text" name="membername" id="hname" value="<%=member.getHname()%>" size="15" maxlength="30" />
									</li>
									<li>
										<label>휴대폰번호&nbsp;&nbsp;</label>
											<input type="text" name="memberphone" id="etcphone" size="15" maxlength="30" value="<%=member.getEtcphone()%>" />
									</li>
									<li>
										<label>배송지&nbsp;&nbsp;</label>
										<input type="text" name="memberpostcode" id="sample6_postcode" value="<%=member.getPostcode()%>">
										<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
									</li>
									<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="text" name="memberaddress" id="sample6_address" value="<%=member.getAddress()%>"> 
										<input type="text" name="memberaddress2" id="sample6_address2" value="<%=member.getAddress2()%>">
									</li>
								</ul><br>
								
								<div class="new-btn-area" align="center">
									<input type="submit" value="주문하기" class="board_btn01" style="line-height: 0px;">
									<div style="height: 25px;"></div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../bootstrap/footer.jsp"%>
</body>
</html>

