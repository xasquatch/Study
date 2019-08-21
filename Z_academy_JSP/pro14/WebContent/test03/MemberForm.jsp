<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h1{
		text-align : center;
	}
	
	
</style>

</head>
<body>
	<form action="Member9.jsp" method="get">
		<h1>회원 등록창</h1>
		<table align="center">
			<tr>
				<td width= "400" align="right"><p>ID</p></td>
				<td width= "400"><input type="text" name="id"></td>
			</tr>
			<tr>
				<td width= "400" align="right"><p>PW</p></td>
				<td width= "400"><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td width= "400" align="right"><p>NAME</p></td>
				<td width= "400"><input type="text" name="name"></td>
			</tr>
			<tr>
				<td width= "400" align="right"><p>EMAIL</p></td>
				<td width= "400"><input type="text" name="email"></td>
			</tr>
			<tr>
				<td width= "400" align="right"><p>&nbsp;</p></td>
				<td width= "400">
					<input type="submit" value="submit"><input type="reset" value="reset">
				</td>
			</tr>
		</table>
		
	</form>
	
</body>
</html>