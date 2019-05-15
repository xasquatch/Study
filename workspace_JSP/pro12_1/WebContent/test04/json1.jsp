<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 제이쿼리를 사용하기 위해 반드시 설정 해줄 CDN링크 -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#checkJson").click(function() {
			//JSON객체는 중괄호{}로 둘러싸서 표현
			//{}중괄호안의 실제값은 name:value를 쌍으로 나열합니다.
			//"name" ->배열이름
			//["홍길동","이순신","임꺽정"] -> 배열
			var jsonStr = '{ "name" : ["홍길동","이순신","임꺽정"] }';
			
			//JSON.parse()메소드
			//- parse()메소드는 String객체를 JSON객체로 변환시켜 줌
			var jsonInfo = JSON.parse(jsonStr);
						
			//JSON.stringify()메소드
			//- stringify()메소드는 JSON객체를 String객체로 변환시켜줌
// 			var s = JSON.stringify(jsonInfo);
			
			var output = "회원이름<BR>";
			output += "================<br>";
			//배열이름 name으로 배열의 인덱스위치에 차례대로 접근하여 value값을 가져옴
			for (var i in jsonInfo.name) {
				output += jsonInfo.name[i] + "<BR>";
				
			};
			//id속성값이 output인 <div>태그영역에 회원이름을 출력합니다.
// 			$("#output").html(output);
			document.querySelector("#output").innerHTML += output;
		});
	});
	
</script>
</head>
<body>
	<a id="checkJson" style="cursor:pointer;">출력</a>
	<div id="output"></div>
</body>
</html>