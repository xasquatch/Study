<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<img src="img/naeyeok.jpg">
	</center>
	<p></p>
	<table width="1000" border="1" align="center">
		<tr align="center">
			<td align="center" width="150">차량이미지</td>
			<td align="center" width="100">차량명</td>
			<td align="center" width="100">대여일</td>
			<td align="center" width="50">대여기간</td>
			<td align="center" width="100">차량금액</td>
			<td align="center" width="70">보험여부</td>
			<td align="center" width="70">WIFI</td>
			<td align="center" width="70">네비게이션</td>
			<td align="center" width="70">베이비시트</td>
			<td align="center" width="100">예약정보수정</td>
			<td align="center" width="100">예약정보삭제</td>
		</tr>
		<c:forEach var="bean" items="${requestScope.vector }">
			<td align="center" width="150">
				<img src="img/${bean.carimg}" width="140" height="90">
			</td>
			<td align="center" width="100">${bean.carname }</td>
			<td align="center" width="100">${bean.carbegindate }</td>
			<td align="center" width="50">${bean.carreserveday }</td>
			<td align="center" width="100">${bean.carprice }</td>
			<td align="center" width="70">
			<c:if test="${bean.carins == 1}">보험가입</c:if>
			<c:if test="${bean.carins == 0}">미가입</c:if>
			</td>
			<td align="center" width="70">
			<c:if test="${bean.carwifi == 1}">대여</c:if>
			<c:if test="${bean.carwifi == 0}">미대여</c:if>
			</td>
			<td align="center" width="70">
			<c:if test="${bean.carnav == 1}">대여</c:if>
			<c:if test="${bean.carnav == 0}">미대여</c:if>
			</td>
			<td align="center" width="70">
			<c:if test="${bean.carbabyseat == 1}">대여</c:if>
			<c:if test="${bean.carbabyseat == 0}">미대여</c:if>
			</td>
			<td align="center" width="100">
				<button onclick="location.href='CarConfimUpdateController.do?orderid=${bean.orderid}&carimg=${bean.carimg}'">
				예약정보수정
				</button>
			</td>
			<td align="center" width="100">
				<button onclick="location.href='main.jsp?center=CarConfirmDelete.jsp&orderid=${bean.orderid}'">
				예약정보삭제
				</button>
			</td>
		</c:forEach>
	</table>
	
</body>
</html>