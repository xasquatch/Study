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
<title>회원검색창</title>
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
				회원검색창
			</div>
		<div class="modal-body">
			<!-- 검색창에 입력한 값과 셀렉트 박스의 검색조건을 선택해 서블릿으로 전송합니다. -->
			<form class="form form-inline" action="${pageContext.request.contextPath}/mem3.do" method="post">
				<div class="input-group">
					<div class="input-group-addon">입력</div>
					<input class="form-control" type="text" name="value">
				</div>
				<select class="form-control" name="action">
					<option value="listMembers">전체</option>
					<option value="selectMemberById">아이디</option>
					<option value="selectMemberByPwd">비밀번호</option>
				</select>
				<input type="submit" value="전송">
			</form>
		</div>
		</div>
	</div>
</div>
	
</body>
</html>