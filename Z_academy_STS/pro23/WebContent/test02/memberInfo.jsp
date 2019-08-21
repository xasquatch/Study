<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>회원정보 출력창</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#mmodal").modal();
	})
</script>
</head>
<body>

<div id="mmodal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				회원정보 출력창
			</div>
			<div class="modal-body">
				<table class="table table-hover">
					<tr>
						<th>아이디</th>
						<th>비밀번호</th>
						<th>이름</th>
						<th>이메일</th>
						<th>가입일</th>
					</tr>
					<tr>
						<td>${member.id}</td>
						<td>${member.pwd}</td>
						<td>${member.name}</td>
						<td>${member.email}</td>
						<td>${member.joinDate}</td>
					</tr>		
				</table>
			</div>
		</div>
	</div>
</div>
	
</body>
</html>