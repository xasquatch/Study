<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>		 
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>IT Will ToTo</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1">
<link href="css/writeM.css" media="screen and (min-width: 1px) " rel="stylesheet">
<link href="css/writeD.css" media="screen and (min-width: 700px)" rel="stylesheet">
<link rel="shortcut icon" href="favicon/favicon.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		var check = "${user_member}";
		if(check == ''){
			alert("회원만 작성 가능합니다");
			location.href="board.do";
		}
		$(".list_btn").click(function(){
			location.href = "board.do";
		});
		$(".write_btn").click(function(){
			var title = $("#title").val();
			var content = $("#content").val();
			if(!title){
				alert("제목을 입력해주세요");
				$("#title").focus();
				return false;
			}else if(!content){
				alert("내용을 입력해주세요");
				$("#content").focus();
				return false;
			}else if(title.length > 50){
				alert("제목은 50자 이내로 입력해주세요");
				$("#title").focus();
				return false;
			}
			document.write_form.submit();
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
			<div id="write_form">
			<img src="image/write.png">
			<p><input type="button" value="글 목록" class="list_btn"></p>
			<form action="write_ok.do" method="post" name="write_form">
				<table>
					<tr>
						<td><label>제목</label></td>
					</tr>
						<tr>
						<td><label><input type="text" name="title" id="title" maxlength="50"></label></td>
					</tr>
					<tr>
						<td><label>내용</label></td>
					</tr>
					<tr>
						<td><textarea cols="70" rows="30" name="content" id="content"></textarea></td>
					</tr>
					<tr>
						<td>
						<input type="button" value="글 작성" class="write_btn">
						</td>
					</tr>
				</table>
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