<%@page import="java.sql.Timestamp"%>
<%@page import="myboard.BoardDto"%>
<%@page import="myboard.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/main.css"/>
<link rel="stylesheet" href="../css/board.css"/>
<script type="text/javascript" src="https://apis.daum.net/maps/maps3.js?apikey=6749c2879eacd9f02580dd3d72b6b036&libraries=services"></script>
<script type="text/javascript" src="../js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	function end(no) {
		if(confirm("아직 판매가 완료되지 않은 글입니다. 정말 판매를 종료하시겠습니까?")) {
			location.href = "endProc.jsp?no=" + no;
		}
	}
	
	$(function() {
		$("#mainBoard #bid_div .bidder").on("click", function() {
			$("#bidder_list").toggle();
		});
	})
</script>
</head>
<body>
	<%@include file="../inc/top_lg.jsp" %>
	
	<%
	BoardDao dao = new BoardDao();
	BoardDto dto = dao.getBoard(Integer.parseInt(request.getParameter("no")));
	
// 	long left_millis = (dto.getEnd_time().getTime() - System.currentTimeMillis()) / 1000;
// 	long left_day = left_millis / (60 * 60 * 24);
// 	left_millis = left_day > 0 ? left_millis % (60 * 60 * 24) : left_millis;
// 	int left_hour = (int)left_millis / (60 * 60);
// 	left_millis = left_hour > 0 ? left_millis % (60 * 60) : left_millis;
// 	int left_minute = (int)left_millis / (60);
// 	left_millis = left_minute > 0 ? left_millis % (60) : left_millis;
// 	int left_second = (int)left_millis;
	
