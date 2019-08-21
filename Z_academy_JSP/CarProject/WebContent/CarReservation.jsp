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
		<%--자주 렌트되는 차량 이미지 3~4개를 화면에 나타내고  --%>
		<table width="1000" border="0">
			<tr>
				<td align="center" width="333">
					<a href="CarMain.jsp?center=CarEvent.jsp">
						<img src="img/lfsonata.jpg" width="280">
					</a>
				</td>
				<td align="center" width="333">
					<a href="CarMain.jsp?center=CarEvent.jsp">
						<img src="img/k5.jpg" width="280">
					</a>
				</td>
				<td align="center" width="333">
					<a href="CarMain.jsp?center=CarEvent.jsp">
						<img src="img/avante.jpg" width="280">
					</a>
				</td>								
			</tr>
		
		</table>
	
		<%-- 소형, 중형, 대형을 기준으로 차량을 검색해서 결과를 화면에 나타내는 부분--%>
		<h1><img src="img/ccs.jpg" height="50"> </h1> <%--<차량 종류 보기>이미지 --%>
		
<form action="CarCategoryController.do" method="post">
		<table width="400" border="0">
			<tr align="center">
				<td width="100">차량 종류</td>
				<td width="100" height="50">
					<select name="carcategory">
						<option value="Small">소형
						<option value="Mid">중형
						<option value="Big">대형
					</select>
				</td>
				<td align="center">
					<input type="submit" value="검색">
				</td>
				<td align="center">
					<input type="button" value="전체검색" 
					onclick="location.href='CarListController.do'">
				</td>
				
			</tr>	
		</table>	
</form>
		
	
	
	</center>

</body>
</html>



