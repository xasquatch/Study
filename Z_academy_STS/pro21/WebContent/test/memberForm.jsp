<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%request.setCharacterEncoding("UTF-8");%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CDN START LINE-->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- CDN END -->
<title>sign up membership</title>
<script type="text/javascript">
	$(document).ready(function() {
		$('#membership').modal();
	})
</script>
</head>
<body>
<div id="membership" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
		
			<form action="${contextpath}/test/memberInfo.do" method="POST">
				<table class="table table-hover">
					<tr>
						<td colspan="2"><h1 align="left">회원가입하세요</h1></td>
					</tr>
					<tr>
						<td><p align="right">아이디</p></td>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<td><p align="right">비밀번호</p></td>
						<td><input type="password" name="pwd"></td>
					</tr>
					<tr>
						<td><p align="right">이름</p></td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td><p align="right">이메일</p></td>
						<td><input type="email" name="email"></td>
					</tr>			
					<tr>
						<td colspan="2">
							<p align="center">
							<input class="btn btn-primary" type="submit" value="가입하기">&nbsp;&nbsp;
							<input class="btn btn-primary" type="reset" value="다시입력">
							</p>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>
	
	
	
</body>
</html>