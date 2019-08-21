<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.IOException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>IT Will ToTo</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1">
<meta property="og:type" content="website"/>
<meta property="og:title" content="IT Will 학생들의 통합커뮤니티!"/>
<meta property="og:url" content="http://willtoto.cafe24.com/">
<meta property="og:description" content="Web Developer : 성국"/>
<meta property="og:image" content="image/katalkimg.png"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<link rel="shortcut icon" href="favicon/favicon.ico">
<link href="css/Mobile.css" media="screen and (min-width: 1px) " rel="stylesheet">
<link href="css/Desktop.css" media="screen and (min-width: 700px)" rel="stylesheet">


<script>
var join_result = '${join_result}';
if(join_result == "true"){
	alert("회원가입이 완료되었습니다");
}

$(function() {
	
    var count = $('#rank-list li').length;
    var height = $('#rank-list li').height();

    function step(index) {
        $('#rank-list ol').delay(3000).animate({
            top: -height * index,
        }, 500, function() {
            step((index + 1) % count);
        });
    }

    step(1);
    
    var count2 = $('#rank-list2 li').length;
    var height2 = $('#rank-list2 li').height();

    function step2(index2) {
        $('#rank-list2 ol').delay(3000).animate({
            top: -height2 * index2,
        }, 500, function() {
            step2((index2 + 1) % count2);
        });
    }

    step2(1);
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
		<form action="search.do" method="post" name="search_form">
		<div id="find">
			<a href="index.do"><img src="image/logo.png" class="logo"></a>
				<input type="hidden" name="select" value="title">
				<input type="text"  name="keyword" id="keyword" placeholder="검색어를 입력하세요"><input type="submit" id="search_btn" value="">
		</div>
		</form>
		<div id="section">
			<div id="new">
			<span class="new">실시간 최신글</span><img src="image/newicon.png" class="newicon">
				<table>
					<tr>
						<td>작성자</td>
						<td>제목</td>
					</tr>
					<c:forEach var="list" items="${Write5_list}" begin="0" end="2">
        				<tr>
        					<td><label>${list.id}</label></td>
        					<td onclick="location.href='view.do?num=${list.num}'"><label>${list.title}</label></td>
  						</tr>
  					</c:forEach>
				</table>
			
			</div>
			<div id="login">
			<c:choose>
			<c:when test="${user_member ne null}">
				<img src="image/logo.png" class="login_logo">
				<p class="login_ok">${user_member.name}님 환영합니다</p>　
				<p class="red">보유포인트 : ${user_member.point} Point</p> 
				<p><input type="button" value="로그아웃" id="logout" onclick="location.href='logout.do'"></p>
			</c:when>
			<c:otherwise>
			<img src="image/logo.png" class="login_logo">
			<p><input type="button" value="로그인" onclick="location.href='login.do'"><p>
			<p><a href="find.do">아이디/ 비밀번호 찾기</a>
			<a href="join.do">회원가입</a><p>
			 </c:otherwise>
			</c:choose>
			</div>
			<div id="point_top3">
			<dl id="rank-list">
                <dd>
                    <ol>
                    	<li>실시간 포인트랭킹 Top5</li>
                      	<c:forEach var="user" items="${Top5}" varStatus="status">
        					<li>${status.index+1}위 : ${user.id} [${user.point} Point]</li>
  						</c:forEach>
                    </ol>
                </dd>
            </dl>
			</div>
			<div id="point_down3">
			<dl id="rank-list2">
                <dd>
                    <ol>
                    	<li>실시간 포인트랭킹 Bottom5</li>
                        <c:forEach var="user" items="${Bottom5}" varStatus="status">
        					<li>${status.index+1}위 : ${user.id} [${user.point} Point]</li>
  						</c:forEach>
                    </ol>
                </dd>
            </dl>
			</div>
			<div id="content1">
			<span class="new">실시간 포인트송금 현황</span><img src="image/newicon.png" class="newicon">
			<table>
					<tr>
						<td>보낸이</td>
						<td>받는이</td>
						<td>송금 포인트</td>
					</tr>
					<tr>
						<td>${trade_list[0].myid}</td>
						<td>${trade_list[0].send_id}</td>
						<td>${trade_list[0].send_point}</td>
					</tr>
					<tr>
						<td>${trade_list[1].myid}</td>
						<td>${trade_list[1].send_id}</td>
						<td>${trade_list[1].send_point}</td>
					</tr>
					<tr>
						<td>${trade_list[2].myid}</td>
						<td>${trade_list[2].send_id}</td>
						<td>${trade_list[2].send_point}</td>
					</tr>
				</table>
			</div>
			<div id="content2">
				<span class="new">실시간 IT/과학 News</span><img src="image/newicon.png" class="newicon">
			<table>
					<tr>
						<td>기사 제목(링크 연결)</td>
					</tr>
					<tr>
						<td><a href="${link[0]}">${title[0]}</a></td>
					</tr>
					<tr>
						<td><a href="${link[1]}">${title[1]}</a></td>

					</tr>
					<tr>
						<td><a href="${link[2]}">${title[2]}</a></td>
					</tr>
				</table>
			</div>
			<div id="content3">
			<span class="new">꿀 링크 모아모아</span>
			<table>
					<tr>
						<td>설명</td>
						<td>사이트명 (링크 연결)</td>
					</tr>
					<tr>
						<td>아이티윌 부산 교육센터</td>
						<td><a href="http://www.itwillbs.co.kr/">아이티윌 부산 교육센터</a></td>
					</tr>
					<tr>
						<td>자바의 정석 저자 카페</td>
						<td><a href="http://cafe.naver.com/javachobostudy/">남궁성 코드 초보스터디</a></td>
					</tr>
					<tr>
						<td>자바 강의</td>
						<td><a href="http://tryhelloworld.co.kr/">tryHelloworld</a></td>
					</tr>
					<tr>
						<td>코딩 강의</td>
						<td><a href="https://opentutorials.org/">생활코딩</a></td>
					</tr>
					<tr>
						<td>무료 인터넷 강의</td>
						<td><a href="https://www.inflearn.com/">인프런</a></td>
					</tr>
					<tr>
						<td>DB 개발자 커뮤니티</td>
						<td><a href="http://www.gurubee.net/">구루비</a></td>
					</tr>
					<tr>
						<td>자바 개발자 커뮤니티</td>
						<td><a href="https://okky.kr/">오키</a></td>
					</tr>
				</table>
			</div>
			<div id="content4"><img src="image/footerlogo.png"></div>
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