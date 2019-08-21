<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/subpage.css" rel="stylesheet" type="text/css">
<!--[if lt IE 9]>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js" type="text/javascript"></script>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/ie7-squish.js" type="text/javascript"></script>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js" type="text/javascript"></script>
<![endif]-->
<!--[if IE 6]>
 <script src="../script/DD_belatedPNG_0.0.8a.js"></script>
 <script>
   /* EXAMPLE */
   DD_belatedPNG.fix('#wrap');
   DD_belatedPNG.fix('#main_img');   

 </script>
 <![endif]-->

<script type="text/javascript">
	winopen = function() {
		var fid = document.fr.id.value;
		if(fid == ""){
			//회원가입 양식의 id입력란에 아이디를 입력하지 않았다면 "아이디를 입력하세요"라고 메세지창 띄움
			//id입력란에 포커스 주기
			//winopen()함수 나가기
			window.alert("아이디를 입력하세요");
			document.fr.id.focus();
			return;
		}else{
			//회원가입 양식의 id 입력란에 아이디르 입력했다면
			//아이디 중복 체크를 위한 작은창으 ㄹ띄울 때 id입력란에 입력한 id전달
			window.open("join_IDcheck.jsp?userid="+ fid, "","width=400,height=200");
		}
	};
</script>
</head>
<body>
<div id="wrap">
<!-- 헤더들어가는 곳 -->
<%@include file="../inc/top.jsp" %>
<!-- 헤더들어가는 곳 -->

<!-- 본문들어가는 곳 -->
<!-- 본문메인이미지 -->
<div id="sub_img_member"></div>
<!-- 본문메인이미지 -->
<!-- 왼쪽메뉴 -->
<nav id="sub_menu">
<ul>
<li><a href="#">Join us</a></li>
<li><a href="#">Privacy policy</a></li>
</ul>
</nav>
<!-- 왼쪽메뉴 -->
<!-- 본문내용 -->
<article>
<h1>Join Us</h1>
<form action="joinPro.jsp" id="join" method="POST" name="fr">
	<fieldset>
		<legend>Basic Info</legend>
		<label>User ID</label>
		<input type="text" name="id" class="id">
		<input type="button" value="dup. check" class="dup" onclick="winopen()"><br> <!-- 아이디 중복검사 함수 실행 -->
		<label>Password</label>
		<input type="password" name="passwd"><br>
		<label>Retype Password</label>
		<input type="password" name="passwd2"><br>
		<label>Name</label>
		<input type="text" name="name"><br>
		<label>E-Mail</label>
		<input type="email" name="email"><br>
		<label>Retype E-Mail</label>
		<input type="email" name="email2"><br>
	</fieldset>

	<fieldset>
		<legend>Optional</legend>
		<label>Address</label>
		<input type="text" name="address"><br>
		<label>Phone Number</label>
		<input type="text" name="tel"><br>
		<label>Mobile Phone Number</label>
		<input type="text" name="mtel"><br>
	</fieldset>
	
<div class="clear"></div>
<div id="buttons">
<input type="submit" value="Submit" class="submit">
<input type="button" value="Cancel" class="cancel">
</div>
</form>
</article>
<!-- 본문내용 -->
<!-- 본문들어가는 곳 -->

<div class="clear"></div>
<!-- 푸터들어가는 곳 -->
<%@include file="../inc/bottom.jsp" %>
<!-- 푸터들어가는 곳 -->
</div>
</body>
</html>