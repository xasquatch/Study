<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<center>
		<h2><font color="yellow">회원로그인</font></h2>
		<form action="loginproc.do" method="POST">
			<table width="500">
				<tr height="40">
					<td width="200" align="center">
						<font size="2" color="white">아이디</font>
					</td>
					<td width="200" align="center">
						<font size="2" color="white">
							<input type="text" name="memid" size="30">
						</font>
					</td>
				</tr>
				<tr height="40">
					<td width="200" align="center">
						<font size="2" color="white">비밀번호</font>
					</td>
					<td width="200" align="center">
						<font size="2" color="white">
							<input type="password" name="mempasswd1" size="30">
						</font>
					</td>
				</tr>
				<tr height="40">
					<td colspan="2" align="center">
						<input type="submit" value="로그인">&nbsp;&nbsp;&nbsp;&nbsp;
						<font size="2" color="white">아이디 패스워드 찾기</font>
					</td> 
				</tr>
			</table>
		</form>
	</center>
</body>
</html>