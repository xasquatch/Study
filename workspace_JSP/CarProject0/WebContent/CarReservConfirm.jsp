<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<img src="img/hwakin.jpg">
		<form action="CarReserveConfirmController.do" method="POST">
			<table width="400" border="0">
				<tr height="60" align="center">
					<td align="center" width="200">전화번호 입력:</td>
					<td align="center" width="200">
						<input type="text" name="memberphone">
					</td>
				</tr>
				<tr height="60" align="center">
					<td align="center" width="200">비밀번호입력:</td>
					<td align="center" width="200">
						<input type="password" name="memberpass">
					</td>
				</tr>
				<tr height="60" align="center">
					<td colspan="2"><input type="submit" value="예약정보검색"></td>
				</tr>
			</table>
		</form>
	</center>
	
</body>
</html>