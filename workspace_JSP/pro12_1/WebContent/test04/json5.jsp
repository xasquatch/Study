<%--자바스크립트에서 회원정보를 JSON객체로 만들어 매개변수를 이름 jsonInfo로	ajax통신을 이용해 서블릿으로 전송함 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#checkJson").click(function() {
			//전송할 회원정보로 JSON 데이터 형식의 문자열로 만들어서 변수에 저장
			var _jsonInfo = '{"name":"박지성","age":"25","gender":"남자","nickname":"날쌘돌이"}';
			
			$.ajax({
				type : "POST",
				url : "<%=request.getContextPath()%>/json",
				data : {jsonInfo:_jsonInfo},//매개변수 이름 jsonInfo로 JSON데이터형식의 문자
				
				success: function(data,textStatus) {},
				error: function(data,textStatus) {alert("에러발생")},
				complete: function(data,textStatus) {}
			});//end - $.ajax()
			
		});
	});
	
</script>
</head>
<body>
	<a id="checkJson" style="cursor:pointer;">출력</a>
	<div id="output"></div>

</body>
</html>