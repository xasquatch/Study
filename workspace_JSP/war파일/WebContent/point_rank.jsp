<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>IT Will ToTo</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1">
<link href="css/pointRankM.css" media="screen and (min-width: 1px) " rel="stylesheet">
<link href="css/pointRankD.css" media="screen and (min-width: 700px)" rel="stylesheet">
<link rel="shortcut icon" href="favicon/favicon.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		var check = "${user_member}";
		if(check == ''){
			alert("회원만 입장 가능합니다");
			location.href="index.do";
		}
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
		<div id="pointRank_form">
		<img src="image/point_rank1.png">
		<p class="mypoint">나의 보유포인트 : ${user_member.point} Point</p>
		<div id="pointTop5">
		<table>
        	<tr>
        		<td colspan="3">포인트 Top5</td>
        	</tr>
        	<tr>
        		<td>순위</td>
        		<td>아이디</td>
        		<td>보유포인트</td>
        	</tr>
        	<c:forEach var="user" items="${Top5}" varStatus="status">
    		 <tr>
        		<td>${status.index+1}</td>
        		<td>${user.id}</td>
        		<td>${user.point}</td>
        	</tr>
  			</c:forEach>
        </table>
        </div>
        
       <div id="pointBottom5">
		<table>
        	<tr>
        		<td colspan="3">포인트 Bottom5</td>
        	</tr>
        	<tr>
        		<td>순위</td>
        		<td>아이디</td>
        		<td>보유포인트</td>
        	</tr>
        	<c:forEach var="user" items="${Bottom5}" varStatus="status">
    		 <tr>
        		<td>${status.index+1}</td>
        		<td>${user.id}</td>
        		<td>${user.point }</td>
        	</tr>
  			</c:forEach>
        </table>
        </div>
        
        
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