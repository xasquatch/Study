<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>IT Will ToTo</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1">
<link href="css/boardM.css" media="screen and (min-width: 1px) " rel="stylesheet">
<link href="css/boardD.css" media="screen and (min-width: 700px)" rel="stylesheet">
<link rel="shortcut icon" href="favicon/favicon.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		var check = "${user_member}";
		$(".write_btn").click(function(){
			location.href = "board.do";
		});
		$(".search_btn").click(function(){
			var keyword = $("#keyword").val();
			if(!keyword){
				alert("검색어를 입력해주세요");
				$("#keyword").focus();
				return false;
			}
			document.search_form.submit();
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
			<div id="board_form">
			<form action="search.do" method="post" name="search_form">
				<label class="total_count">검색 된 글 수 : ${count}</label>
				<input type="button" value="돌아가기" class="write_btn">
				<table>
					<tr>
						<td><label>No</label></td>
						<td><label>제목</label></td>
						<td><label>ID</label></td>
						<td><label>작성일</label></td>
					</tr>
					<tr class="line"><td colspan="4"></td></tr>
					
					<c:choose>
					<c:when test="${count eq 0}">
						<tr>
        					<td colspan="4"><label>검색 결과가 없습니다</label></td>
        				</tr>
						<tr class="line"><td colspan="4"></td></tr>
					</c:when>	
					<c:otherwise>
					<c:forEach var="list" items="${search_list}">
    					 <tr>
        					<td><label>${list.num}</label></td>
        					<td onclick="location.href='view.do?num=${list.num}'"><label>${list.title}</label></td>
        					<td><label>${list.id}</label></td>
        					<td><label>${list.date}</label></td>
        				</tr>
					<tr class="line"><td colspan="4"></td></tr>
  					</c:forEach>
  					</c:otherwise>
  					</c:choose>
  							
				</table>
				<select name="select">
					<option value="title">제목</option>
					<option value="id">작성자</option>
				</select>
				<input type="text" name="keyword" id="keyword">
				<input type="button" value="" class="search_btn">
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