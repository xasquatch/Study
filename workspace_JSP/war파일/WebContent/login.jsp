<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>IT Will ToTo</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1">
<link href="css/loginM.css" media="screen and (min-width: 1px) " rel="stylesheet">
<link href="css/loginD.css" media="screen and (min-width: 700px)" rel="stylesheet">
<link rel="shortcut icon" href="favicon/favicon.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
	
	var check = '${user_member}';
	if(check == "NO"){
		$(".id_check").html("등록된 정보가 없습니다").show();
	}
	$("#login_button").click(function(){
		var id = $("#id").val();
		var pw = $("#pw").val();
		
		if(!id){
			$(".id_check").html("아이디를 입력해주세요").show();
			$("#id").focus();
			return false;
		}else if(!pw){
			$(".id_check").html("비밀번호를 입력해주세요").show();
			$("#pw").focus();
			return false;
		}
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
		<div id="login_form">
			<form action="login_ok.do" method="post" name="login_form">
				
				<input type="text" name="id" id ="id" maxlength="16" placeholder="아이디">
				<input type="password" name="pw" id="pw" maxlength="16" placeholder="비밀번호">
				<p class="id_check">아이디를 입력해주세요</p>		
				<p><input type="submit" value="로그인" id="login_button"></p>
				<hr>
				<p class="find_font"><a href="find.do">아이디/ 비밀번호 찾기</a>
				<a href="join.do">회원가입</a><p>
				<hr>
			</form>
			<img src="image/login1.png">
		</div>

		</div>
		<div id="footer">
		<p>By. SungKuk</p>
		</div>
	</div>
</body>
</html>