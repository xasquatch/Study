<%@page import="java.util.*"%>
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
<script type="text/javascript" src="../js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="../js/board.js"></script>
<script type="text/javascript" src="../js/selectOptions2.js"></script>
<script type="text/javascript">
function send(loc, numPerPage, nowPage, nowBlock, no) {
	sendForm.action = loc;
	sendForm.numPerPage.value = numPerPage;
	sendForm.nowPage.value = nowPage;
	sendForm.nowBlock.value = nowBlock;
	sendForm.no.value = no;
	sendForm.submit();
}

function formCheck() {
	var min_price = searchFm.min_price.value;
	var max_price = searchFm.max_price.value;
	if(isNaN(Number(min_price))) {
		alert("최소 가격으로는 숫자만 입력 가능합니다.");
		searchFm.min_price.focus();
		return false;
	}
	if(isNaN(Number(max_price))) {
		alert("최대 가격으로는 숫자만 입력 가능합니다.");
		searchFm.max_price.focus();
		return false;
	}
}
</script>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String searchBox = request.getParameter("searchBox");
	if(searchBox == null) searchBox = ""; 
	
	BoardDao dao = new BoardDao();
	
	String format = request.getParameter("format");
	String area = request.getParameter("area");
	String min_price = request.getParameter("min_price");
	String max_price = request.getParameter("max_price");
	String category = request.getParameter("category");
	String more_category = request.getParameter("more_category");
// 	String left_time = request.getParameter("left_time");

%>
	<script>
		window.onload = function() {
			selectCheck();
			selectMoreCate("<%=more_category%>");
		}
	</script>
<%

	Hashtable<String, String> options = new Hashtable<String, String>();
	if(format != null && !format.equals("null")) options.put("format", format);
	if(area != null && !area.equals("null")) options.put("area", area);
	if(min_price != null && !min_price.equals("null") && !min_price.isEmpty()) options.put("min_price", min_price);
	if(max_price != null && !max_price.equals("null") && !max_price.isEmpty()) options.put("max_price", max_price);
	if(category != null && !category.equals("null") && !category.equals("모든 종류")) options.put("category", category);
	if(more_category != null && !more_category.equals("null") && !more_category.equals("모든 종류")) options.put("more_category", more_category);
