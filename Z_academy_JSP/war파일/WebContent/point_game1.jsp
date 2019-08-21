<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>		 
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>IT Will ToTo</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1">
<link href="css/pointGame1M.css" media="screen and (min-width: 1px) " rel="stylesheet">
<link href="css/pointGame1D.css" media="screen and (min-width: 700px)" rel="stylesheet">
<link rel="shortcut icon" href="favicon/favicon.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		updateData();
		
		var check = "${user_member}";
		if(check == ''){
			alert("회원만 입장 가능합니다");
			location.href="index.do";
		}	
		
	    $("#game_menu").click(function(){
	        $("#game_menu_list").slideToggle("slow");
	    });
	});
	
	$(function() {
	    var count = $('#Message-list li').length;
	    var height = $('#Message-list li').height();

	    function step(index) {
	        $('#Message-list ol').delay(3000).animate({
	            top: -height * index,
	        }, 500, function() {
	            step((index + 1) % count);
	        });
	    }

	    step(1);
	});
	
function updateData(){
	
		$.ajax({ 
			type: 'post', 
			url: 'point_game1_ajax.jsp', 
			dataType : 'html', 
			success: function(data) { 
				$("#game1").html(data); 
			} 
	});

	setTimeout("updateData()",1000);
}
</script>
</head>
<body>
<div id="wrap">
		<div id="nav">
			<input type="image" src="image/icon1.png" onclick="location.href='index.do'">
			<input type="image" src="image/icon2.png" onclick="location.href='board.do'">
			<input type="image" src="image/icon3.png" onclick="location.href='point_game1.do'">
			<input type="image" src="image/icon4.png" onclick="location.href='point_rank.do'">
			<input type="image" src="image/icon5.png" onclick="location.href='point_trade.do'">
		</div>
		<div id="section">
		<div id="game_menu"><label>게임 메뉴</label></div>
		<div id="game_menu_list">
			<ul>
				<li><a href="point_game1.do">뽑 아 뽑 아</a></li>
				<li><a href="point_game2.do">멈 춰 멈 춰</a></li>
				<li><a href="point_game3.do">맞 춰 맞 춰</a></li>
				<li><a href="point_game4.do">달 려 달 려</a></li>
			</ul>
		</div>
			<div><img src="image/point_game1Logo.png" class="gameLogo"></div>
			<p class="game_message">실시간 유니크 당첨자</p>
			<div id="gameMessage">
			<dl id="Message-list">
                <dd>
                    <ol>
                  		<c:forEach var="user" items="${win}">
    		 				<li>${user.game_id}님 ${user.num}번에서 당첨 (${user.game_time})</li>
  						</c:forEach>
                    </ol>
                </dd>
            </dl>
			</div>
			<p class="mypoint">나의 보유 포인트 : ${user_member.point}</p>
			<form action="point_game1_ok.do" method="post">
				<div id = "game1">
				</div>
				<input type="hidden" name="my_point" value="${user_member.point}">
				<input type="hidden" name="my_id" value="${user_member.id}">
			</form>
		<div><img src="image/point_game1_rule.png" class="gameRule"></div>
		</div>
		<div id="footer">
		<c:if test="${user_member ne null}">
			<p><input type="button" value="로그아웃" onclick="location.href='logout.do'">
			<input type="button" value="개인정보수정" onclick="location.href='member_modify.do'"></p> 	
			<p>By. SungKuk</p>
		</c:if>
		
		</div>
	</div>
</body>
</html>