<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="../js/bookmark.js"></script>
<link type="text/css" rel="stylesheet" href="../css/login.css" />
<link type="text/css" rel="stylesheet" href="../css/common.css" />
<title>▒ 로그인 ▒</title>
<script type="text/javascript">
	function findIdPw(){
		window.open("findIdPw.jsp", "findIdPw", "width=465, height=340, top=250, left=500");
	}
</script>
</head>
<body>
	<%@ include file="../bootstrap/header.jsp"%>
	<div style="height: 50px;"></div>
	<%@ include file="../bootstrap/menulink.jsp"%>
	<div style="height: 75px;"></div>
	<div id="contentWrapper">
		<div id="contentWrap">
			<div id="content">
				<div id="loginWrap">
					<div class="page-body">
						<div class="mlog-sign">
							<div class="mlog">
								<form action="login_pro.jsp" method="post" name="form1" autocomplete="off">
									<ul class="frm-list">
										<li class="id"><label>
											<span class="name">ID(User name)</span>
											<span><input type="text" name="id" maxlength="20" 
														 onblur="document.form1.passwd.focus();"class="MS_login_id" /></span></label>
										</li>
										<li class="pwd"><label>
											<span class="name">Password</span>
											<span><input type="password" name="passwd" maxlength="20" 
														 value="" class="MS_login_pw" /></span></label>
										</li>
									</ul>
									<input class="buttonlogin btnlogin" style="height: 35px;" type="submit" value="LOGIN">
								</form>
							</div>
							<div class="sign">
								<h3 class="blind">sign up</h3>
								<p class="msg">회원가입</p>
								<p class="buttonlogin1">
									<span><a href="join.jsp" class="btnlogin1">JOIN US</a></span>
								</p>
								<p class="msg">아이디 비밀번호 찾기</p>
								<p class="buttonlogin1">
									<span><a href="javascript:findIdPw();" class="btnlogin1">ID/PW SEARCH</a></span>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="height: 170px;"></div>	
	<%@ include file="../bootstrap/footer.jsp"%>
</body>
</html>