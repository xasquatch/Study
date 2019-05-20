<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>▒ 메일 보내기  ▒</title>
<link type="text/css" rel="stylesheet" href="../css/common.css" />
<link type="text/css" rel="stylesheet" href="../css/board.css" />
<link type="text/css" rel="stylesheet" href="../css/write.css" />
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/bookmark.js"></script>
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

</head>
<body>
	<%
		String id = (String) session.getAttribute("id");
		if (id == null) {
	%>
	<script type="text/javascript">
		alert('로그인 후 이용가능합니다');
		location.href = "login.jsp";
	</script>
	<%
		}
	%>

	<%@ include file="../bootstrap/header.jsp"%>
	<div style="height: 50px;"></div>
	<%@ include file="../bootstrap/menulink.jsp"%>
	<div style="height: 65px;"></div>
	
	<div class="container" style="text-align: center;">
		Send Mail
		<form action="SendMail.jsp" method="post">
			<input type="hidden" size="25" name="from" value="bjb806@naver.com"
				readonly />
			<table id="notice" align="center">
				<tr>
					<td>받는 사람</td>
					<td><input type="text" name="to" size="25" required="required"
						placeholder="abc123@naver.com"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" size="25" name="subject"
						required="required" /></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="content" rows="13" cols="40"
							required="required"></textarea></td>
				</tr>
			</table><br>
			<div id="table_search" style="float: none">
				<input type="submit" value="메일전송" class="board_btn01"> 
				<input type="reset" value="다시쓰기" class="board_btn01">
			</div>
		</form>
	</div>
	<div style="height: 55px;"></div>
	<jsp:include page="../bootstrap/footer.jsp" />
</body>
</html>



