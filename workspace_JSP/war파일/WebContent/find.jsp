<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>IT Will ToTo</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1">
<link href="css/findM.css" media="screen and (min-width: 1px) " rel="stylesheet">
<link href="css/findD.css" media="screen and (min-width: 700px)" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<link rel="shortcut icon" href="favicon/favicon.ico">
<script>
var chk = false;
$(document).ready(function(){
	$("#name_id").keyup(function(){
		var name_id = $('#name_id').val();
		var email_id = $('#email_id').val();
		if(!name_id ){
			$(".id_check").html("이름을 입력해주세요");
			return false;
		}else if(!email_id){
			$(".id_check").html("이메일을 입력해주세요");
			return false;
		}
		
		$.ajax({ 
			type: 'post', 
			data: {"name_id" : name_id , "email_id" : email_id},
			dataType : 'text',
			url: 'id_find_check.jsp', 
			success: function(data) { 
				if($.trim(data) != ""){
					$(".id_check").html("귀하의 아이디는"+data+"입니다");
				}else{
					$(".id_check").html("일치하는 정보가 없습니다");	
				}
			} 
	});
		
});
$("#email_id").keyup(function(){
		var name_id = $('#name_id').val();
		var email_id = $('#email_id').val();
		if(!name_id ){
			$(".id_check").html("이름을 입력해주세요");
			return false;
		}else if(!email_id ){
			$(".id_check").html("이메일을 입력해주세요");
			return false;
		}
	
		$.ajax({ 
			type: 'post', 
			data: {"name_id" : name_id , "email_id" : email_id},
			dataType : 'text',
			url: 'id_find_check.jsp', 
			success: function(data) { 
				if($.trim(data) != ""){	
					$(".id_check").html("귀하의 아이디는 "+data+"입니다");
				}else{
					$(".id_check").html("일치하는 정보가 없습니다");	
				}
			} 
	});
		
});	
	
$("#find_pw_click").click(function(){
		var name_pw = $('#name_pw').val();
		var id_pw = $('#id_pw').val();
		var email_pw = $('#email_pw').val();
		
		if(!id_pw){
			alert("아이디를 입력하세요");
			$("#id_pw").focus();
			return false;
		}else if(!name_pw){
			alert("이름을 입력하세요");
			$("#name_pw").focus();
			return false;
		}else if(!email_pw){
			alert("이메일을 입력하세요");
			$("#email_pw").focus();
			return false;
		}
		
		$.ajax({ 
			type: 'post', 
			data: {"name_pw" : name_pw , "id_pw" : id_pw, "email_pw" : email_pw},
			dataType : 'html',
			url: 'pw_find_check.jsp', 
			success: function(data) { 
				if($.trim(data) != ""){	
					$(".pw_check").html("OK");
					$("#find_pw_q").attr("value",data).show();				
					$("#find_pw_a").show();		
					$(".pw_a_check").show();
				}else{
					$(".pw_check").html("일치하는 정보가 없습니다");
					$("#find_pw_q").hide();	
					$("#find_pw_a").hide();		
					$(".pw_a_check").hide();
				}
			} 
	});
});	



$("#find_pw_a").keyup(function(){
	var name_pw = $('#name_pw').val();
	var id_pw = $('#id_pw').val();
	var email_pw = $('#email_pw').val();
	var find_pw_q = $('#find_pw_q').val();
	var find_pw_a = $('#find_pw_a').val();
	
	if(!find_pw_q){
		alert("악용금지");
		return false;
	}else if(!find_pw_a){
		$(".pw_a_check").html("질문에 대한 답을 입력하세요");
		return false;
	}
	$.ajax({ 
		type: 'post', 
		data: {"name_pw" : name_pw , "id_pw" : id_pw, "email_pw" : email_pw, "find_pw_q" : find_pw_q, "find_pw_a" : find_pw_a},
		dataType : 'html',
		url: 'pw_find_qa_check.jsp', 
		success: function(data) { 
			if($.trim(data) != ""){	
				$(".pw_a_check").html("귀하의 비밀번호는 "+data+"입니다");
			}else{
				$(".pw_a_check").html("일치하는 정보가 없습니다");
			}
		} 
});
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
		<h2 class="find_id">아이디 찾기</h2>
		<div id="find_id_form">
				<input type="text" name="name" id="name_id" maxlength="5" placeholder="이름">
				<hr>
				<input type="text" name="email" id="email_id" maxlength="50" placeholder="이메일">
				<hr>
				<p class="id_check">이름을 입력해주세요</p>
		</div>
		<h2 class="find_pw">비밀번호 찾기</h2>
		<div id="find_pw_form">
				<input type="text" id="id_pw" maxlength="16" placeholder="아이디">
				<hr>
				<input type="text" id="name_pw" maxlength="5" placeholder="이름">
				<hr>
				<input type="text" id="email_pw"  maxlength="50" placeholder="이메일">
				<hr>
				<p class="pw_check">정보를 입력해주세요</p>
				<input type="button" value="비밀번호 찾기" id="find_pw_click">
				<div id="pwqa">
				<input type="text" name="find_pw_q" id="find_pw_q" readonly="readonly">
				<input type="text" name="find_pw_a" id="find_pw_a" placeholder="답">
				<hr>
				<p class="pw_a_check">질문에 대한 답을 입력하세요</p>
				</div>
		</div>
		</div>
		<div id="footer">
		<p>By. SungKuk</p>
		</div>
	</div>

</body>
</html>