<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>		 
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>IT Will ToTo</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1">
<link href="css/pointGame3M.css" media="screen and (min-width: 1px) " rel="stylesheet">
<link href="css/pointGame3D.css" media="screen and (min-width: 700px)" rel="stylesheet">
<link rel="shortcut icon" href="favicon/favicon.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
	/* var agent = navigator.userAgent.toLowerCase();
	if (agent.indexOf("msie") != -1) {
		alert("익스플로러 브라우저는 접근이 불가능합니다");
		location.href="index.do";
	}else if((navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1) ) {
		alert("익스플로러 브라우저는 접근이 불가능합니다");
		location.href="index.do";
	} */

	var num1 = Math.floor(Math.random()*9) + 1;
	var num2 = Math.floor(Math.random()*9) + 1;
	var num3 = Math.floor(Math.random()*9) + 1;
	var num4 = Math.floor(Math.random()*9) + 1;
	var num5 = Math.floor(Math.random()*9) + 1;
	var num6 = Math.floor(Math.random()*9) + 1;
	var num7 = Math.floor(Math.random()*9) + 1;
	var num8 = Math.floor(Math.random()*9) + 1;
	var num9 = Math.floor(Math.random()*9) + 1;
	
	var time1 = Math.floor(Math.random()*600) + 1;
	var time2 = Math.floor(Math.random()*450) + 1;
	var time3 = Math.floor(Math.random()*400) + 1;
	var time4 = Math.floor(Math.random()*150) + 1;
	var time5 = Math.floor(Math.random()*250) + 1;
	var time6 = Math.floor(Math.random()*250) + 1;
	var time7 = Math.floor(Math.random()*200) + 1;
	var time8 = Math.floor(Math.random()*400) + 1;
	var time9 = Math.floor(Math.random()*350) + 1;

	$("#game_num1").val(num1); 
	$("#game_num2").val(num2); 
	$("#game_num3").val(num3); 
	$("#game_num4").val(num4); 
	$("#game_num5").val(num5); 
	$("#game_num6").val(num6); 
	$("#game_num7").val(num7); 
	$("#game_num8").val(num8); 
	$("#game_num9").val(num9); 
	
	
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
		$("#radio_div").hide();
		window.t1 = setInterval(start1, time1);
		window.t2 = setInterval(start2, time2);
		window.t3 = setInterval(start3, time3);
		window.t4 = setInterval(start4, time4);
		window.t5 = setInterval(start5, time5);
		window.t6 = setInterval(start6, time6);
		window.t7 = setInterval(start7, time7);
		window.t8 = setInterval(start8, time8);
		window.t9 = setInterval(start9, time9);

		
		function start1(){	  
			var game_num1 =  $("#game_num1").val();
		    $("#game_num1").val((game_num1 * 1) + 1);
		    if(game_num1 == 9){
		    	$("#game_num1").val(1);
		    }
		}
		function start2(){	  
			var game_num2 =  $("#game_num2").val();
		    $("#game_num2").val((game_num2 * 1) + 1);
		    if(game_num2 == 9){
		    	$("#game_num2").val(1);
		    }
		}
		function start3(){	  
			var game_num3 =  $("#game_num3").val();
		    $("#game_num3").val((game_num3 * 1) + 1);
		    if(game_num3 == 9){
		    	$("#game_num3").val(1);
		    }
		}
		function start4(){	  
			var game_num4 =  $("#game_num4").val();
		    $("#game_num4").val((game_num4 * 1) + 1);
		    if(game_num4 == 9){
		    	$("#game_num4").val(1);
		    }
		}
		function start5(){	  
			var game_num5 =  $("#game_num5").val();
		    $("#game_num5").val((game_num5 * 1) + 1);
		    if(game_num5 == 9){
		    	$("#game_num5").val(1);
		    }
		}
		function start6(){	  
			var game_num6 =  $("#game_num6").val();
		    $("#game_num6").val((game_num6 * 1) + 1);
		    if(game_num6 == 9){
		    	$("#game_num6").val(1);
		    }
		}
		function start7(){	  
			var game_num7 =  $("#game_num7").val();
		    $("#game_num7").val((game_num7 * 1) + 1);
		    if(game_num7 == 9){
		    	$("#game_num7").val(1);
		    }
		}
		function start8(){	  
			var game_num8 =  $("#game_num8").val();
		    $("#game_num8").val((game_num8 * 1) + 1);
		    if(game_num8 == 9){
		    	$("#game_num8").val(1);
		    }
		}
		function start9(){	  
			var game_num9 =  $("#game_num9").val();
		    $("#game_num9").val((game_num9 * 1) + 1);
		    if(game_num9 == 9){
		    	$("#game_num9").val(1);
		    }
		}
	});
	
	$("#gamestop").click(function(){
		clearInterval(t1);
		clearInterval(t2);
		clearInterval(t3);
		clearInterval(t4);
		clearInterval(t5);
		clearInterval(t6);
		clearInterval(t7);
		clearInterval(t8);
		clearInterval(t9);
		
		/* var n1 = $("#game_num1").val();
		var n2 = $("#game_num2").val();
		var n3 = $("#game_num3").val();
		var n4 = $("#game_num4").val();
		var n5 = $("#game_num5").val();
		var n6 = $("#game_num6").val();
		var n7 = $("#game_num7").val();
		var n8 = $("#game_num8").val();
		var n9 = $("#game_num9").val();
		var r = $("#result_num").val();
		var count = 0;
		
		if(r == n1){count++;}
		if(r == n2){count++;}
		if(r == n3){count++;}
		if(r == n4){count++;}
		if(r == n5){count++;}
		if(r == n6){count++;}
		if(r == n7){count++;}
		if(r == n8){count++;}
		if(r == n9){count++;}
		
		alert("일치 개수 : "+count); */
		document.game3_form.submit();
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
		<div><img src="image/point_game3Logo.png" class="gameLogo"></div>
			<p class="mypoint">나의 보유 포인트 : ${user_member.point}</p>
			<div id="game3">
			<form action="point_game3_ok.do" method="post" name="game3_form">
				<input type="text" class="game_num" name="game_num1" id="game_num1" value="1" readonly="readonly">
				<input type="text" class="game_num" name="game_num2" id="game_num2" value="1" readonly="readonly">
				<input type="text" class="game_num" name="game_num3" id="game_num3" value="1" readonly="readonly"><br>
				<input type="text" class="game_num" name="game_num4" id="game_num4" value="1" readonly="readonly">
				<input type="text" class="game_num" name="game_num5" id="game_num5" value="1" readonly="readonly">
				<input type="text" class="game_num" name="game_num6" id="game_num6" value="1" readonly="readonly"><br>
				<input type="text" class="game_num" name="game_num7" id="game_num7" value="1" readonly="readonly">
				<input type="text" class="game_num" name="game_num8" id="game_num8" value="1" readonly="readonly">
				<input type="text" class="game_num" name="game_num9" id="game_num9" value="1" readonly="readonly"><br>
				<div id="radio_div">
				<p class="radio_p"><label>숫자 선택</label><p>
				<input type="radio" id="result_num" name="result_num" value="1" checked="checked"><span class="radio_font"><label>1</label></span>
				<input type="radio" id="result_num" name="result_num" value="2"><span class="radio_font"><label>2</label></span>
				<input type="radio" id="result_num" name="result_num" value="3"><span class="radio_font"><label>3</label></span>
				<input type="radio" id="result_num" name="result_num" value="4"><span class="radio_font"><label>4</label></span>
				<input type="radio" id="result_num" name="result_num" value="5"><span class="radio_font"><label>5</label></span>
				<input type="radio" id="result_num" name="result_num" value="6"><span class="radio_font"><label>6</label></span>
				<input type="radio" id="result_num" name="result_num" value="7"><span class="radio_font"><label>7</label></span>
				<input type="radio" id="result_num" name="result_num" value="8"><span class="radio_font"><label>8</label></span>
				<input type="radio" id="result_num" name="result_num" value="9"><span class="radio_font"><label>9</label></span>
				</div>
				<input type="hidden" name="my_id" value="${user_member.id}">
			</form>
				<input type="button" class="gamestart" id="gamestart" value="시작">
				<input type="button" class="gamestop" id="gamestop" value="스탑">
			</div>
		<div><img src="image/point_game3_rule.png" class="gameRule"></div>
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