// 	if(left_time != null && !left_time.equals("all")) options.put("left_time", left_time);
	
	int totalRecord = dao.getBoardSize(searchBox, options);
	int totalPage = 0;
	int totalBlock = 0;
	int numPerPage = 10;
	int pagePerBlock = 5;
	int nowPage = 0;
	int nowBlock = 0;
	int beginPerPage = 0;
	
	if(request.getParameter("numPerPage") != null && !request.getParameter("numPerPage").equals("null")) {
		numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
	}
	if(request.getParameter("nowPage") != null && !request.getParameter("nowPage").equals("null")) {
		nowPage = Integer.parseInt(request.getParameter("nowPage"));
	}
	if(request.getParameter("nowBlock") != null && !request.getParameter("nowBlock").equals("null")) {
		nowBlock = Integer.parseInt(request.getParameter("nowBlock"));
	}
	
	totalPage = (int)Math.ceil((float)totalRecord / numPerPage);
	totalBlock = (int)Math.ceil((float)totalPage / pagePerBlock);
	
	beginPerPage = nowPage * numPerPage;
	
	ArrayList<BoardDto> list = (ArrayList<BoardDto>)dao.getBoardList(beginPerPage, numPerPage, searchBox, options);
	%>
	
	<%@include file="../inc/top_lg.jsp" %>
	
	<div id="wrap" class="wrap_min">
		<header>
			<%@include file="../inc/logo.jsp" %>
			<form action="board.jsp" method="post" name="searchFm" onsubmit="return formCheck();">
				<%@include file="../inc/search.jsp" %>
			<div class="clear"></div>
			
			<div id="search_option">
				<a href="#" id="search_option_btn">검색 옵션 보기</a>
				<div id="options">
					<div class="options">
						<h3>아이템 형식</h3>
						<div class="clear"></div>
						<input type="radio" name="format" value="null"<%if(format == null || format.equals("null")){%>checked<%}%>/>모든 형식
						<input type="radio" name="format" value="bin_price"<%if(format != null && format.equals("bin_price")){%>checked<%}%>/>바로구매
						<input type="radio" name="format" value="bid_price"<%if(format != null && format.equals("bid_price")){%>checked<%}%>/>경매
					</div>
					<div class="options">
						<h3>지역</h3>
						<div class="clear"></div>
						<input type="radio" name="area" value="null"<%if(area == null || area.equals("null")){%>checked<%}%>/>모든 지역
						<input type="radio" name="area" value="서울"<%if(area != null && area.equals("서울")){%>checked<%}%>/>서울
						<input type="radio" name="area" value="부산"<%if(area != null && area.equals("부산")){%>checked<%}%>/>부산
						<input type="radio" name="area" value="인천"<%if(area != null && area.equals("인천")){%>checked<%}%>/>인천
						<input type="radio" name="area" value="경기"<%if(area != null && area.equals("경기")){%>checked<%}%>/>경기
					</div>
					<div class="options">
						<h3>가격</h3>
						<div class="clear"></div>
						<input type="text" class="price" name="min_price" value="<%if(min_price != null && !min_price.equals("null")) out.println(min_price);%>"/>부터
						<input type="text" class="price" name="max_price" value="<%if(max_price != null && !max_price.equals("null")) out.println(max_price);%>"/>까지
					</div>
					<div class="options">
						<h3>아이템 종류</h3>
						<div class="clear"></div>
						<select id="select_cate" name="category" onchange="selectCheck();">
							<option value="모든 종류"<%if(category == null){%>selected<%}%>>모든 종류</option>
							<option value="패션의류"<%if(category != null && category.equals("패션의류")){%>selected<%}%>>패션의류</option>
							<option value="잡화"<%if(category != null && category.equals("잡화")){%>selected<%}%>>잡화</option>
							<option value="유아동"<%if(category != null && category.equals("유아동")){%>selected<%}%>>유아동</option>
							<option value="홈데코"<%if(category != null && category.equals("홈데코")){%>selected<%}%>>홈데코</option>
							<option value="문구"<%if(category != null && category.equals("문구")){%>selected<%}%>>문구</option>
							<option value="취미"<%if(category != null && category.equals("취미")){%>selected<%}%>>취미</option>
							<option value="컴퓨터"<%if(category != null && category.equals("컴퓨터")){%>selected<%}%>>컴퓨터</option>
							<option value="디지털"<%if(category != null && category.equals("디지털")){%>selected<%}%>>디지털</option>
							<option value="가전"<%if(category != null && category.equals("가전")){%>selected<%}%>>가전</option>
							<option value="스포츠"<%if(category != null && category.equals("스포츠")){%>selected<%}%>>스포츠</option>
							<option value="건강"<%if(category != null && category.equals("건강")){%>selected<%}%>>건강</option>
							<option value="자동차"<%if(category != null && category.equals("자동차")){%>selected<%}%>>자동차</option>
							<option value="공구"<%if(category != null && category.equals("공구")){%>selected<%}%>>공구</option>
							<option value="여행"<%if(category != null && category.equals("여행")){%>selected<%}%>>여행</option>
							<option value="도서"<%if(category != null && category.equals("도서")){%>selected<%}%>>도서</option>
							<option value="티켓/e쿠폰"<%if(category != null && category.equals("티켓/e쿠폰")){%>selected<%}%>>티켓/e쿠폰</option>
						</select>
						<select id="select_more_cate" name="more_category">
							<option value="모든 종류">모든 종류</option>
						</select>
					</div>
					<!-- <div class="options">
						<h3>남은 기간</h3>
						<div class="clear"></div>
						<input type="radio" name="left_time" value="all" checked/>모든 기간
						<input type="radio" name="left_time" value="day"/>1일 미만
						<input type="radio" name="left_time" value="week"/>1주 미만
						<input type="radio" name="left_time" value="month"/>1달 미만
						<input type="radio" name="left_time" value="month+"/>1달 이상
					</div> -->
				</div>
			</div>
			</form>
			
			<div id="select_options">
				 
			</div>
		</header>
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
						<div class="item_img"><a href="javascript:send('content.jsp', <%=numPerPage %>, <%=nowBlock * pagePerBlock %>, <%=nowBlock %>, <%=dto.getNo() %>);"><img src="<%=dto.getMain_img() %>"/></a></div>
						<div class="item_info">
							<h2 class="title"><a href="javascript:send('content.jsp', <%=numPerPage %>, <%=nowBlock * pagePerBlock %>, <%=nowBlock %>, <%=dto.getNo() %>);"><%=dto.getTitle() %></a></h2>
							<%
							if(dto.getBin_price() != 0) {
								%><span class="bin_price"><%=dto.getBin_price() %>원</span><%
							}
							%>
							
							<%
							if(dto.getBid_price() == 0) {
								%><span class="left_time"><%=left_time2 %>남음</span><br/><%
							}
							%>
							
							<%if(dto.getBid_price() != 0) {
								%>
								<br/><span class="price"><%=dto.getBid_price() %>원</span>
								<span class="left_time"><%=left_time2 %>남음</span><br/>
								<span class="bidder">0명 참여</span><br/>
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
			
			<div id="board_btns">
				<button class="btn" onclick="javascript:location.href='sell.jsp'">새 판매글 쓰기</button>
			</div>
			
			<div class="clear"></div>
			
			<div id="page">
				<%
				if(nowBlock > 0) {
					%>
					<a href="javascript:send('board.jsp', <%=numPerPage %>, <%=(nowBlock - 1) * pagePerBlock %>, <%=nowBlock - 1 %>);">◀</a>
					<%
				}
				for(int i = 0; i < pagePerBlock; i++) {
					if(nowBlock * pagePerBlock + i == totalPage) break;
					%><a href="javascript:send('board.jsp', <%=numPerPage %>, <%=nowBlock * pagePerBlock + i %>, <%=nowBlock %>);"><%=nowBlock * pagePerBlock + i + 1 %></a><%
				}
				if(nowBlock + 1 < totalBlock) {
					%>
						<a href="javascript:javascript:send('board.jsp', <%=numPerPage %>, <%=(nowBlock + 1) * pagePerBlock %>, <%=nowBlock + 1 %>);">▶</a>
					<%
				}
				%>
			</div>
		</article>
	</div>
	
	<form method="post" name="sendForm">
		<input type="hidden" name="no"/>
		<input type="hidden" name="numPerPage"/>
		<input type="hidden" name="nowPage"/>
		<input type="hidden" name="nowBlock"/>
		<input type="hidden" name="searchBox" value="<%=request.getParameter("searchBox") %>"/>
		<input type="hidden" name="format" value="<%=format %>"/>
		<input type="hidden" name="area" value="<%=area %>"/>
		<input type="hidden" name="min_price" value="<%=min_price %>"/>
		<input type="hidden" name="max_price" value="<%=max_price %>"/>
		<input type="hidden" name="category" value="<%=category %>"/>
		<input type="hidden" name="more_category" value="<%=more_category %>"/>
	</form>
	
	<%@include file="../inc/footer.jsp" %>
</body>
</html>