// 	String left_time = "";
// 	left_time += left_day > 0 ? left_day + "일 " : "";
// 	left_time += left_hour > 0 ? left_hour + "시간 " : "";
// 	left_time += left_minute > 0 ? left_minute + "분 " : "";
// 	left_time += left_second > 0 ? left_second + "초" : "";
	%>
	
	<!-- 남은시간을 자동 카운팅 해주는 소스 -->
	<script type="text/javascript">
		window.onload = function() {
			var autoTime = setInterval(autoTimer, 200);
		}
		
		function autoTimer() {
			var end_time = new Date("<%=dto.getEnd_time() %>");
			var now = new Date();
			
			var left_millis = (end_time - now) / 1000;
			var left_day = Math.floor(left_millis / (60 * 60 * 24));
			left_millis = left_day > 0 ? left_millis % (60 * 60 * 24) : left_millis;
			var left_hour = Math.floor(left_millis / (60 * 60));
			left_millis = left_hour > 0 ? left_millis % (60 * 60) : left_millis;
			var left_minute = Math.floor(left_millis / (60));
			left_millis = left_minute > 0 ? left_millis % (60) : left_millis;
			var left_second = Math.floor(left_millis);
			
			var left_time = "남은시간 : ";
			left_time += left_day > 0 ? left_day + "일 " : "";
			left_time += left_hour > 0 ? left_hour + "시간 " : "";
			left_time += left_minute > 0 ? left_minute + "분 " : "";
			left_time += left_second > 0 ? left_second + "초" : "";
			
			document.getElementById("left_time").innerHTML = left_time;
		}
		
		function send(loc) {
			sendForm.action = loc;
			sendForm.submit();
		}
	</script>
	
	<div id="wrap" class="wrap_min">
		<!-- 로고 이미지 -->
		<a href="../index.jsp"><img src="../images/new_logo.png" alt="Hbay Logo" id="logo"/></a>
		<div id="mainBoard">
			<div id="board_info">
				<span id="title"><%=dto.getTitle() %></span>
				<span class="divider"></span>
				<span id="category"><%=dto.getCategory() %></span> >
				<span id="more_category"><%=dto.getMore_category() %></span>
				<span id="start_time" title="판매 시작일"><%=dto.getStart_time() %></span>
			</div>
			<div id="writer">작성자: <%=dto.getId() %></div>
			<div id="area">지역: <%=dto.getArea() %></div>
			<div class="clear"></div>
			<div id="imgAndBid">
				<div id="main_img">
					<img src="<%=dto.getMain_img() %>"/>
				</div>
				<div id="bid_div">
					<%
					if(dto.getStatus() == 1) {
						%><div id="status" style="color:green">판매 완료된 아이템</div><%
					} else if(dto.getStatus() == 2) {
						%><div id="status" style="color:gray">판매되지 않은 아이템</div><%
					}
					%>
					<%
					if(dto.getBin_price() != 0) {
						%>
						<form action="buyItNow.jsp" method="post">
							<input type="hidden" name="no" value="<%=dto.getNo() %>"/>
							<span class="price"><%=dto.getBin_price() %>원</span>
							<input type="submit" value="바로구매"/>
						</form>
						<%
					}
					%>
					<%
					if(dto.getBid_price() != 0) {
						%>
						<form action="#">
							<input type="hidden" name="no" value="<%=dto.getNo() %>"/>
							<span class="price"><%=dto.getBid_price() %>원</span>
							<span class="bidder" onclick="">0명 참여</span>
							<div id="bidder_list">
								<h3>경매 참여자 목록</h3>
								<table>
									<tr>
										<th>아이디</th>
										<th>경매 금액</th>
										<th>경매 시간</th>
									</tr>
									<tr>
										<td>ad***</td>
										<td>10000000원</td>
										<td>2017-05-19 23:56:00.0</td>
									</tr>
									<tr>
										<td>ad***</td>
										<td>10000000원</td>
										<td>2017-05-19 23:56:00.0</td>
									</tr>
									<tr>
										<td>ad***</td>
										<td>10000000원</td>
										<td>2017-05-19 23:56:00.0</td>
									</tr>
									<tr>
										<td id="start_bid">경매 시작가</td>
										<td>2000원</td>
										<td>2017-05-19 23:56:00.0</td>
									</tr>
								</table>
							</div>
							<input type="text" placeholder="가격을 입력하세요."/>
							<input type="submit" value="경매참여"/>
						</form>
						<%
					}
					%>
					<div id="left_time">남은시간 :</div>
				</div>
				<div class="clear"></div>
			</div>
			<%
			if(dto.getTrade().equals("direct")) {
				%>
				<div id="map_div">
					<a>▷직거래 장소 보기◁</a>
					<div id="map">
						<!-- 지도 들어가는곳 -->
					</div>
				</div>
				<div class="clear"></div>
				<%
			}
			%>
			<div id="content">
			<%=dto.getContent() %>
			</div>
		</div>
		<button class="btn con_btn" onclick="send('board.jsp');">목록 보기</button>
		<%
		if(id != null && id.equals(dto.getId())) {
			%>
			<button class="btn con_btn" onclick="end(<%=dto.getNo() %>);">판매 종료</button>
			<button class="btn con_btn" onclick="send('edit.jsp');">글 수정</button>
			<%
		}
		%>
		<button class="btn con_btn" onclick="location.href='sell.jsp'">새 판매글 쓰기</button>
		<div class="clear"></div>
	</div>
	
	<form method="post" name="sendForm">
		<input type="hidden" name="no" value="<%=request.getParameter("no") %>"/>
		<input type="hidden" name="numPerPage" value="<%=request.getParameter("numPerPage") %>"/>
		<input type="hidden" name="nowPage" value="<%=request.getParameter("nowPage") %>"/>
		<input type="hidden" name="nowBlock" value="<%=request.getParameter("nowBlock") %>"/>
		<input type="hidden" name="searchBox" value="<%=request.getParameter("searchBox") %>"/>
		<input type="hidden" name="format" value="<%=request.getParameter("format") %>"/>
		<input type="hidden" name="area" value="<%=request.getParameter("area") %>"/>
		<input type="hidden" name="min_price" value="<%=request.getParameter("min_price") %>"/>
		<input type="hidden" name="max_price" value="<%=request.getParameter("max_price") %>"/>
		<input type="hidden" name="category" value="<%=request.getParameter("category") %>"/>
		<input type="hidden" name="more_category" value="<%=request.getParameter("more_category") %>"/>
	</form>
	
	<%@include file="../inc/footer.jsp" %>

	<script type="text/javascript">
		var coords = "<%=dto.getCoords() %>";
	    coords = coords.replace("(", "").replace(")", "").split(",");
	    coords = new daum.maps.LatLng(coords[0], coords[1]);
    
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div
	    mapOption = {
	        center: coords, // 지도의 중심좌표
	        level: 2 // 지도의 확대 레벨
	    };
	
		//지도를 미리 생성
		var map = new daum.maps.Map(mapContainer, mapOption);
		//주소-좌표 변환 객체를 생성
		var geocoder = new daum.maps.services.Geocoder();
		//마커를 미리 생성
	    var marker = new daum.maps.Marker({
	        position: coords,
	        map: map
	    });
	    var infowindow = new daum.maps.InfoWindow({zindex:1});
	    var content = "";
	    
	    var detailAddr;
        searchDetailAddrFromCoords(coords, function(status, result) {
            if (status === daum.maps.services.Status.OK) {
                detailAddr = !!result[0].roadAddress.name ? '<div>도로명주소 : ' + result[0].roadAddress.name + '</div>' : '';
                detailAddr += '<div>지번 주소 : ' + result[0].jibunAddress.name + '</div>';
                detailAddr += '<div>상세 위치 : <%=dto.getAddress2() %></div><br/>';
            }
            
            content = '<div class="bAddr">' +
            '<span class="title">주소정보</span>' + 
            detailAddr + 
       		'</div>';

			// 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
			infowindow.setContent(content);
			infowindow.open(map, marker);
        });
		
	    function searchDetailAddrFromCoords(coords, callback) {
	    	// 좌표로 법정동 상세 주소 정보를 요청합니다
	    	geocoder.coord2detailaddr(coords, callback);
	    }
	    
	    $(function() {
	    	$("#map_div #map").hide();
			$("#map_div a").on("click", function() {
				$("#map_div #map").toggle();
				infowindow.setContent(content);
				infowindow.open(map, marker);
			});
		});
	</script>
</body>
</html>