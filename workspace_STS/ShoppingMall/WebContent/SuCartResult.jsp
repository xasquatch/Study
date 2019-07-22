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
		<h1><font color="yellow">카트 내용확인</font></h1>
		<table width="800">
			<tr height="40">
				<td align="center" width="200">
					<font color="white" size="2">상품 이미지</font>
				</td>
				<td align="center" width="150">
					<font color="white" size="2">상품명</font>
				</td>
				<td align="center" width="100">
					<font color="white" size="2">상품가격</font>
				</td>
				<td align="center" width="150">
					<font color="white" size="2">상품수량</font>
				</td>
				<td align="center" width="150">
					<font color="white" size="2">상품총금액</font>
				</td>
				<td align="center" width="100">
					<font color="white" size="2">상품 취소</font>
				</td>
			</tr>
			<c:forEach var="sucartbean" items="${sessionScope.cart.itemlist}">
				<tr height="80">
					<td align="center" width="200">
						<img src="img/${sucartbean.suimg}" width="150" height="80">
					</td>
					<td align="center" width="150">
						<font color="white" size="2">${sucartbean.suname}</font>
					</td>
					<td align="center" width="100">
						<font color="white" size="2">${sucartbean.suprice}원</font>
					</td>
					<td align="center" width="150">
						<font color="white" size="2">${sucartbean.suqty}</font>
					</td>
					<td align="center" width="150">
						<font color="white" size="2">${sucartbean.suprice*sucartbean.suqty}원</font>
					</td>
					<td align="center" width="100">
						<input type="button"
							 value="카트삭제" onclick="location.href='sucartdel.do?suno=${sucartbean.suno}'">
					</td>
				</tr>
			</c:forEach>
				<tr height="70">
					<td align="center" colspan="6">
						<font size="3" color="white">${msg}</font>
					</td>
				</tr>
				<tr height="50">
					<td align="center" colspan="6">
						<input type="button" value="목록보기" onclick="location.href='index.do'">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="계산하기" onclick="location.href='sucatbuy.do'">
					</td>
				</tr>
		</table>
	</center>
</body>
</html>