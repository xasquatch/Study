<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="myboard.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hbay</title>
<link rel="stylesheet" href="css/main.css"/>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="js/slider.js"></script>
<script>
	$(function() {
		$("#hover_menu").hide();
		$("#hover_menu div[class!='inner']").hide();
		
		//메뉴바 마우스 오버/아웃시 이벤트
		$("#top_menu nav li").on("mouseover", function() {
			$("#hover_menu div[class!='inner']").hide();
			$("#hover_menu #h" + $(this).attr("id")).show();
			$("#hover_menu").stop().slideDown();
		});
		$("#top_menu nav li").on("mouseout", function() {
			$("#hover_menu").stop().slideUp();
		});
		$("#hover_menu").on("mouseover", function() {
			$("#hover_menu").stop().slideDown();
		});
		$("#hover_menu").on("mouseout", function() {
			$("#hover_menu").stop().slideUp();
		});
		
		//Hbay Items의 사진 크기 조정 및 가운데 정렬
		var max_height = 180;
		var width = 0, height = 0;
		var image_div = $(".features_img img");
		for(var i = 0; i < image_div.length; i++) {
			var image = image_div[i];
			var height = Number($(image).css("height").replace("px", ""));
			var width = Number($(image).css("width").replace("px", ""));
			if(height <= max_height) {
				$(image).css("margin-top", (max_height - height) / 2 + "px");
			} else {
				$(image).css("width", width / (height / max_height) + "px");
			}
		}
		
		//갤러리 이미지에 마우스 오버/아웃시 item_info내용 표시
// 		$(".gallery_img").on("mouseover", function() {
// 			$(this).children(".item_info").stop().animate({opacity:"0.9"}, 500);
// 		});
// 		$(".gallery_img").on("mouseout", function() {
// 			$(this).children(".item_info").stop().animate({opacity:"0"}, 500);
// 		});
	});
	
	
	//캐러셀/슬라이더 이벤트
	$(function() {
		setSlider("#carousel", 980, 1, true);
	});
