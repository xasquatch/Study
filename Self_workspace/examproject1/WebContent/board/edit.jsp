<%@page import="java.text.SimpleDateFormat"%>
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
<script type="text/javascript" src="../js/selectOptions2.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="https://apis.daum.net/maps/maps3.js?apikey=6749c2879eacd9f02580dd3d72b6b036&libraries=services"></script>
<script type="text/javascript">
	function popup() {
		var width = 480;
		var height = 500;
		var winL = (screen.width - width) / 2;
		var winT = (screen.height - height) / 2;
		var property = "width=" + width + "," + "height=" + height + "," 
						+ "left=" + winL + "," + "top=" + winT + " menubar=no";
		
		window.open("pages/trex/main_image.html", "image Page", property);
	}
	
	$(function() {
		if(!$("#direct").is(":checked")) {
		$("#map_div").hide();
		}
		
		$("#direct").on("change", function() {
			$("#map_div").show();
		});
		
		$("#delivery").on("change", function() {
			$("#map_div").hide();
		});
		
		$("#buyItNow").on("click", function() {
			if($(this).is(":checked")) {
				$("#buyItNow_price").prop("disabled", false);
			} else {
				$("#buyItNow_price").prop("disabled", true);
				$("#buyItNow_price").val("");
			}
		});
		
		$("#bidding").on("click", function() {
			if($(this).is(":checked")) {
				$("#bidding_price").prop("disabled", false);
			} else {
				$("#bidding_price").prop("disabled", true);
				$("#bidding_price").val("");
			}
		});
	});
