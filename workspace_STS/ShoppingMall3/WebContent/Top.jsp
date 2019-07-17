<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSTL core라이브러리 태그 사용을 위한 지시자 선언 -->    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="black">
	<center>
		<table width="1000" height="5">
			<tr height="50">
				<!-- 로고이미지 -->
				<td align="left" width="500">
					<a href="ShoppingMain.jsp">
						<img src="img/logo.JPG" alt="left" border="0">
					</a>
				</td>
				<!-- 회원 로그인 여부
					 세션영역에 MemberBean객체가 존재 하지 않으면~ [로그인] [회원가입]버튼 보이게 설정
				 -->
			<c:if test="${mbean == null }">
				<td align="right" width="300">
					<input type="button" value="로그인" onclick="location.href='login.do'">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="회원가입" onclick="location.href='joinform.do'">
				</td>			
			</c:if>
			
			<c:if test="${mbean != null }">
				<td align="right" width="200">
					<font size="3" color="white">${mbean.memid}님 환영합니다.</font>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="로그아웃" 
					       onclick="location.href='logout.do'">
				</td>
			</c:if>
			
			<!-- 검색부분 -->
			<form action="mainsearch.do" method="post">
				<td align="right" width="200">
					<input type="text" name="msearch" size="10">
					<input type="submit" value="검색">
				</td>
			</form>
			</tr>	
		</table>
		
		<!-- 메뉴들을 나타내는 Table공간 -->
		<table width="1000" height="5">
			<tr>
				<td align="center" bgcolor="black">
					<a href="sujak.do">
					<img src="img/sujak.JPG"> <!-- 수작업공구 메뉴 -->
					</a>
				</td>
				<td align="center" bgcolor="black">
					<a href="jundong.do">
					<img src="img/jundong.JPG"> <!-- 전동공구 메뉴 -->
					</a>
				</td>
				<td align="center" bgcolor="black">
					<a href="stanlyinfo.do">
					<img src="img/stanlyinfo.JPG"> <!-- 스탠리 회사 소개 메뉴 -->
					</a>
				</td>
				<td align="center" bgcolor="black">
					<a href="tooluse.do">
					<img src="img/tooluse.JPG"> <!-- 공구 사용법 메뉴 -->
					</a>
				</td>	
				<td align="center" bgcolor="black">
					<a href="dowonload.do">
					<img src="img/download.JPG"> <!-- 다운로드 메뉴 -->
					</a>
				</td>	
				<td align="center" bgcolor="black">
					<a href="board.do">
					<img src="img/gogak.JPG"> <!-- 고객센터 메뉴 -->
					</a>
				</td>																	
			</tr>	
		</table>	
	</center>

</body>
</html>





