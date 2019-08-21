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
	<c:if test="${result == 1}">
		<script type="text/javascript">
			window.alert("해당 아이디는 존재합니다. 다른 아이디를 넣어주세요.");
		</script>
	</c:if>
	<c:if test="${result == 2}">
		<script type="text/javascript">
			window.alert("비밀번호를 다시 입력해주세요");
		</script>
	</c:if>
		
	<center>
		<h2>
			<font color="white">회원가입</font>
		</h2>
		<form action="joinproc.do" method="POST">
			<table width="400" border="0" cellspacing="1" cellpadding="4">
				<tr height="40">
					<td align="right" width="180"><font color="white" size="3">아이디</font></td>
					<td width="220"><input type="text" name="memid" size="20">
					</td>
				</tr>
				<tr height="40">
					<td align="right" width="180"><font color="white" size="3">비밀번호</font></td>
					<td width="220"><input type="password" name="mempasswd1"
						size="20"></td>
				</tr>
				<tr height="40">
					<td align="right" width="180"><font color="white" size="3">비밀번호
							확인</font></td>
					<td width="220"><input type="password" name="mempasswd2"
						size="20"></td>
				</tr>
				<tr height="40">
					<td align="right" width="180"><font color="white" size="3">이름</font></td>
					<td width="220"><input type="text" name="memname" size="20">
					</td>
				</tr>
				<tr height="40">
					<td align="right" width="180"><font color="white" size="3">전화번호</font></td>
					<td width="220"><input type="text" name="memphone" size="20">
					</td>
				</tr>
				<tr height="40">
					<td align="right" width="180"><font color="white" size="3">기념일</font></td>
					<td width="220"><input type="date" name="memdate" size="20">
					</td>
				</tr>
				<tr height="40">
					<td colspan="2" align="center">
						<input type="submit" value="회원가입">&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시작성">
					</td>
				</tr>

			</table>


		</form>
	</center>






</body>
</html>