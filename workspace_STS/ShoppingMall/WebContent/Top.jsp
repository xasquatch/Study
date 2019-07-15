<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<center>
		<table width="1000" height="5">
				<!-- 로고이미지 -->
				<td align="left" width="500">
					<a href="shoppingMain.jsp">
						<img src="img/logo.JPG" alt="left" border="0">
					</a>
				</td>
				<!-- 회원 로그인 여부
					세션영역에 MemberBean객체가 존재하지 않으면 로그인, 회원가입 버튼을 보이게 설정
				 -->
					<c:if test="${mbean == null}">
						<td align="right" width="300">
							<input type="button" value="로그인" onclick="location.href='login.do'">
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" value="회원가입" onclick="location.href='joinForm.do'">
						</td>
					</c:if>
					<c:if test="${mbean != null}">
						<td align="right" width="200">
							<font size="3" color="white">${mbean.memid}님 환영합니다.</font>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" value="로그아웃" onclick="location.href='logout.do'">
						</td>
					</c:if>
				<!-- 검색부분 -->
				<td align="right" width="200">
					<form action="mainsearch.do" method="POST">
							<input type="text" name="msearch" size="10">
							<input type="submit" value="검색">
					</form>
				</td>
			</table>
			<!-- 메뉴들을 나타내는 table공간 -->
			<table width="1000" height="5">
				<tr>
					<td align="center" bgcolor="black">
						<a href="sujak.do">
							<img src="img/sujak.JPG">
						</a>
					</td>
					<td align="center" bgcolor="black">
						<a href="jundong.do">
							<img src="img/jundong.JPG">
						</a>
					</td>
					<td align="center" bgcolor="black">
						<a href="stanlyinfo.do">
							<img src="img/stanlyinfo.JPG">
						</a>
					</td>
					<td align="center" bgcolor="black">
						<a href="tooluse.do">
							<img src="img/tooluse.JPG">
						</a>
					</td>
					<td align="center" bgcolor="black">
						<a href="download.do">
							<img src="img/download.JPG">
						</a>
					</td>
					<td align="center" bgcolor="black">
						<a href="gogak.do">
							<img src="img/gogak.JPG">
						</a>
					</td>
				</tr>
			</table>
	</center>
	
	
</body>
</html>