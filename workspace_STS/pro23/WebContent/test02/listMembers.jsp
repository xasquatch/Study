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
<title></title>
<script type="text/javascript">
	$(document).ready(function() {
		$('#myModal').modal();
	})
	
</script>
</head>
<body>
<div  id="myModal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
     <div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
     	<h4 align="center">리스트임</h4>
     </div>
	 <div class="modal-body">
	 <table class="table table-hover">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>이메일</td>
			<td>가입일</td>
		</tr>
		<c:forEach items="${requestScope.membersList}" var="member">		
			<tr>
				<td>${member.id }</td>
				<td>${member.pwd }</td>
				<td>${member.name }</td>
				<td>${member.email }</td>
				<td>${member.joinDate }</td>
			</tr>		
		</c:forEach>		
	</table>
	<div align="center">
		<a class="btn btn-success" href="${pageContext.request.contextPath}/member/memberForm.do">
			회원가입
		</a>
	</div>
	 </div>
	</div>
  </div>
</div>
</body>
</html>