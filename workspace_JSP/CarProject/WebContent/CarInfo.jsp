<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--JSTL라이브러리에 속한 태그들중.. core라이브러리에 속한 태그를 사용하기 위해 링크 설정 --%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>           
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 	자동차 예약시 옵션을 선택할수 있고  검색해온 차량정보를 화면에 출력 해주는 페이지 -->
	<center>
		<img src="img/cis.jpg">
		
	<!-- 자동차 렌트시 옵션 선택하기 버튼을 눌렀을떄.. 옵션 선택 페이지 화면을 요청! -->	
	<form action="CarMain.jsp?center=CarOption.jsp" method="post">
		<table width="1000" border="0">
				<tr align="center">
					<td rowspan="6" width="600">
						<img src="img/${requestScope.bean.carimg}" width="500">
					</td>
					<td align="center" width="200">차량이름</td>
					<td align="center" width="200">${bean.carname}</td>
				</tr>
				<tr>
					<td align="center" width="200">대여수량</td>
					<td align="center" width="200">
						<select name="carqty">
								<option value="1">1대</option>
								<option value="2">2대</option>
								<option value="3">3대</option>
								<option value="4">4대</option>
								<option value="5">5대</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="center" width="200">대여금액</td>
					<td align="center" width="200">
						${bean.carprice}
					</td>
				</tr>
				<tr>
					<td align="center" width="200">제조회사</td>
					<td align="center" width="200">
						${bean.carcompany}
					</td>
				</tr>
				<tr>
					<td align="center" width="200">
						<!-- CarList.jsp로 이동 ~ -->
						 <input type="button" 
						 		value="이전" 
						 		onclick="location.href='CarListController.do'">
					</td>
					<td align="center" width="200">
						<!-- 옵션선택 페이지 화면으로 예약할 차번호,이미지명,차한대당가격을  hidden으로 전달 -->
						<input type="hidden" name="carno" value="${bean.carno}">
						<input type="hidden" name="carimg" value="${bean.carimg}">
						<input type="hidden" name="carprice" value="${bean.carprice}">
						
						<input type="submit" value="옵션선택하기">
					</td>
				</tr>									
		</table>
	</form>
	</center>
	<p>
		<b>차량 설명 내용</b>
		${bean.carinfo}
	</p>
</body>
</html>










