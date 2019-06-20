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
	<table align="center" border="1">
		<tr align="center">
			<th width="10%">Number</th>
			<th width="10%">Name</th>	
			<th width="10%">Company</th>
			<th width="10%">price</th>
			<th width="10%">UsePeople</th>
			<th width="10%">Info</th>
			<th width="10%">Image</th>
			<th width="10%">Category</th>
		</tr>
		<tr align="center">
			<td width="10%">${bean.carno}</td>
			<td width="10%">${bean.carname}</td>
			<td width="10%">${bean.carcompany}</td>
			<td width="10%">${bean.carprice}</td>
			<td width="10%">${bean.carusepeople}</td>
			<td width="10%">${bean.carinfo}</td>
			<td width="10%"><img src="img/${bean.carimg}" width="100%"></td>
			<td width="10%">${bean.carcategory}</td>
		</tr>
	</table>
	<hr>
	<center>
		<form action="main.jsp?center=CarOption.jsp" method="POST">
			<table width="1000">
				<tr align="center">
					<th rowspan="6" width="600">
						<img src="img/${bean.carimg}">
					</th>
					<td align="center" width="200">차량 이름</td>
					<td>${bean.carname}</td>
				</tr>
				<tr>
					<td align="center" width="200">대여수량</td>
					<td align="center" width="200">
						<select	name="carqty">
							<option value="1">1대</option>
							<option value="2">2대</option>
							<option value="3">3대</option>
							<option value="4">4대</option>
							<option value="5">5대</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="center" width="200">대여 금액</td>
					<td align="center" width="200">${bean.carprice}</td>
				</tr>
				<tr>
					<td align="center" width="200">제조회사</td>
					<td align="center" width="200">${bean.carcompany}</td>
				</tr>
				<tr>
					<td align="center" width="200">UsePeople</td>
					<td align="center" width="200">${bean.carusepeople}</td>
				</tr>
				<tr>
					<td align="center" width="200">
							<input type="submit" value="옵션 선택하기">
							<input type="hidden" name="carno" value="${bean.carno}">
							<input type="hidden" name="carimg" value="${bean.carimg}">
							<input type="hidden" name="carprice" value="${bean.carprice}">
							<input type="hidden" name="carcompany" value="${bean.carcompany}">
					</td>
					<td align="center" width="200">
							<input type="button" value="이전" onclick="location.href='CarListController.do'">
					</td>
				</tr>
			</table>
		</form>
	</center>
	<p>
		<b>차량 설명 내용</b><BR>
		${bean.carinfo }
	</p>
	
	
	
</body>
</html>