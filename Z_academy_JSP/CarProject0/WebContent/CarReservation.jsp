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
		<table width="100%">
			<tr>
				<td align="center" width="33%">
					<a href="main.jsp?center=CarEvent.jsp"><img src="img/lfsonata.jpg" width="100%"></a>
				</td>
				<td align="center" width="33%">
					<a href="main.jsp?center=CarEvent.jsp"><img src="img/k5.jpg" width="100%"></a>
				</td>
				<td align="center" width="33%">
					<a href="main.jsp?center=CarEvent.jsp"><img src="img/avante.jpg" width="100%"></a>
				</td>
			</tr>
		</table>
		<h1><img src="img/ccs.jpg" height="50"></h1>
		
		<form action="CarCategoryController.do" method="post">
			<table width="400" border="0">
				<tr align="center">
					<td width="100">차량 종류</td>
					<td width="100" height="50">
						<select name="carcategory">
							<option value="Small">소형</option>
							<option value="Mid">중형</option>
							<option value="Big">대형</option>
						</select>
					</td>
					<td align="center">
						<input type="submit" value="검색">
					</td>
					<td align="center">
						<input type="button" value="전체 검색" onclick="location.href='CarListController.do'">
					</td>
				</tr>
			</table>
		
		</form>
		
		
		
		
	</center>
</body>
</html>