<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>IT Will ToTo</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1">
<link href="css/joinM.css" media="screen and (min-width: 1px) " rel="stylesheet">
<link href="css/joinD.css" media="screen and (min-width: 700px)" rel="stylesheet">
<link rel="shortcut icon" href="favicon/favicon.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script>
var chk1 = false;
var chk2 = false;
var chk3 = false;
var chk4 = false;
var chk5 = false;
var chk6 = false;
var chk7 = false;

$(document).ready(function(){
	$("#id").keyup(function(){
		var id = $('#id').val();
		if(!id){
			$(".id_check").html("아이디를 입력해주세요").show();
			$(".id_check_img").attr("src","image/join_chk2.png");
			chk1 = false;
			return false;
		}else if(id.match(/[^a-zA-Z0-9]/) != null){
			$(".id_check").html("아이디에 한글은 입력할 수 없습니다").show();
			$(".id_check_img").attr("src","image/join_chk2.png");
			chk1 = false;
			return false;
		}else if(id.length <= 4){
			$(".id_check").html("최소 아이디는 5자 이상이어야 합니다").show();
			$(".id_check_img").attr("src","image/join_chk2.png");
			chk1 = false;
			return false;
		}else if(id.length > 12){
			$(".id_check").html("최대 아이디는 12자 입니다").show();
			$(".id_check_img").attr("src","image/join_chk2.png");
			chk1 = false;
			return false;
		}
		$.ajax({ 
			type: 'post', 
			data: "id="+ id,
			dataType : 'text',
			url: 'id_check.jsp', 
			success: function(data) { 
				if($.trim(data) == "YES"){
					chk1 = false;	
					$(".id_check").html("아이디가 이미 존재합니다").show();
					$(".id_check_img").attr("src","image/join_chk2.png");
				}else{
					chk1 = true;
					$(".id_check").hide();	
					$(".id_check_img").attr("src","image/join_chk3.png");
				}
			} 
		});
	});
	
	
	$("#pw").keyup(function(){
		var pw = $('#pw').val();
		if(!pw){
			$(".pw_check").html("패스워드를 입력해주세요").show();
			$(".pw_check_img").attr("src","image/join_chk2.png");
			chk2 = false;
			return false;
		}else if(pw.length <= 5){
			$(".pw_check").html("최소 패스워드는 6자 입니다").show();
			$(".pw_check_img").attr("src","image/join_chk2.png");
			chk2 = false;
			return false;
		}else if(pw.length > 16){
			$(".pw_check").html("최대 패스워드는 16자 입니다").show();
			$(".pw_check_img").attr("src","image/join_chk2.png");
			chk2 = false;
			return false;
		}
			$(".pw_check").hide();
			$(".pw_check_img").attr("src","image/join_chk3.png");
			chk2 = true;
	});
	
	$("#pwc").keyup(function(){
		var pw = $('#pw').val();
		var pwc = $('#pwc').val();
		
		if(!pwc){
			$(".pwc_check").html("패스워드를 한번 더 입력해주세요").show();
			$(".pwc_check_img").attr("src","image/join_chk2.png");
			chk3 = false;
			return false;
		}else if(pw != pwc){
			$(".pwc_check").html("패스워드가 서로 일치하지 않습니다").show();
			$(".pwc_check_img").attr("src","image/join_chk2.png");
			chk3 = false;
			return false;
		}else if(pwc.length <= 5){
			$(".pwc_check_img").attr("src","image/join_chk2.png");
			chk3 = false;
			return false;
		}else if(pwc.length > 16){
			$(".pwc_check_img").attr("src","image/join_chk2.png");
			chk3 = false;
			return false;
		}
			$(".pwc_check_img").attr("src","image/join_chk3.png");
			$(".pwc_check").hide();
			chk3 = true;
	});
	
	$("#name").keyup(function(){
		var name = $('#name').val();

		if(!name){
			$(".name_check").html("이름을 입력해주세요").show();
			$(".name_check_img").attr("src","image/join_chk2.png");
			chk4 = false;
			return false;
		}else if(name.match(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/) == null){
			$(".name_check").html("이름은 한글만 입력 가능합니다").show();
			$(".name_check_img").attr("src","image/join_chk2.png");
			chk4 = false;
			return false;
		}else if(name.length <= 1 || name.length >=5){
			$(".name_check").html("이름은 2~4자 까지 입력가능합니다").show();
			$(".name_check_img").attr("src","image/join_chk2.png");
			chk4 = false;
			return false;
		}
			$(".name_check_img").attr("src","image/join_chk3.png");
			$(".name_check").hide();
			chk4 = true;
	});
	
	$("#email").keyup(function(){
		var email = $('#email').val();

		if(!email){
			$(".email_check").html("이메일을 입력해주세요").show();
			$(".email_check_img").attr("src","image/join_chk2.png");
			chk5 = false;
			return false;
		}
			$(".email_check_img").attr("src","image/join_chk3.png");
			$(".email_check").hide();
			chk5 = true;
	});
	
	$("#findq").keyup(function(){
		var findq = $('#findq').val();

		if(!findq){
			$(".findq_check").html("패스워드 분실시 질문을 입력해주세요").show();
			$(".findq_check_img").attr("src","image/join_chk2.png");
			chk6 = false;
			return false;
		}
			$(".findq_check_img").attr("src","image/join_chk3.png");
			$(".findq_check").hide();
			chk6 = true;
	});
	
	$("#finda").keyup(function(){
		var finda = $('#finda').val();

		if(!finda){
			$(".finda_check").html("패스워드 분실시 답을 입력해주세요").show();
			$(".finda_check_img").attr("src","image/join_chk2.png");
			chk7 = false;
			return false;
		}
			$(".finda_check_img").attr("src","image/join_chk3.png");
			$(".finda_check").hide();
			chk7 = true;
	});
	
	
	
	$("#join_btn").click(function(){
		var joinform = document.join_form;
		if(chk1 == false || chk2 == false || chk3 == false || chk4 == false || chk5 == false || chk6 == false || chk7 == false){
			alert("입력 정보를 정확히 입력해주세요");
			return false;
		}
		document.join_form.submit();
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
		<div id="logo">
			<a href="index.do"><img src="image/logo.png" class="logo"></a>
		</div>
		<div id="section">
			<form action="join_ok.do" method="post" name="join_form">
				<div id="join_form1">
					<input type="text" name="id" id="id" maxlength="14" placeholder="아이디">
					<img src="image/join_chk1.png" class="id_check_img">
					<p class="id_check">아이디를 입력해주세요</p>
					<hr>
					
					<input type="password" name="pw" id="pw" maxlength="20" placeholder="패스워드">
					<img src="image/join_chk1.png" class="pw_check_img">
					<p class="pw_check">패스워드를 입력해주세요</p>
					<hr>
					
					<input type="password" name="pwc" id="pwc" maxlength="20" placeholder="패스워드 확인">
					<img src="image/join_chk1.png" class="pwc_check_img">
					<p class="pwc_check">패스워드를 한번 더 입력해주세요</p>
				</div>
				<div id="join_form2">		
					<input type="text" name="name" id="name" maxlength="4" placeholder="이름">
					<img src="image/join_chk1.png" class="name_check_img">
					<p class="name_check">이름을 입력해주세요</p>
					<hr>
					<input type="email" name="email" id="email" maxlength="50" placeholder="이메일">
					<img src="image/join_chk1.png" class="email_check_img">
					<p class="email_check">이메일을 입력해주세요</p>
					<hr>
					<input type="text" name="findq" id="findq" maxlength="30" placeholder="패스워드 분실시 질문">
					<img src="image/join_chk1.png" class="findq_check_img">
					<p class="findq_check">패스워드 분실시 질문을 입력해주세요</p>
					<hr>
					<input type="text" name="finda" id="finda" maxlength="30" placeholder="패스워드 분실시 답">
					<img src="image/join_chk1.png" class="finda_check_img">
					<p class="finda_check">패스워드 분실시 답을 입력해주세요</p>
				</div>
				<p><input type="button" value="가입" id="join_btn"></p>
			</form>
		</div>
		<div id="footer">
		<p>By. SungKuk</p>
		</div>
	</div>

</body>
</html>