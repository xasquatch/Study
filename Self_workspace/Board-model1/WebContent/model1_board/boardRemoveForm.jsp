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
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script>
	$(document).ready(function(){
		$('#removeButton').click(function(){
			if($('#boardPw').val().length <4) {
				alert('boardPw는 4자이상 이어야 합니다');
				$('#boardPw').focus();
			} else {
				$('#removeForm').submit();
			}
		});
	});
</script>
<title>BOARD REMOVE FORM(모델1 방식)</title>
</head>
<body>
<div class="container">
<h1>BOARD REMOVE FORM(모델1 방식)</h1>
<%
	// boardNo값이 넘어오지 않으면 boardList.jsp로 이동
	if(request.getParameter("boardNo") == null) {
	    response.sendRedirect(request.getContextPath()+"/jsp_board/boardList.jsp");
	} else {
%>
	    <form  class="form-inline" id="removeForm" action="<%=request.getContextPath()%>/jsp_board/boardRemoveAction.jsp" method="post">
	        <!-- boardPw와 함께 boardNo값도 숨겨서(hidden값으로) 넘김 -->
	        <input name="boardNo" value="<%=request.getParameter("boardNo")%>" type="hidden"/>
	        <div class="form-group">
	        	<label for="boardPw">비밀번호확인 :</label>
	        	<input class="form-control" id="boardPw" name="boardPw" type="password">
	        </div>
	        <div class="form-group">
	            <input class="btn btn-default" id="removeButton" type="button" value="삭제"/>
	        </div>
	    </form>
<%    
	}
%>
</div>
</body>
</html>