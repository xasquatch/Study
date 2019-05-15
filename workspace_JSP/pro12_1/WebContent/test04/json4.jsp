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
			//
			var jsonStr = '{"members":[{"name":"박지성","age":"25","gender":"남자","nickname":"날썐돌이"},'
									 +'{"name":"손흥민","age":"30","gender":"남자","nickname":"탱크"}'
									 +']}';
			var jsonInfo = JSON.parse(jsonStr);
			var output = "회원정보 <BR>";
			output += "==========================<BR>";
			for ( var i in jsonInfo.members) {
				// 각 배열 요소에 접근하여 객체의 name으로 value를 출력합니다.
				output += "이름: "+jsonInfo.members[i].name+"<br>";
				output += "나이: "+jsonInfo.members[i].age+"<br>";
				output += "성별: "+jsonInfo.members[i].gender+"<br>";
				output += "별명: "+jsonInfo.members[i].nickname+"<br>";
			}
			
			$("#output").html(output);
			
		})
	});

</script>
</head>
<body>
	<a id="checkJson" style="cursor:pointer;">출력</a>
	<div id="output"></div>

</body>
</html>