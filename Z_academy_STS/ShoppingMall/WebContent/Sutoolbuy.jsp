<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 완료 페이지</title>
<style type="text/css">
	td{
		text-align: center;
		color: white;
		font-size: 2;
	}
	
	
</style>
</head>
<body>
	<center>
		<h2><font color="yellow">결제 완료 페이지</font></h2>
		<table width="800">
			<tr>
				<td width="200">상품이미지</td>
				<td width="200">상품명</td>
				<td width="100">상품가격</td>
				<td width="100">상품수량</td>
				<td width="200">상품총금액</td>
			</tr>
		<c:set var="total" value="${0 }"/>	
			
		<c:if test="${sessionScope.cart == null }">
			<tr>
				<td width="200"><img src="img/${subean.suimg }" width="180" height="70"></td>
				<td width="200">${subean.suname }</td>
				<td width="100">${subean.suprice}원</td>
				<td width="100">${subean.suqty }개</td>
				<td width="200">${subean.suprice*subean.suqty}원</td>
			</tr>
		</c:if>
		
		<c:set var="total" value="${subean.suprice*subean.suqty}"/>
			<tr height="70">
				<td align="center" colspan="5">
					<font size="5" color="red">
						총 결제 금액은 ${total }원입니다.
					</font>
				</td>
			</tr>
			<tr>
				<td colspan="5">
					<input type="button" onclick="location.href='index.do'" value="계산 완료하기">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소하기">
				</td>
			</tr>
		</table>
	</center>
	
</body>
</html>