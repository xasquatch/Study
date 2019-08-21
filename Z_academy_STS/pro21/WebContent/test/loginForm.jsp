<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%request.setCharacterEncoding("UTF-8");%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginForm Page</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<div id="myModal" class="modal fade">
	<div class="modal-dialog">
	    <div class="modal-content" style="text-align: center;">
	<form name="frmLogin" method="POST" action="${contextpath}/test/login.do">
		<table class="table table-hover">
			<tr>
				<td colspan="2">로그인폼</td>
			</tr>
			<tr>
				<td>ID</td>
				<td>PWD</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="userID" size="20">
				</td>
				<td>
					<input type="password" name="passWD" size="20">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input class="form-control" type="submit" value="전송">
				</td>
			</tr>
		</table>
	</form>
</div>
</div>	
</div>	
	<script type="text/javascript">
		$('#myModal').modal();
	</script>
</body>
</html>