</script>
</head>
<body>
	<%@include file="../inc/loginCheck.jsp" %>
	<%@include file="../inc/top_lg.jsp" %>
	
	<%
	SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
	int no = Integer.parseInt(request.getParameter("no"));
	BoardDao dao = new BoardDao();
	BoardDto dto = dao.getBoard(no);
	
	String main_img = dto.getMain_img();
	String bin_price = dto.getBin_price() == 0 ? "" : String.valueOf(dto.getBin_price());
	String bid_price = dto.getBid_price() == 0 ? "" : String.valueOf(dto.getBid_price());
	String start_time = s.format(dto.getStart_time());
	String end_time = s.format(dto.getEnd_time());
	int hour = dto.getStart_time().getHours();
	int minute = dto.getStart_time().getMinutes();
	String area = dto.getArea();
	String trade = dto.getTrade();
	String address = dto.getAddress() == null ? "" : dto.getAddress();
	String address2 = dto.getAddress2() == null ? "" : dto.getAddress2();
	String coords = dto.getCoords() == null ? "(37.537187, 127.005476)" : dto.getCoords();
	String title = dto.getTitle();
	String content = dto.getContent();
	String category = dto.getCategory();
	String more_category = dto.getMore_category();
	%>
	
	<script>
		window.onload = function() {
			selectCheck();
			selectMoreCate("<%=more_category%>");
		}
	</script>
	
	<div id="wrap" class="wrap_min">
		<!-- 로고 이미지 -->
		<a href="../index.jsp"><img src="../images/new_logo.png" alt="Hbay Logo" id="logo"/></a>
		
		<div id="editor_div">
		<form name="tx_editor_form" id="tx_editor_form" action="editProc.jsp" method="post" accept-charset="utf-8">
			<input type="hidden" name="id" value="<%=id %>"/>
			<input type="hidden" name="no" value="<%=no %>"/>
			<input type="hidden" name="bid_price" value="<%=bid_price %>"/>
			<input type="hidden" name="st_time" value="<%=start_time %>"/>
			<input type="hidden" name="start_hour" value="<%=hour %>"/>
			<input type="hidden" name="start_minute" value="<%=minute %>"/>
			<div id="editor_top2">
				<div id="main_img_div">
					<div id="main_img">
						<img src="<%=main_img %>"/>
					</div>
					<input type="hidden" name="main_img" value="<%=main_img %>" id="main_img_input"/>
					<button onclick="popup();">메인 이미지 추가하기</button>
				</div>
				
				<table id="sell_options">
					<tr>
						<th colspan="2">가격</th>
					</tr>
					<tr>
						<td><input type="checkbox" name="buyItNow" id="buyItNow" <%if(!bin_price.isEmpty()) {%>checked<%}%>/>바로구매</td>
						<td><input type="text" name="bin_price" id="buyItNow_price" maxlength="8" value="<%=bin_price %>"/>원</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="bidding" id="bidding" <%if(!bid_price.isEmpty()) {%>checked<%}%> disabled/>경매 시작가</td>
						<td><input type="text" name="bid_price" id="bidding_price" maxlength="8" value="<%=bid_price %>" disabled/>원</td>
					</tr>
					<tr>
						<td>판매시작일</td>
						<td><input type="date" name="st_time" id="start_time" value="<%=start_time %>" disabled/></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<select id="start_hour" name="start_hour" disabled>
								<option value="1" <%if(hour == 1){%>selected<%}%>>1</option>
								<option value="2" <%if(hour == 2){%>selected<%}%>>2</option>
								<option value="3" <%if(hour == 3){%>selected<%}%>>3</option>
								<option value="4" <%if(hour == 4){%>selected<%}%>>4</option>
								<option value="5" <%if(hour == 5){%>selected<%}%>>5</option>
								<option value="6" <%if(hour == 6){%>selected<%}%>>6</option>
								<option value="7" <%if(hour == 7){%>selected<%}%>>7</option>
								<option value="8" <%if(hour == 8){%>selected<%}%>>8</option>
								<option value="9" <%if(hour == 9){%>selected<%}%>>9</option>
								<option value="10" <%if(hour == 10){%>selected<%}%>>10</option>
								<option value="11" <%if(hour == 11){%>selected<%}%>>11</option>
								<option value="12" <%if(hour == 12){%>selected<%}%>>12</option>
								<option value="13" <%if(hour == 13){%>selected<%}%>>13</option>
								<option value="14" <%if(hour == 14){%>selected<%}%>>14</option>
								<option value="15" <%if(hour == 15){%>selected<%}%>>15</option>
								<option value="16" <%if(hour == 16){%>selected<%}%>>16</option>
								<option value="17" <%if(hour == 17){%>selected<%}%>>17</option>
								<option value="18" <%if(hour == 18){%>selected<%}%>>18</option>
								<option value="19" <%if(hour == 19){%>selected<%}%>>19</option>
								<option value="20" <%if(hour == 20){%>selected<%}%>>20</option>
								<option value="21" <%if(hour == 21){%>selected<%}%>>21</option>
								<option value="22" <%if(hour == 22){%>selected<%}%>>22</option>
								<option value="23" <%if(hour == 23){%>selected<%}%>>23</option>
								<option value="24" <%if(hour == 24){%>selected<%}%>>24</option>
							</select>시
							<input type="text" id="start_minute" name="start_minute" maxLength="2" value="<%=minute %>" disabled/>분
						</td>
					</tr>
					<tr>
						<td>판매종료일</td>
						<td><input type="date" name="en_time" id="end_time" value="<%=end_time %>"/></td>
					</tr>
					<tr>
						<th colspan="2">지역</th>
					</tr>
					<tr>
						<td colspan="2">
							<select name="area" id="area">
								<option value="지역 선택">지역 선택</option>
								<option value="서울" <%if(area.equals("서울")) {%>selected<%}%>>서울</option>
								<option value="부산" <%if(area.equals("부산")) {%>selected<%}%>>부산</option>
								<option value="인천" <%if(area.equals("인천")) {%>selected<%}%>>인천</option>
								<option value="경기" <%if(area.equals("경기")) {%>selected<%}%>>경기</option>
							</select>
						</td>
					</tr>
					<tr>
						<th colspan="2">거래방법</th>
					</tr>
					<tr>
						<td><input type="radio" name="trade" id="delivery" value="delivery" <%if(trade.equals("delivery")) {%>checked<%}%>/>배송</td>
						<td><input type="radio" name="trade" id="direct" value="direct" <%if(trade.equals("direct")) {%>checked<%}%>/>직거래</td>
					</tr>
				</table>
				<div id="map_div">
				<input type="text" id="sample5_address" name="address" placeholder="직거래 주소 입력" value="<%=address %>" readonly>
				<input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색">
				<input type="text" id="detail_address" name="address2" placeholder="상세 위치 입력" value="<%=address2 %>"/>
				<input type="hidden" id="coords" name="coords" value="<%=coords %>"/>
					<div id="map">
						<!-- 지도 들어가는곳 -->
					</div>
				</div>
				<div class="clear"></div>
			</div>
			
			<div id="editor_top">
				<label for="title">제목:</label>
				<input type="text" name="title" id="title" value="<%=title %>"/>
				<select id="select_cate" name="category" onchange="selectCheck();">
					<option>카테고리 선택</option>
					<option value="패션의류" <%if(category.equals("패션의류")){%>selected<%}%>>패션의류</option>
					<option value="잡화" <%if(category.equals("잡화")){%>selected<%}%>>잡화</option>
					<option value="유아동" <%if(category.equals("유아동")){%>selected<%}%>>유아동</option>
					<option value="홈데코" <%if(category.equals("홈데코")){%>selected<%}%>>홈데코</option>
					<option value="문구" <%if(category.equals("문구")){%>selected<%}%>>문구</option>
					<option value="취미" <%if(category.equals("취미")){%>selected<%}%>>취미</option>
					<option value="컴퓨터" <%if(category.equals("컴퓨터")){%>selected<%}%>>컴퓨터</option>
					<option value="디지털" <%if(category.equals("디지털")){%>selected<%}%>>디지털</option>
					<option value="가전" <%if(category.equals("가전")){%>selected<%}%>>가전</option>
					<option value="스포츠" <%if(category.equals("스포츠")){%>selected<%}%>>스포츠</option>
					<option value="건강" <%if(category.equals("건강")){%>selected<%}%>>건강</option>
					<option value="자동차" <%if(category.equals("자동차")){%>selected<%}%>>자동차</option>
					<option value="공구" <%if(category.equals("공구")){%>selected<%}%>>공구</option>
					<option value="여행" <%if(category.equals("여행")){%>selected<%}%>>여행</option>
					<option value="도서" <%if(category.equals("도서")){%>selected<%}%>>도서</option>
					<option value="티켓/e쿠폰" <%if(category.equals("티켓/e쿠폰")){%>selected<%}%>>티켓/e쿠폰</option>
				</select>
				<select id="select_more_cate" name="more_category">
					<option>세부 카테고리 선택</option>
				</select>
			</div>
			
			<jsp:include page="editor.html"/>
			<script type="text/javascript">
				Editor.modify({"content": '<%=content %>'});
			</script>
			
			<div id="editor_submit">
				<button class="btn" onclick='saveContent()'>수정 완료</button>
				<input type="reset" value="취소" class="btn"/>
			</div>
			
		</form>
		</div>
	</div>
	
	<%@include file="../inc/footer.jsp" %>
	
	<script>
	var coords = "<%=coords %>";
    coords = coords.replace("(", "").replace(")", "").split(",");
    coords = new daum.maps.LatLng(coords[0], coords[1]);
    
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: coords, // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
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
		if(coords != "(37.537187, 127.005476)") {
			infowindow.setContent(content);
			infowindow.open(map, marker);
		}
    });
    
    var detailAddr;
 // 지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
    daum.maps.event.addListener(map, 'click', function(mouseEvent) {
        searchDetailAddrFromCoords(mouseEvent.latLng, function(status, result) {
            if (status === daum.maps.services.Status.OK) {
                detailAddr = !!result[0].roadAddress.name ? '<div>도로명주소 : ' + result[0].roadAddress.name + '</div>' : '';
                detailAddr += '<div>지번 주소 : ' + result[0].jibunAddress.name + '</div><br/>';
                
                content = '<div class="bAddr">' +
                                '<span class="title">주소정보</span>' + 
                                detailAddr + 
                            '</div>';

                // 마커를 클릭한 위치에 표시합니다 
                marker.setPosition(mouseEvent.latLng);
                marker.setMap(map);
                
                /*-----------------------------------------------*/
                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById("sample5_address").value = result[0].roadAddress.name ? result[0].roadAddress.name : result[0].jibunAddress.name;
                document.getElementById("coords").value = mouseEvent.latLng;
                /*-----------------------------------------------*/

                // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
                infowindow.setContent(content);
                infowindow.open(map, marker);
            }   
        });
    });

    function searchAddrFromCoords(coords, callback) {
        // 좌표로 행정동 주소 정보를 요청합니다
        geocoder.coord2addr(coords, callback);         
    }

    function searchDetailAddrFromCoords(coords, callback) {
        // 좌표로 법정동 상세 주소 정보를 요청합니다
        geocoder.coord2detailaddr(coords, callback);
    }

    function sample5_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = data.address; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 기본 주소가 도로명 타입일때 조합한다.
                if(data.addressType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById("sample5_address").value = fullAddr;
                // 주소로 좌표를 검색
                geocoder.addr2coord(data.address, function(status, result) {
                    // 정상적으로 검색이 완료됐으면
                    if (status === daum.maps.services.Status.OK) {
                        // 해당 주소에 대한 좌표를 받아서
                        var coords = new daum.maps.LatLng(result.addr[0].lat, result.addr[0].lng);
                        // 지도를 보여준다.
                        mapContainer.style.display = "block";
                        map.relayout();
                        // 지도 중심을 변경한다.
                        map.setCenter(coords);
                        // 마커를 결과값으로 받은 위치로 옮긴다.
                        marker.setPosition(coords)
                        
                        detailAddr = !!data.roadAddress ? '<div>도로명주소 : ' + data.roadAddress + '</div>' : '';
                        detailAddr += '<div>지번 주소 : ' + data.jibunAddress + '</div>';
                        
                        content = '<div class="bAddr">' +
                                        '<span class="title">주소정보</span>' + 
                                        detailAddr + 
                                    '</div>';

                        // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
                        infowindow.setContent(content);
                        infowindow.open(map, marker);
                        
                        document.getElementById("coords").value = coords;
                    }
                });
            }
        }).open();
    }
</script>
</body>
</html>