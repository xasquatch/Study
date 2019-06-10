
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
	<img src="img/option.jpg">
	
	<form action="CarOptionController.do" method="POST">
		<table width="1000" align="center">
			<tr>
				<td rowspan="7" width="600px">
					<img src="img/${param.carimg }" width="500px">
				</td>
				<td align="center" width="200">대여기간</td>
				<td align="center">
					<select name="carreserveday">
						<option value="1">1일</option>
						<option value="2">2일</option>
						<option value="3">3일</option>
						<option value="4">4일</option>
						<option value="5">5일</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center">대여일</td>
				<td align="center"><input type="date" name="carbegindate"></td>
			</tr>
			<tr>
				<td align="center">보험적용</td>
				<td align="center">
					<select name="carins">
						<option value="1">보험적용(1일 ×1만원)</option>
						<option value="0">비적용</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center">WIFI</td>
				<td align="center">
					<select name="carwifi">
						<option value="1">적용(1일 ×1만원)</option>
						<option value="0">비적용</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center">네비게이션</td>
				<td align="center">
					<select name="carnave">
						<option value="1">적용(무료)</option>
						<option value="0">비적용</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center">베이비시트</td>
				<td align="center">
					<select name="carbabyseat">
						<option value="1">적용(1일 ×1만원)</option>
						<option value="0">비적용</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center"><input type="button" value="차량 목록보기" onclick="location.href='CarListController.do'"> </td>
				<td align="center">
					<input type="hidden" name="carno" value="${param.carno }">
					<input type="hidden" name="carqty" value="${param.carqty }">
					<input type="hidden" name="carprice" value="${param.carprice}">
					<input type="submit" value="예약">
				</td>
			</tr>
		</table>
		
	</form>
	
	
	</center>
	
</body>
</html>