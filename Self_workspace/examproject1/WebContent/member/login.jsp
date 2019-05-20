<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="../css/main.css"/>
</head>
<body>
	<form action="loginProc.jsp" method="post" id="login_form">
		<img src="../images/new_logo.png" alt="logo image" id="logo_login"/>
		<input type="text" name="id" id="idBox" title="Username" placeholder="Username"/>
		<input type="password" name="pass" id="passBox" title="Password" placeholder="Password"/>
		<div id="alert_area"></div>
		<input type="submit" value="로그인" id="loginBtn"/>
		<div id="login_more">
			<a href="#">아이디</a> 혹은 <a href="#">비밀번호</a>가 기억나지 않나요?
		</div>
	</form>
</body>
</html>