<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%request.setCharacterEncoding("utf-8");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${pageContext.request.contextPath }/member/addMember.do" method="POST"
				style="background-image:URL(${pageContext.request.contextPath}/img/rr.jpg); padding:100px 100px;">
		<h1 align="center">JOIN FORM</h1>
		<table align="center">
			<tr>
				<th width="200"><p align="right">ID</p></th>
				<td width="400"><input type="text" name="userid"></td>
			</tr>
			<tr>
				<th width="200"><p align="right">PassWord</p></th>
				<td width="400"><input type="password" name="userpw"></td>
			</tr>
			<tr>
				<th width="200"><p align="right">Full Name</p></th>
				<td width="400"><input type="text" name="username"></td>
			</tr>
			<tr>
				<th width="200"><p align="right">Email</p></th>
				<td width="400"><input type="text" name="useremail"></td>
			</tr>
			<tr>
				<td width="200"><p>&nbsp;</p></td>
				<td width="400">
					<input type="submit" value="JOIN">
					<input type="reset" value="RESET">
				</td>
			</tr>
		</table>
		
	</form>
	<h2 align="center">${notice}</h2>
</body>
</html>