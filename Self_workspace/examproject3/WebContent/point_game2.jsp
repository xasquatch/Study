<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>		 
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>IT Will ToTo</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1">
<link href="css/pointGame2M.css" media="screen and (min-width: 1px) " rel="stylesheet">
<link href="css/pointGame2D.css" media="screen and (min-width: 700px)" rel="stylesheet">
<link rel="shortcut icon" href="favicon/favicon.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
	/*var agent = navigator.userAgent.toLowerCase();
	 if (agent.indexOf("msie") != -1) {
		alert("익스플로러 브라우저는 접근이 불가능합니다");
		location.href="index.do";
	}else if((navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1) ) {
		alert("익스플로러 브라우저는 접근이 불가능합니다");
		location.href="index.do";
	} */
	
	var check = "${user_member}";
	if(check == ''){
		alert("회원만 입장 가능합니다");
		location.href="index.do";
	}	
	
	 $("#game_menu").click(function(){
	        $("#game_menu_list").slideToggle("slow");
	 });

	
	 
	 
	 $("#gamestart").click(function(){
			$("#gamestart").attr("disabled","disabled");
			window.t = setInterval(start, 60);

			function start(){	  
				var game_num =  $("#game_num").val();
			    $("#game_num").val((game_num * 1) + 1);
			    if(game_num == 200){
			    	$("#game_num").val(1);
			    }
			}
			
			
		});
	
	 $("#gamestop").click(function(){
		 var game_num =  $("#game_num").val();
			clearInterval(t);
			var result;
			if(game_num == 1){
				result = " (달인!)";
			}else if(game_num >=2 && game_num < 89){
				result = " (순발력 제로!)";
			}else if(game_num >=90 && game_num < 99){
				result = " (평균!)";
			}else if(game_num == 100){
				result = " (고수!)";
			}else if(game_num >= 101 && game_num < 199){
				result = " (순발력 제로!)";
			}else if(game_num == 200){
				result = " (달인을 노리는 자!)";
			}
			alert("멈춘 숫자 : "+game_num+result);
			game2_form.submit();
		});

});
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
		<div><img src="image/point_game2Logo.png" class="gameLogo"></div>
			<p class="mypoint">나의 보유 포인트 : ${user_member.point}</p>
			<div id="game2">
			<form action="point_game2_ok.do" method="post" name="game2_form">
				<input type="text" class="game_num" name="game_num" id="game_num" value="1" readonly="readonly"><br>
				<input type="hidden" name="my_id" value="${user_member.id}">
			</form>
				<input type="button" class="gamestart" id="gamestart" value="시작">
				<input type="button" class="gamestop" id="gamestop" value="스탑">
			</div>
		<div><img src="image/point_game2_rule.png" class="gameRule"></div>
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