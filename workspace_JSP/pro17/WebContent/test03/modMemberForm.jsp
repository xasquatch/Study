<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보 수정</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<%request.setCharacterEncoding("utf-8"); %>
<form action="${contextPath}/member/modMember.do" method="POST"
				style="background-image:URL(${contextPath}/img/img.jpg); padding:100px 100px;">
		<h1 align="center">회원정보 수정</h1>
		<table align="center">
			<tr>
				<th width="200"><p align="right">ID</p></th>
				<td width="400"><input type="text" name="userid" value="${meminfo.id }" readonly="readonly" ></td>
			</tr>
			<tr>
				<th width="200"><p align="right">PassWord</p></th>
				<td width="400"><input type="password" name="userpw" value="${meminfo.pwd }"></td>
			</tr>
			<tr>
				<th width="200"><p align="right">Full Name</p></th>
				<td width="400"><input type="text" name="username" value="${meminfo.name }"></td>
			</tr>
			<tr>
				<th width="200"><p align="right">Email</p></th>
				<td width="400"><input type="text" name="useremail" value="${meminfo.email }"></td>
			</tr>
			<tr>
				<th width="200"><p align="right">JoinDate</p></th>
				<td width="400"><input type="text" name="userdate" value="${meminfo.joindate }" readonly="readonly"></td>
			</tr>
			<tr>
				<td width="200"><p>&nbsp;</p></td>
				<td width="400">
					<input type="submit" value="MODIFY">
					<input type="reset" value="RESET">
				</td>
			</tr>
		</table>
		
	</form>
	<h2 align="center">${notice}</h2>

</body>
</html>