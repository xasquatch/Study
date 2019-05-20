<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 변경</title>
<link rel="stylesheet" href="../css/main.css"/>
<script type="text/javascript" src="../js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(function() {
		$(".show_passBtn").on("mousedown", function() {
			$(this).parent().siblings().children("input").attr("type", "text");
		});
		$(".show_passBtn").on("mouseup mouseout", function() {
			$(this).parent().siblings().children("input").attr("type", "password");
		});
	});
	var pass_Check = false;
	function checkPass() {
		if($("#pass").val() != "") {
			if($("#pass").val() != $("#pass2").val()) {
				$("#passCheck").css("color", "red");
				$("#passCheck").text("비밀번호가 다릅니다.");
				pass_Check = false;
			} else {
				$("#passCheck").css("color", "green");
				$("#passCheck").text("비밀번호가 동일합니다.");
				pass_Check = true;
			}
		} else {
			$("#passCheck").text("");
		}
	}
	
	function checkForm() {
		if(!pass_Check) {
			alert("비밀번호가 동일하지 않습니다.");
			$("#pass").focus();
			return false;
		}
	}
</script>
</head>
<body>
<%@include file="../inc/top_lg.jsp" %>
		<header>
			<div id="ui_top_banner">
				<div id="wrap">
					<a href="../index.jsp"><img src="../images/new_logo.png" alt="Hbay Logo" id="logo"/></a>
					<h1 id="ui_title">내정보</h1>
					
					<ul id="ui_top_menu">
						<li><a href="pass_check.jsp">내정보 관리</a></li>
						<li><a href="pass_change.jsp" class="ui_selected">비밀번호 변경</a></li>
						<li><span class="divider"></span></li>
						<li><a href="close_acc.jsp">회원탈퇴</a></li>
						<div class="clear"></div>
					</ul>
					<div class="clear"></div>
				</div>
			</div>
		</header>
		
		<div id="wrap" class="wrap_min">
			<article>
				<div id="pass_change">
					<h1>비밀번호 변경</h1>
					<p>쉬운 비밀번호나 자주 쓰는 사이트의 비밀번호가 같을 경우, 도용되기 쉬워 주기적으로 변경하여 사용하는 것이 좋습니다.</p>
					<p>비밀번호에 특수문자를 추가하여 사용하시면 기억하기도 쉽고, 비밀번호 안전도가 높아져 도용의 위험이 줄어듭니다.</p>
				</div>
				<form action="pass_changeProc.jsp" method="post" onsubmit="return checkForm();">
					<div id="user_info_form">
					<table>
						<tr>
							<td class="label_td"><label for="curr_pass">현재 비밀번호</label></td>
							<td><input type="password" name="curr_pass" id="curr_pass" placeholder="현재 비밀번호 입력" required/></td>
							<td><input type="button" class="show_passBtn" value="보기"/></td>
						</tr>
						<tr>
							<td class="label_td"><label for="pass">새 비밀번호</label></td>
							<td><input type="password" name="pass" id="pass" placeholder="새 비밀번호 입력" onkeyup="checkPass();" required/></td>
							<td><input type="button" class="show_passBtn" value="보기"/></td>
						</tr>
						<tr>
							<td class="label_td"><label for="pass2">새 비밀번호 확인</label></td>
							<td><input type="password" name="pass2" id="pass2" placeholder="새 비밀번호 확인" onkeyup="checkPass();" required/></td>
							<td><input type="button" class="show_passBtn" value="보기"/></td>
						</tr>
						<tr>
							<td></td>
							<td colspan="2"><span id="passCheck" class="check_status"></span></td>
						</tr>
					</table>
					</div>
					<div id="pass_recheck_btn">
						<input type="submit" value="확인" class="btn"/>
						<input type="reset" value="취소" class="btn"/>
					</div>
				</form>
			</article>
		</div>
		
		<%@include file="../inc/footer.jsp" %>
</body>
</html>