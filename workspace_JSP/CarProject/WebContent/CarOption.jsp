<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<!-- <옵션 선택>이미지 -->
		<img src="img/option.jpg">
		
		<!-- [예약하기] 버튼을 눌렀을떄.. 서블릿으로 요청! -->
		<form action="CarOptionController.do" method="post">
			<table width="1000" border="0" align="center">
				<tr align="center">
					<td rowspan="7" width="600">
						<img src="img/${param.carimg}" width="500">
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
							<option value="1">보험적용(1일 1만원)</option>
							<option value="0">비적용</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="center">무선WIFI</td>
					<td align="center">
						<select name="carwifi">
							<option value="1">적용(1일 1만원)</option>
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
							<option value="1">적용(1일1만원)</option>
							<option value="0">비적용</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="button" 
						       onclick="location.href='CarListController.do'"
						       value="차량목록보기">				
					</td>
					<td align="center">			
						<input type="hidden" name="carno" value="${param.carno}">
						<input type="hidden" name="carqty" value="${param.carqty}">
						<input type="hidden" name="carprice" value="${param.carprice}">
					 
						<input type="submit" value="예약">
					</td>
				</tr>						
			</table>
		</form>
	</center>






</body>
</html>




