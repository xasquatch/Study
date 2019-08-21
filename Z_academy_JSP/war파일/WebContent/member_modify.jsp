<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>IT Will ToTo</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1">
<link href="css/member_modifyM.css" media="screen and (min-width: 1px) " rel="stylesheet">
<link href="css/member_modifyD.css" media="screen and (min-width: 700px)" rel="stylesheet">
<link rel="shortcut icon" href="favicon/favicon.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
	var check = "${user_member}";
	var my_id = "${user_member.pw}";
	chk1 = false;
	chk2 = true;
	chk3 = true;
	chk4 = true;
	chk5 = true;
	chk6 = true;
	chk7 = true;
	
	if(check == ''){
		alert("회원만 입장 가능합니다");
		location.href="index.do";
	}

	$("#modify").click(function(){
		if(chk1 == false || chk2 == false || chk3 == false || chk4 == false || chk5 == false || chk6 == false || chk7 == false){
			alert("입력 정보를 정확히 입력해주세요");
			return false;
		}
		document.member_modify_form.submit();
	});
	
	
	
	
	
	
	
	
	
	$("#nowpw").keyup(function(){
		var nowpw = $('#nowpw').val();
		if(!nowpw){
			$(".nowpw_check").html("현재 패스워드를 입력해주세요").show();
			$(".nowpw_check_img").attr("src","image/join_chk2.png");
			chk1 = false;
			return false;
		}else if(nowpw !=  my_id){
			$(".nowpw_check").html("현재 패스워드가 일치하지않습니다").show();
			$(".nowpw_check_img").attr("src","image/join_chk2.png");
			chk1 = false;
			return false;
		}
			$(".nowpw_check").hide();
			$(".nowpw_check_img").attr("src","image/join_chk3.png");
			chk1 = true;
	});
	
	
	$("#newpw").keyup(function(){
		var newpw = $('#newpw').val();
		var newpwc = $('#newpwc').val();
		$(".newpwc_check_img").attr("src","image/join_chk2.png");
		if(!newpw){
			$(".newpw_check").hide();
			$(".newpw_check_img").attr("src","image/join_chk3.png");
			$(".newpwc_check_img").attr("src","image/join_chk3.png");
			chk2 = true;
			return false;
		}else if(newpw.length <= 5 && newpw.length != 0){
			$(".newpw_check").html("최소 패스워드는 6자 이상이어야 합니다").show();
			$(".newpw_check_img").attr("src","image/join_chk2.png");
			chk2 = false;
			return false;
		}else if(newpw.length >= 17){
			$(".newpw_check").html("최대 패스워드는 16자 입니다").show();
			$(".newpw_check_img").attr("src","image/join_chk2.png");
			chk2 = false;
			return false;
		}
			
			$(".newpw_check").hide();
			$(".newpw_check_img").attr("src","image/join_chk3.png");
			chk2 = true;
	});
	
	$("#newpwc").keyup(function(){
		var newpw = $('#newpw').val();
		var newpwc = $('#newpwc').val();
		if(newpw != newpwc){
			$(".newpwc_check").html("패스워드가 서로 같지않습니다").show();
			$(".newpwc_check_img").attr("src","image/join_chk2.png");
			chk3 = false;
			return false;
		}
			$(".newpwc_check").hide();
			$(".newpwc_check_img").attr("src","image/join_chk3.png");
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
		}else if(name.length <= 1){
			$(".name_check").html("최소 이름은 2자 이상이어야 합니다").show();
			$(".name_check_img").attr("src","image/join_chk2.png");
			chk4 = false;
			return false;
		}else if(name.length >= 5){
			$(".name_check").html("최대 이름은 4자까지 입력 가능합니다").show();
			$(".name_check_img").attr("src","image/join_chk2.png");
			chk4 = false;
			return false;
			
		}
			$(".name_check").hide();
			$(".name_check_img").attr("src","image/join_chk3.png");
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
			$(".email_check").hide();
			$(".email_check_img").attr("src","image/join_chk3.png");
			chk5 = true;
	});
	
	
	$("#find_q").keyup(function(){
		var find_q = $('#find_q').val();
		if(!find_q){
			$(".find_q_check").html("패스워드 분실 시 질문을 입력해주세요").show();
			$(".find_q_check_img").attr("src","image/join_chk2.png");
			chk6 = false;
			return false;
		}
			$(".find_q_check").hide();
			$(".find_q_check_img").attr("src","image/join_chk3.png");
			chk6 = true;
	});
	
	$("#find_a").keyup(function(){
		var find_a = $('#find_a').val();
		if(!find_a){
			$(".find_a_check").html("패스워드 분실 시 답을 입력해주세요").show();
			$(".find_a_check_img").attr("src","image/join_chk2.png");
			chk7 = false;
			return false;
		}
			$(".find_a_check").hide();
			$(".find_a_check_img").attr("src","image/join_chk3.png");
			chk7 = true;
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

			<form action="member_modify_ok.do" method="post" name="member_modify_form">
				
				<div id="modify_form1">
					<input type="hidden" name="id" id="id" value="${user_member.id}" readonly="readonly">
					<p class="myid">${user_member.id}님의 현재 정보입니다</p>
					<hr>
					<input type="password" name="nowpw" id="nowpw" maxlength="20" placeholder="현재 패스워드">
					<img src="image/join_chk1.png" class="nowpw_check_img">
					<p class="nowpw_check">현재 패스워드를 입력해주세요</p>
					<hr>
					
					<input type="password" name="newpw" id="newpw" maxlength="20" placeholder="패스워드 변경 (필수사항 아님)">
					<img src="image/join_chk3.png" class="newpw_check_img">
					<p class="newpw_check">변경 할 입력해주세요</p>
					<hr>
					
					<input type="password" name="newpwc" id="newpwc" maxlength="20" placeholder="패스워드 변경 확인">
					<img src="image/join_chk3.png" class="newpwc_check_img">
					<p class="newpwc_check">패스워드를 한번 더 입력해주세요</p>
					<hr>
				</div>
				
				<div id="modify_form2">	
				<table>
				<tr>
					<td><span class="form_font">이름 : </span></td>
					<td><input type="text" name="name" id="name" value="${user_member.name}" maxlength="4" placeholder="이름"></td>
					<td><img src="image/join_chk3.png" class="name_check_img">
				</tr>
				<tr>
					<td colspan="3"><p class="name_check">이름을 입력해주세요</p></td>
				</tr>
				
				<tr>
					<td><span class="form_font">이메일 : </span></td>
					<td><input type="email" name="email" id="email" maxlength="50" value="${user_member.e_mail}" placeholder="이메일"></td>
					<td><img src="image/join_chk3.png" class="email_check_img"></td>
				</tr>	
				<tr>
					<td colspan="3"><p class="email_check">이메일을 입력해주세요</p></td>
				</tr>
				
				<tr>
					<td><span class="form_font">분실 질문 : </span></td>
					<td><input type="text" name="find_q" id="find_q" maxlength="30" value="${user_member.pass_q}" placeholder="패스워드 분실 질문"></td>
					<td><img src="image/join_chk3.png" class="find_q_check_img"></td>
				</tr>
				<tr>
					<td colspan="3"><p class="find_q_check">패스워드 분실 시 질문을 입력해주세요</p></td>
				</tr>
				
				<tr>
					<td><span class="form_font">분실 답 : </span></td>
					<td><input type="text" name="find_a" id="find_a" maxlength="30" value="${user_member.pass_a}" placeholder="패스워드 분실 답"></td>
					<td><img src="image/join_chk3.png" class="find_a_check_img"></td>
				</tr>	
				<tr>
					<td colspan="3"><p class="find_a_check">패스워드 분실 시 답을 입력해주세요</p></td>
				</tr>
				</table>
				</div>
				<input type="button" value="수정" id="modify">
			</form>


		</div>
		<div id="footer">
		<c:if test="${user_member ne null}">
			<p><input type="button" value="로그아웃" onclick="location.href='logout.do'">
			<p>By. SungKuk</p>
		</c:if>
		
		</div>
	</div>
</body>
</html>