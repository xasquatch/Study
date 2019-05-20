<%@page import="myboard.BuyerDto"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.ArrayList"%>
<%@page import="myboard.BoardDto"%>
<%@page import="myboard.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hbay</title>
<link rel="stylesheet" href="../css/main.css"/>
<link rel="stylesheet" href="../css/board.css"/>
<script type="text/javascript">
	function send(loc, numPerPage, nowPage, nowBlock, no) {
		sendForm.action = loc;
		sendForm.numPerPage.value = numPerPage;
		sendForm.nowPage.value = nowPage;
		sendForm.nowBlock.value = nowBlock;
		sendForm.no.value = no;
		sendForm.submit();
	}
</script>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		BoardDao dao = new BoardDao();
		int totalRecord = dao.getBuyListSize((String)session.getAttribute("id"));
		int totalPage = 0;
		int totalBlock = 0;
		int numPerPage = 10;
		int pagePerBlock = 5;
		int nowPage = 0;
		int nowBlock = 0;
		int beginPerPage = 0;
		
		if(request.getParameter("numPerPage") != null) {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		}
		if(request.getParameter("nowPage") != null) {
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}
		if(request.getParameter("nowBlock") != null) {
			nowBlock = Integer.parseInt(request.getParameter("nowBlock"));
		}
		
		totalPage = (int)Math.ceil((float)totalRecord / numPerPage);
		totalBlock = (int)Math.ceil((float)totalPage / pagePerBlock);
		
		beginPerPage = nowPage * numPerPage;
		ArrayList<BoardDto> list = (ArrayList<BoardDto>)dao.getBuyList(beginPerPage, numPerPage, (String)session.getAttribute("id"));
	%>

	<%@include file="../inc/top_lg.jsp" %>
	
	<header>
	<div id="ui_top_banner">
		<div id="wrap">
			<a href="../index.jsp"><img src="../images/new_logo.png" alt="Hbay Logo" id="logo" /></a>
			<h1 id="ui_title">내 목록</h1>

			<ul id="ui_top_menu">
				<li><a href="mylist_sell.jsp">판매목록</a></li>
				<li><a href="">경매목록</a></li>
				<li><a href="mylist_buy.jsp" class="ui_selected">구입목록</a></li>
				<li><a href="">관심목록</a></li>
				<div class="clear"></div>
			</ul>
			<div class="clear"></div>
		</div>
	</div>
	</header>

	<div id="wrap" class="wrap_min">
		<article>
			<div id="item_lists">
				<%
				for(int i = 0; i < list.size(); i++) {
					BoardDto dto = list.get(i);
					
					long time = (dto.getEnd_time().getTime() - new Date().getTime()) / 1000;
					String left_time2 = "";
					if(time > (60 * 60 * 24))
						left_time2 = (int)Math.floor(time / (60 * 60 * 24)) + "일";
					else if(time > (60 * 60))
						left_time2 = (int)Math.floor(time / (60 * 60)) + "시간";
					else if(time > (60))
						left_time2 = (int)Math.floor(time / (60)) + "분";
					else 
						left_time2 = (int)time + "초";
					%>
					<div class="item_list">
						<div class="item_img"><a href="javascript:send('content2.jsp', <%=numPerPage %>, <%=nowBlock * pagePerBlock %>, <%=nowBlock %>, <%=dto.getNo() %>);"><img src="<%=dto.getMain_img() %>"/></a></div>
						<div class="item_info">
							<h2 class="title"><a href="javascript:send('content2.jsp', <%=numPerPage %>, <%=nowBlock * pagePerBlock %>, <%=nowBlock %>, <%=dto.getNo() %>);"><%=dto.getTitle() %></a></h2>
							<%
							BuyerDto bdto = dao.getBuyer(dto.getNo());
							if(bdto != null) {
								%>
								<div style="font-weight: bold">구매자: <%=bdto.getId() %></div>
								<%
							}
							%>
							<%
							if(dto.getBin_price() != 0) {
								%><span class="bin_price"><%=dto.getBin_price() %>원</span><%
							}
							%>
							
							<%
							if(dto.getBid_price() == 0) {
								%>
								<span class="left_time">
									<%
									if(dto.getStatus() == 0) {
										if(time >= 0) {
											out.println(left_time2 + "남음");
										} else {
											%>판매되지 않은 아이템<%
										}
									} else if(dto.getStatus() == 1) {
										%>판매완료된 아이템<%
									}
									%>
								</span><br/>
								<%
							}
							%>
							
							<%if(dto.getBid_price() != 0) {
								%>
								<br/><span class="price"><%=dto.getBid_price() %>원</span>
								<span class="left_time">
									<%
									if(dto.getStatus() == 0) {
										if(time >= 0) {
											out.println(left_time2 + "남음");
										} else {
											%>판매되지 않은 아이템<%
										}
									} else if(dto.getStatus() == 1) {
										%>판매완료된 아이템<%
									}
									%>
								</span><br/>
								<span class="bidder">5명 참여</span><br/>
								<%
							}
							%>
							<span class="area">지역: <%=dto.getArea() %></span>
						</div>
						<div class="clear"></div>
					</div>
					<%
				}
				
				if(totalRecord == 0) {
					%><div id="no_content">등록된 글 없음</div><%
				}
				%>
					
			</div>
			
			<div id="page">
				<%
				if(nowBlock > 0) {
					%>
					<a href="javascript:send('mylist_buy.jsp', <%=numPerPage %>, <%=(nowBlock - 1) * pagePerBlock %>, <%=nowBlock - 1 %>);">◀</a>
					<%
				}
				for(int i = 0; i < pagePerBlock; i++) {
					if(nowBlock * pagePerBlock + i == totalPage) break;
					%><a href="javascript:send('mylist_buy.jsp', <%=numPerPage %>, <%=nowBlock * pagePerBlock + i %>, <%=nowBlock %>);"><%=nowBlock * pagePerBlock + i + 1 %></a><%
				}
				if(nowBlock + 1 < totalBlock) {
					%>
						<a href="javascript:javascript:send('mylist_buy.jsp', <%=numPerPage %>, <%=(nowBlock + 1) * pagePerBlock %>, <%=nowBlock + 1 %>);">▶</a>
					<%
				}
				%>
			</div>
		</article>
	</div>

	<%@include file="../inc/footer.jsp" %>
	
	<form method="post" name="sendForm">
		<input type="hidden" name="no"/>
		<input type="hidden" name="numPerPage"/>
		<input type="hidden" name="nowPage"/>
		<input type="hidden" name="nowBlock"/>
	</form>
</body>
</html>