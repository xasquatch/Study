<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>IT Will ToTo</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1">
<link href="css/pointTradeM.css" media="screen and (min-width: 1px) " rel="stylesheet">
<link href="css/pointTradeD.css" media="screen and (min-width: 700px)" rel="stylesheet">
<link rel="shortcut icon" href="favicon/favicon.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script>
$(document).ready(function(){	
	var flag1 = false;
	var flag2 = false;
	var check = "${user_member}";
	var myid = "${user_member.id}";
	var mypoint = "${user_member.point}";
	var trade_check = "${trade_check}";
	
	if(check == ''){
		alert("회원만 입장 가능합니다");
		location.href="index.do";
	}
	if(trade_check == "YES"){
		alert("송금완료하였습니다");
	}
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
	
	$("#user_id").keyup(function(){
		var user_id = $('#user_id').val();
		if(!user_id ){
			$(".trade_check").html("받는사람의 ID를 입력해주세요");
			return false;
		}else if(user_id == myid){
			$(".trade_check").html("본인에게는 보낼 수 없습니다");
			return false;
		}
	
		$.ajax({ 
			type: 'post', 
			data: {"user_id" : user_id},
			dataType : 'text',
			url: 'trade_check.jsp', 
			success: function(data) { 
				if($.trim(data) == "YES"){	
					flag1 = true;
					$(".trade_check").html("OK");
				}else{
					flag1 = false;
					$(".trade_check").html("존재하지 않는 회원입니다");	
				}
			} 
	});
		
});	
	$("#user_id").blur(function(){
		var user_id = $('#user_id').val();
		if(!user_id ){
			$(".trade_check").html("받는사람의 ID를 입력해주세요");
			return false;
		}else if(user_id == myid){
			$(".trade_check").html("본인에게는 보낼 수 없습니다");
			return false;
		}
	
		$.ajax({ 
			type: 'post', 
			data: {"user_id" : user_id},
			dataType : 'text',
			url: 'trade_check.jsp', 
			success: function(data) { 
				if($.trim(data) == "YES"){	
					flag1 = true;
					$(".trade_check").html("OK");
				}else{
					flag1 = false;
					$(".trade_check").html("존재하지 않는 회원입니다");	
				}
			} 
	});
		
});		
	
	$("#trade_point").keyup(function(){
		var trade_point = $('#trade_point').val();
		if(!trade_point){
			$(".tradepoint_check").html("송금 Point를 입력해주세요");
			flag2 = false;
			return false;
		}else if(trade_point < 1000){
			$(".tradepoint_check").html("최소 1000Point 부터 송금가능합니다");
			flag2 = false;
			return false;
		}
		else if((trade_point % 100) != 0){
			$(".tradepoint_check").html("Point단위는 100Point 입니다");
			flag2 = false;
			return false;
		}else if(trade_point > mypoint){
			$(".tradepoint_check").html("포인트가 부족합니다");
			flag2 = false;
			return false;
		}
		$(".tradepoint_check").html("OK");
		flag2 = true;
});	
	
	$("#trade_point").blur(function(){
		var trade_point = $('#trade_point').val();
		if(!trade_point){
			$(".tradepoint_check").html("송금 Point를 입력해주세요");
			flag2 = false;
			return false;
		}else if(trade_point < 1000){
			$(".tradepoint_check").html("최소 1000Point 부터 송금가능합니다");
			flag2 = false;
			return false;
		}
		else if((trade_point % 100) != 0){
			$(".tradepoint_check").html("Point단위는 100Point 입니다");
			flag2 = false;
			return false;
		}else if(trade_point > mypoint){
			$(".tradepoint_check").html("포인트가 부족합니다");
			flag2 = false;
			return false;
		}
		$(".tradepoint_check").html("OK");
		flag2 = true;
});		

	$("#point_send").click(function(){
		var id = $("#id").val();
		if(flag1 == false || flag2 == false){
			alert("보낼사람의 ID와 송금포인트를 정확하게 입력해주세요");
			return false;
		}else if(myid != id){
			alert("ID가 서로 같지않습니다");
			return false;
		}
			document.pointTrade_form.submit();
	});
	
	$("#message_btn").click(function(){
		var message = $("#message").val();
		var message_id = $("#message_id").val();
		
		if(!message){
			alert("구걸 할 메시지를 적어주세요")
			return false;
		}else if(myid != message_id){
			alert("ID가 서로 같지않습니다");
			return false;
		}
		document.pointMessage_form.submit();
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

        
		<div id="pointTrade_form">
			<form action="point_message.do" method="post" name="pointMessage_form">
			<p class="point_message">실시간 구걸 메시지</p>
			
			
			<div id="pointMessage">
			<dl id="Message-list">
                <dd>
                    <ol>
                        <li>${message_list[0].id} : ${message_list[0].message}</li>
                        <li>${message_list[1].id} : ${message_list[1].message}</li>
                        <li>${message_list[2].id} : ${message_list[2].message}</li>
                        <li>${message_list[3].id} : ${message_list[3].message}</li>
                        <li>${message_list[4].id} : ${message_list[4].message}</li>
                    </ol>
                </dd>
            </dl>
			</div>
			
			
			<input type="text" name="message" id="message" maxlength="16" placeholder="구걸 메시지 입력 (최대 16자)">
			<input type="hidden" name="message_id" id="message_id" value='${user_member.id}' readonly="readonly">
			<input type="button" value="구걸하기" id="message_btn">
			</form>
			
			<form action="pointTrade_ok.do" method="post" name="pointTrade_form">
				 <img src="image/point_trade2.png">
				 <p class="my_point"><span>보유 포인트 : ${user_member.point} Point</span></p>
				 <input type="text" name="user_id" id="user_id" maxlength="16" placeholder="받는 사람의 ID입력">
				 <p class="trade_check">받는사람의 ID를 입력해주세요</p>
				 <input type="text" name="trade_point" id="trade_point" maxlength="10" placeholder="송금 Point입력 (100 Point 단위)">
				 <p class="tradepoint_check">송금 Point를 입력해주세요</p>
				 <input type="button" value="송금하기" id="point_send">
				 <input type="hidden" name="id" id="id" value='${user_member.id}' readonly="readonly">
				 <p class="notice">※받는 사람의 경우 재접속 후 확인 가능합니다※</p>
			</form>
		</div>

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