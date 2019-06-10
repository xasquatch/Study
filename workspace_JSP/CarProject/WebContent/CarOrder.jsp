
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
		<img src="img/haki.jpg">
		
		<form action="CarOrderController.do">
			<p>
				<font size="13" color="blue">차량 렌트 비용 : ￦ ${requestScope.totalreserve }</font>
			</p>
			<p>
				<font size="13" color="blue">차량 옵션 비용 : ￦ ${requestScope.totaloption }</font>
			</p>
			<p>
				<font size="13" color="blue">총 비용 : ￦ ${totalreserve+totaloption }</font>
			</p>
			<p>
				<input type="hidden" name="carno" value="${cbean.carno }">
				<input type="hidden" name="carqty" value="${cbean.carqty }">
				<input type="hidden" name="carreserveday" value="${cbean.carreserveday }">
				<input type="hidden" name="carins" value="${cbean.carins }">
				<input type="hidden" name="carwifi" value="${cbean.carwifi }">
				<input type="hidden" name="carnave" value="${cbean.carnave }">
				<input type="hidden" name="carbabyseat" value="${cbean.carbabyseat }">
				<input type="hidden" name="carbegindate" value="${cbean.carbegindate }">
			
			</p>	
			<p>
				비회원 전화번호 예약 : <input type="text" name="memberphone" size="10">&nbsp;&nbsp;&nbsp;&nbsp;
				비밀번호 : <input type="password" name="memberpass" size="10">
				<input type="submit" value="결제하기">
			</p>
			
		</form>
		
		
		
		
	</center>
	
	
	
</body>
</html>