<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!-- bootstrap을 사용하기 위한 CDN주소 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- jquery를 사용하기위한 CDN주소 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- bootstrap javascript소스를 사용하기 위한 CDN주소 -->
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script>
	$(document).ready(function(){
	//	alert('jquery test');
	/* 입력폼 유효성 관련 요구사항
		1. 모든 폼은 공백 또는 "" 문자는 입력되면 안된다.
		2. 비밀번호는 4자이상 입력하여야 한다.
	*/
		$('#addButton').click(function(){
			if($('#boardPw').val().length <4) {
				alert('boardPw는 4자이상 이어야 합니다');
				$('#boardPw').focus();
			} else if($('#boardTitle').val()=='') {
				alert('boardTitle을 입력하세요');
				$('#boardTitle').focus();
			} else if($('#boardContent').val()=='') {
				alert('boardContent을 입력하세요');
				$('#boardContent').focus();
			} else if($('#boardUser').val()=='') {
				alert('boardUser을 입력하세요');
				$('#boardUser').focus();
			} else {
				$('#addForm').submit();
			}
		});
	});
</script>
<title>BOARD ADD(모델1 방식)</title>
</head>
<body>
<div class="container">
	<h1>BOARD ADD(모델1 방식)</h1>
	<form id="addForm" action="<%=request.getContextPath()%>/model1_board/boardAddAction.jsp" method="post">
		<div class="form-group">
			<label for="boardPw">boardPw :</label>
			<input class="form-control" name="boardPw" id="boardPw" type="password"/>
		</div>
		<div class="form-group">
			<label for="boardPw">boardTitle :</label>
			<input class="form-control" name="boardTitle" id="boardTitle" type="text"/>
		</div>
		<div class="form-group">
			<label for="boardContent">boardContent :</label>
			<textarea class="form-control" name="boardContent" id="boardContent" rows="5" cols="50"></textarea>
		</div>
		<div class="form-group">
			<label for="boardName">boardName :</label>
			<input class="form-control" name="boardUser" id="boardUser" type="text"/>
		</div>
		<div>
			<input class="btn btn-default" id="addButton" type="button" value="글입력"/>
			<input class="btn btn-default" type="reset" value="초기화"/>
			<a class="btn btn-default" href="<%=request.getContextPath()%>/model1_board/boardList.jsp">글목록</a>
		</div>
	</form>
</div>
</body>
</html>