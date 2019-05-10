<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>IT Will ToTo</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1">
<link href="css/viewM.css" media="screen and (min-width: 1px) " rel="stylesheet">
<link href="css/viewD.css" media="screen and (min-width: 700px)" rel="stylesheet">
<link rel="shortcut icon" href="favicon/favicon.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		var check = "${user_member}";
		$(".list_btn").click(function(){
			location.href='board.do';
	});
		$("#update").click(function(){
				location.href='update.do?num=${view.num}';
		});
		$("#delete").click(function(){
			var check = confirm("삭제하시겠습니까?");
			if(check == true){
				location.href='delete.do?num=${view.num}';
			}else{
				return false;
			}
		});
		$("#reply").click(function(){
			if(check == ''){
				alert("회원만 작성 가능합니다");
			}else{
			$("#reply_form").toggle();
			}
	});
		$("#reply_ok").click(function(){
			var reply_write = $("#reply_write").val();
			if(!reply_write){
				alert("댓글을 입력해주세요");
				$("#reply_write").focus();
				return false;
			}else if(reply_write.length > 99){
				alert("댓글은 99자 이하로 입력해주세요");
				$("#reply_write").focus();
				return false;
			}
			document.reply_form.submit();
	});
		
	$("#reply_delete").click(function(){
		var check = confirm("삭제하시겠습니까?");
		if(check == true){
			location.href='replyDelete.do?num=${view.num}&replyNum='+replyNum;
		}else{
			return false;
		}
	});	
	
		
	});
	
	function reply_delete(replyNum){
		var check = confirm("삭제하시겠습니까?");
		if(check == true){
			location.href='replyDelete.do?num=${view.num}&replyNum='+replyNum;
		}else{
			return false;
		}
	}
	function reply_update(replyNum, index){
		$.ajax({ 
			type: 'post', 
			data: {id: '${user_member.id}', num : '${view.num}', replyNum : replyNum, check : 1},
			dataType : 'text',
			url: 'reply_update_check.jsp', 
			success: function(data) { 
				if($.trim(data) != "NO"){
					$("#write"+index).hide();
					$(".reply_update"+index).hide();
					$(".reply_delete"+index).hide();
					$(".reply_ok"+index).show();
					$(".reply_cancel"+index).show();
					$("#reply"+index).html(data).show().css({"border":"1px solid #e9e9e9", "margin":"5px 0px", "padding":"0px 5px"});
				}else{
					alert("이미 삭제된 댓글이거나 본인 댓글이 아닙니다.");
				}
			} 
		});
	}
	function reply_cancel(replyNum, index){
		document.getElementById("reply_update"+index).style.display = "inline";
		document.getElementById("reply_delete"+index).style.display = "inline";
		document.getElementById("reply_ok"+index).style.display = "none";
		document.getElementById("reply_cancel"+index).style.display = "none";
		document.getElementById("reply"+index).style.display = "none";
		$.ajax({ 
			type: 'post', 
			data: {id: '${user_member.id}', num : '${view.num}', replyNum : replyNum, check : 2},
			dataType : 'text',
			url: 'reply_update_check.jsp', 
			success: function(data) { 
				if($.trim(data) != "NO"){
					$("#reply"+index).html(data).show().css({"border":"", "margin":"", "padding":""});
				}else{
					alert("이미 삭제되었거나 본인 글이 아닙니다");
				}
			} 
		});
	}
	
	function reply_okk(num, replyNum){
		var update_reply_write = document.getElementById("update_reply_write").value;
		if(!update_reply_write || update_reply_write.replace(/(^\s*)|(\s*$)/, ' ') == ' '){
			alert("댓글을 입력해주세요");
			document.getElementById("update_reply_write").focus();
			return false;
		}else{
			location.href = "replyUpdate.do?num="+num+"&replyNum="+replyNum+"&update_reply_write="+update_reply_write;
	}
	}
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
			<div id="view_form">
			<p><input type="button" value="글 목록" class="list_btn"></p>
			<form action="reply.do?num=${view.num}" method="post" name="reply_form">
				<table>
					<tr>
						<td><label>글 번호</label></td>
						<td><label>${view.num}</label></td>
					</tr>
					<tr>
						<td><label>제목</label></td>
						<td><label>${view.title}</label></td>
					</tr>
					<tr>
						<td><label>작성자</label></td>
						<td><label>${view.id}</label></td>
					</tr>
					<tr>
						<td><label>작성일</label></td>
						<td><label>${view.date}</label></td>
					</tr>
					<tr>
						<td><label>조회수</label></td>
						<td><label>${view.view}</label></td>
					</tr>
					<tr>
						<td colspan="2"><label>내용</label></td>
					</tr>
					<tr>
						<td colspan="2"><textarea cols="70" rows="30" readonly="readonly">${view.content}</textarea></td>
					</tr>
					<tr>
						<td colspan="2">
						<c:choose>
							<c:when test="${user_member.id eq view.id}">
								<input type="button" value="글 수정" class="view_btn" id="update">
								<input type="button" value="글 삭제" class="view_btn" id="delete">
								<input type="button" value="댓글 달기" class="view_btn" id="reply">
							</c:when>		
						<c:otherwise>
							<input type="button" value="댓글 달기" class="view_btn" id="reply">
						</c:otherwise>
						</c:choose>
						</td>
					</tr>
				</table>
					<div id="reply_form">
						<p><input type="text" name="reply_write" id="reply_write" maxlength="99"></p>
						<input type="button" value="작성" class="view_btn" id="reply_ok">
					</div>
					<div id="reply_list">
					
						<table>
						<tr>
							<td>댓글</td>
						</tr>
						
						<c:choose>
							<c:when test="${reply_size eq 0}">
							<tr>
								<td>
									등록된 댓글이 없습니다.
								</td>
							</tr>
							</c:when>
							<c:otherwise>	
								<c:forEach var="r" items="${reply_view}" varStatus="status">
									<tr>
										<td>
										<p><label>ID : ${r.id} [${r.date}]</label>
										</p>
										<p id="reply${status.count}">
										<label id="${status.count}">${r.replyWrite}</label>
										</p>
										<c:if test="${user_member.id eq r.id}">
										<input type="button" value="수정" class="view_btn reply_update${status.count}" id="reply_update${status.count}"onclick="reply_update(${r.replyNum},${status.count})">
										<input type="button" value="삭제" class="view_btn reply_delete${status.count}" id="reply_delete${status.count}" onclick="reply_delete(${r.replyNum})">
										<input type="button" value="확인" class="view_btn reply_ok${status.count}" id="reply_ok${status.count}" onclick="reply_okk(${view.num},${r.replyNum})">
										<input type="button" value="취소" class="view_btn reply_cancel${status.count}" id="reply_cancel${status.count}" onclick="reply_cancel(${r.replyNum},${status.count})">
										</c:if>
									</td>
								</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
						</table>
						
					</div>
			</form>
		</div>
		</div>
		<div id="footer">
		<c:choose>
		<c:when test="${user_member ne null}">
			<p><input type="button" value="로그아웃" onclick="location.href='logout.do'">
			<input type="button" value="개인정보수정" onclick="location.href='member_modify.do'"></p> 
		</c:when>		
		<c:otherwise>
			<p><input type="button" value="로그인" onclick="location.href='login.do'">
		</c:otherwise>
		</c:choose>
		<p>By. SungKuk</p>
		</div>
	</div>
</body>
</html>