</script>
</head>
<body>
	<!-- 최상단 로그인/회원가입/장바구니 등을 표시할 div -->
	<%@include file="inc/top_lg.jsp" %>

	<div id="wrap" class="wrap_min">
		<!-- 헤더 -->
		<header>
			<%@include file="inc/logo.jsp" %>
			<!-- 상단 검색어 입력창  -->
			<form action="board/board.jsp" method="post">
				<%@include file="inc/search.jsp" %>
			</form>
			<div class="clear"></div>
			
			<!-- 메뉴바 + 호버 메뉴 영역 -->
			<div id="top_menu">
				<!-- 메뉴바 -->
				<nav>
					<ul>
						<li id="m1"><a href="">패션의류·잡화</a></li>
						<li id="m2"><a href="">유아동</a></li>
						<li id="m3"><a href="">홈데코·문구·취미</a></li>
						<li id="m4"><a href="">컴퓨터·디지털·가전</a></li>
						<li id="m5"><a href="">스포츠 건강</a></li>
						<li id="m6"><a href="">자동차·공구</a></li>
						<li id="m7"><a href="">여행·도서·티켓·e쿠폰</a></li>
					</ul>
				</nav>
				
				<!-- 호버 메뉴 -->
				<div id="hover_menu">
					<div id="hm1">
						<div class="inner">
							<h3>패션의류</h3>
							<ul>
								<li><a href="board/board.jsp?more_category=여성의류">여성의류</a></li>
								<li><a href="board/board.jsp?more_category=남성의류">남성의류</a></li>
								<li><a href="board/board.jsp?more_category=언더웨어">언더웨어</a></li>
								<li><a href="board/board.jsp?more_category=유아동의류">유아동의류</a></li>
							</ul>
						</div>
						<div class="inner">
							<h3>잡화</h3>
							<ul>
								<li><a href="board/board.jsp?more_category=신발">신발</a></li>
								<li><a href="board/board.jsp?more_category=유아동신발/잡화">유아동신발/잡화</a></li>
								<li><a href="board/board.jsp?more_category=가방/잡화">가방/잡화</a></li>
								<li><a href="board/board.jsp?more_category=쥬얼리/시계">쥬얼리/시계</a></li>
								<li><a href="board/board.jsp?more_category=수입명품">수입명품</a></li>
							</ul>
						</div>
						<img src="images/fashion.jpg"/>
					</div>
					<div id="hm2">
						<div class="inner">
							<h3>유아동</h3>
							<ul>
								<li><a href="board/board.jsp?more_category=기저귀/분유/유아식">기저귀/분유/유아식</a></li>
								<li><a href="board/board.jsp?more_category=육아용품">육아용품</a></li>
								<li><a href="board/board.jsp?more_category=장난감">장난감</a></li>
								<li><a href="board/board.jsp?more_category=유아동의류">유아동의류</a></li>
								<li><a href="board/board.jsp?more_category=유아동신발/잡화">유아동신발/잡화</a></li>
								<li><a href="board/board.jsp?more_category=브랜드 아동패션">브랜드 아동패션</a></li>
							</ul>
						</div>
						<img src="images/baby.jpg"/>
					</div>
					<div id="hm3">
						<div class="inner">
							<h3>홈데코</h3>
							<ul>
								<li><a href="board/board.jsp?more_category=가구/DIY">가구/DIY</a></li>
								<li><a href="board/board.jsp?more_category=침구/커튼">침구/커튼</a></li>
								<li><a href="board/board.jsp?more_category=조명/인테리어">조명/인테리어</a></li>
								<li><a href="board/board.jsp?more_category=생활용품">생활용품</a></li>
								<li><a href="board/board.jsp?more_category=주방용품">주방용품</a></li>
								<li><a href="board/board.jsp?more_category=꽃/이벤트용품">꽃/이벤트용품</a></li>
							</ul>
						</div>
						<div class="inner">
							<h3>문구</h3>
							<ul>
								<li><a href="board/board.jsp?more_category=문구/사무용품">문구/사무용품</a></li>
								<li><a href="board/board.jsp?more_category=사무기기">사무기기</a></li>
							</ul>
						</div>
						<div class="inner">
							<h3>취미</h3>
							<ul>
								<li><a href="board/board.jsp?more_category=악기/수집">악기/수집</a></li>
								<li><a href="board/board.jsp?more_category=반려동물용품">반려동물용품</a></li>
							</ul>
						</div>
						<img src="images/home_deco.jpg"/>
					</div>
					<div id="hm4">
						<div class="inner">
							<h3>컴퓨터</h3>
							<ul>
								<li><a href="board/board.jsp?more_category=노트북/PC">노트북/PC</a></li>
								<li><a href="board/board.jsp?more_category=모니터/프린터">모니터/프린터</a></li>
								<li><a href="board/board.jsp?more_category=PC주변기기">PC주변기기</a></li>
								<li><a href="board/board.jsp?more_category=저장장치">저장장치</a></li>
							</ul>
						</div>
						<div class="inner">
							<h3>디지털</h3>
							<ul>
								<li><a href="board/board.jsp?more_category=휴대폰">휴대폰</a></li>
								<li><a href="board/board.jsp?more_category=카메라">카메라</a></li>
								<li><a href="board/board.jsp?more_category=태블릿">태블릿</a></li>
								<li><a href="board/board.jsp?more_category=게임">게임</a></li>
								<li><a href="board/board.jsp?more_category=음향기기">음향기기</a></li>
							</ul>
						</div>
						<div class="inner">
							<h3>가전</h3>
							<ul>
								<li><a href="board/board.jsp?more_category=대형가전">대형가전</a></li>
								<li><a href="board/board.jsp?more_category=주방가전">주방가전</a></li>
								<li><a href="board/board.jsp?more_category=계절가전">계절가전</a></li>
								<li><a href="board/board.jsp?more_category=생활/미용가전">생활/미용가전</a></li>
								<li><a href="board/board.jsp?more_category=음향가전">음향가전</a></li>
								<li><a href="board/board.jsp?more_category=건강가전">건강가전</a></li>
							</ul>
						</div>
						<img src="images/computer.jpg"/>
					</div>
					<div id="hm5">
						<div class="inner">
							<h3>스포츠</h3>
							<ul>
								<li><a href="board/board.jsp?more_category=스포츠의류/운동화">스포츠의류/운동화</a></li>
								<li><a href="board/board.jsp?more_category=휘트니스/수영">휘트니스/수영</a></li>
								<li><a href="board/board.jsp?more_category=구기/라켓">구기/라켓</a></li>
								<li><a href="board/board.jsp?more_category=골프">골프</a></li>
								<li><a href="board/board.jsp?more_category=자전거/보드">자전거/보드</a></li>
								<li><a href="board/board.jsp?more_category=캠핑/낚시">캠핑/낚시</a></li>
								<li><a href="board/board.jsp?more_category=등산">등산</a></li>
							</ul>
						</div>
						<div class="inner">
							<h3>건강</h3>
							<ul>
								<li><a href="board/board.jsp?more_category=건강/의료용품">건강/의료용품</a></li>
								<li><a href="board/board.jsp?more_category=건강식품">건강식품</a></li>
								<li><a href="board/board.jsp?more_category=운동용품">운동용품</a></li>
							</ul>
						</div>
						<img src="images/sports.jpg"/>
					</div>
					<div id="hm6">
						<div class="inner">
							<h3>자동차</h3>
							<ul>
								<li><a href="board/board.jsp?more_category=자동차용품">자동차용품</a></li>
								<li><a href="board/board.jsp?more_category=타이어/부품">타이어/부품</a></li>
							</ul>	
						</div>
						<div class="inner">
							<h3>공구</h3>
							<ul>
								<li><a href="board/board.jsp?more_category=공구설비/자재">공구설비/자재</a></li>
							</ul>
						</div>
						<img src="images/car.jpg"/>
					</div>
					<div id="hm7">
						<div class="inner">
							<h3>여행</h3>
							<ul>
								<li><a href="board/board.jsp?more_category=여행/항공권">여행/항공권</a></li>
							</ul>
						</div>
						<div class="inner">
							<h3>도서</h3>
							<ul>
								<li><a href="board/board.jsp?more_category=도서음반/e교육">도서음반/e교육</a></li>
							</ul>
						</div>
						<div class="inner">
							<h3>티켓/e쿠폰</h3>
							<ul>
								<li><a href="board/board.jsp?more_category=티켓">티켓</a></li>
								<li><a href="board/board.jsp?more_category=e쿠폰">e쿠폰</a></li>
								<li><a href="board/board.jsp?more_category=상품권">상품권</a></li>
							</ul>
						</div>
						<img src="images/book.jpg"/>
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
		
		<!-- 배너 이미지가 들어갈 영역 (캐러셀) -->
		<div id="carousel">
			<div class="leftArrow"></div>
			<div class="innerDiv">
				<img src="images/banner.jpg" class="banner"/>
				<img src="images/banner4.jpg" class="banner"/>
				<img src="images/banner3.jpg" class="banner"/>
			</div>
			<div class="rightArrow"></div>
		</div>
		
		<!-- 본문 -->
		<article>
			<div id="features">
				<h1 class="features_title">Hbay Features</h1>
				<div class="features_content">
					<h1>안전거래</h1>
					<p>고객들의 보다 안전한 거래를 위해서 신원 확인 절차를 강화하였습니다. 이제 안심하고 구매하세요!</p>
				</div>
				<div class="features_content">
					<h1>국내 1위</h1>
					<p>국내 중고거래 사이트 부문 1위! 다양한 카테고리를 제공하므로써 폭넓은 쇼핑을 즐기실 수 있습니다.</p>
				</div>
				<div class="features_content">
					<h1>로켓 배송</h1>
					<p>로켓 같이 빠른 배송으로 정확하고 신속하게 고객들의 문 앞으로 배송해 드립니다. </p>
				</div>
				<div class="clear"></div>
			</div>
			
			<div id="items">
				<h1 class="features_title">Hbay Items</h1>
				<jsp:useBean id="dao" class="myboard.BoardDao"/>
				<jsp:useBean id="dto" class="myboard.BoardDto"/>
				<% 
				List<BoardDto> li = new ArrayList<BoardDto>();
				li = dao.getBoardList(0, 6);
				
				for(int i = 0; i < li.size(); i++) {
					dto = li.get(i);
					
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
					<div class="features_content">
						<div class="features_img">
							<a href="board/content.jsp?no=<%=dto.getNo() %>"><img src="<%=dto.getMain_img().replace("../", "") %>"/></a>
						</div>
						<h2><%=dto.getTitle().length() > 20 ? dto.getTitle().substring(0, 20) + "..." : dto.getTitle() %></h2>
						<div class="price">
						<%
						if(dto.getBin_price() != 0) {
							%>
							<%=dto.getBin_price() %>원<span class="orange">(바로구매)</span>
							<%
						}
						%>
						</div>
						<div class="price">
						<%
						if(dto.getBid_price() != 0) {
							%>
							<%=dto.getBid_price() %>원<span class="orange">(경매)</span>
							<%
						}
						%>
						</div>
						<div class="left_time"><%=left_time2 %> 남음</div>
						<button onclick="location.href='board/content.jsp?no=<%=dto.getNo() %>'">자세히 보기</button>
					</div>
					<%
					if((i+1) % 3 == 0) {
						%><div class="clear"></div><%
					}
					%>
					<%
				}
				%>
				<div class="clear"></div>
			</div>
		</article>
		
		<div class="clear"></div>
	</div>
	
	<!-- 푸터 -->
	<%@include file="inc/footer.jsp" %>
</body>
</html>