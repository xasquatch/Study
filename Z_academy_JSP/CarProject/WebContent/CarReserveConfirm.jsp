<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<!--CarReserveConfirm.jsp 예약확인을 위해 전화번호 입력, 비밀번호 입력 하는 페이지  -->

	<center>
		<img src="img/hwakin.jpg"> <!--  <예약 확인> 이미지 -->	
		
		<form action="CarReserveConfirmController.do" method="post">
			<table width="400" border="0">
					<tr height="60" align="center">
						<td align="center" width="200">전화번호 입력:</td>
						<td align="center" width="200">
							<input type="text" name="memberphone">
						</td>						
					</tr>
					<tr height="60" align="center">
						<td align="center" width="200">비밀번호 입력:</td>
						<td align="center" width="200">
							<input type="text" name="memberpass">
						</td>						
					</tr>	
					<tr height="60" align="center">
						<td colspan="2"><input type="submit" value="예약정보검색"></td>
					</tr>		
			</table>
		</form>
	</center>
</body>
</html>






