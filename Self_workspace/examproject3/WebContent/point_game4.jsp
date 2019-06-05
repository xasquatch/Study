<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>		 
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>IT Will ToTo</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1">
<link href="css/pointGame4M.css" media="screen and (min-width: 1px) " rel="stylesheet">
<link href="css/pointGame4D.css" media="screen and (min-width: 700px)" rel="stylesheet">
<link rel="shortcut icon" href="favicon/favicon.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script>
	$("document").ready(function(){
		$("input:text").keydown(function(evt){ 
			if (evt.keyCode == 13) {
				alert("시작버튼을 눌러주세요");
				return false; 
			}
		});
		var dividend_point_flag = 0;
		var stop = false;
		var check = "${user_member}";
		if(check == ''){
			alert("회원만 입장 가능합니다");
			location.href="index.do";
		}	

		 $("#game_menu").click(function(){
		        $("#game_menu_list").slideToggle("slow");
		 });
		 
		var num1 = Math.floor(Math.random()*800) + 600;
		var num2 = Math.floor(Math.random()*800) + 600;
		var num3 = Math.floor(Math.random()*800) + 600;
		var num4 = Math.floor(Math.random()*800) + 600;
		var num5 = Math.floor(Math.random()*800) + 600;
		
		
		function result(num, url){
			if(stop == false){
				stop = true;
				alert(num+"번마 도착");
				location.href=url;
			}
		}
		
		$("#start").click(function(){
			if(dividend_point_flag == 1){
			$("#start").hide();
			$("#r1").hide();
			$("#r2").hide();
			$("#r3").hide();
			$("#r4").hide();
			$("#r5").hide();
			$("#radio_div").hide();
			$("#dividend_point").hide();
			$(".dividend_point_check").hide();
			$("#h1").animate({marginLeft : "70%"},num1,function(){
				result(1);
			});
			$("#h2").animate({marginLeft : "70%"},num2,function(){
				result(2);
			});
			$("#h3").animate({marginLeft : "70%"},num3,function(){
				result(3);
			});
			$("#h4").animate({marginLeft : "70%"},num4,function(){
				result(4);
			});
			$("#h5").animate({marginLeft : "70%"},num5,function(){
				result(5);
			});
			}else{
				alert("배팅 포인트를 올바르게 입력해주세요");
				return false;
			}
	});
		
	
	$("#dividend_point").keyup(function(){
		var dividend_point = $("#dividend_point").val();
		var point = ${user_member.point};
		if(!dividend_point){
			$(".dividend_point_check").show();
			$(".dividend_point_check").html("배팅 포인트를 입력해주세요");
			dividend_point_flag = 0;
			return false;
		}else if(dividend_point < 1000){
			$(".dividend_point_check").show();
			$(".dividend_point_check").html("최소 배팅포인트는 1000포인트 입니다");
			dividend_point_flag = 0;
			return false;
		}else if(dividend_point % 100 != 0){
			$(".dividend_point_check").show();
			$(".dividend_point_check").html("배팅 단위는 100포인트 입니다");
			dividend_point_flag = 0;
			return false;
		}else if(point < dividend_point){
			$(".dividend_point_check").show();
			$(".dividend_point_check").html("포인트가 부족합니다");
			dividend_point_flag = 0;
			return false;
		}
		$(".dividend_point_check").html("OK");
		dividend_point_flag = 1;
		
	});
	

	function result(num){
			if(stop == false){
				stop = true;
				alert(num+"번마 도착");
				$("#result").val(num);
				game4_form.submit();
		}
	}
	
	
	
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
		<div><img src="image/point_game4Logo.png" class="gameLogo"></div>
			<p class="mypoint">나의 보유 포인트 : ${user_member.point}</p>
			<div id="game4">
			<form action="point_game4_ok.do" method="post" name="game4_form">
				<div id="h1">1</div>
				<div id="h2">2</div>
				<div id="h3">3</div>
				<div id="h4">4</div>
				<div id="h5">5</div>
			<div id="radio_div">
			<p class="radio_p"><label>말 선택</label><p>
			<input type="radio" name="num" value="1" id="r1" checked="checked"><span class="radio_font"><label>1번</label></span>
			<input type="radio" name="num" value="2" id="r2"><span class="radio_font"><label>2번</label></span>
			<input type="radio" name="num" value="3" id="r3"><span class="radio_font"><label>3번</label></span>
			<input type="radio" name="num" value="4" id="r4"><span class="radio_font"><label>4번</label></span>
			<input type="radio" name="num" value="5" id="r5"><span class="radio_font"><label>5번</label></span><br>
			</div>
			<input type="text" name="dividend_point" id="dividend_point" placeholder="배팅 포인트 입력">
			<p class="dividend_point_check"></p>
			<input type="hidden" name="result" value="0" id="result">
			<input type="hidden" name="my_id" value="${user_member.id}">
			</form>
			<input type="button" value="시작" id="start">
			</div>
		<div><img src="image/point_game4_rule.png" class="gameRule"></div>
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