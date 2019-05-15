<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	//웹브라우저가 json3.jsp의 코드를 모두 로딩했을 때 이벤트 핸들러 함수가 실행되게 선언
	$(function() {
		$("#checkJson").click(function() {
			var jsonStr = '{"name":"박지성","age":"25","gender":"남자","nickname":"날쌘돌이"}';
			
			var jsonObj = JSON.parse(jsonStr);
			
			var output = "회원정보<BR>";
			output += "============<br>";
			//JSON객체의 속성값을 가져옴
			output += "이름 : " + jsonObj.name + "<BR>";
			output += "나이 : " + jsonObj.age + "<BR>";
			output += "성별 : " + jsonObj.gender + "<BR>";
			output += "별명 : " + jsonObj.nickname + "<BR>";
			
			$("#output").html(output);
// 			document.querySelector("#output").innerHTML = output;
		})
	});

</script>
</head>
<body>
	<a id="checkJson" style="cursor:pointer;">출력</a>
	<div id="output"></div>

</body>
</html>