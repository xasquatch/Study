<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(function() {
		$("#checkJson").on("click", function() {
		var jsonStr= '{"age":[22,33,44,55,66]}';
		var jsonInfo = JSON.parse(jsonStr);
		var output = "회원나이<br>";
		output += "----------<br>";
		//배열요소[나이]를 차례대로 출력합니다
		for ( var i in jsonInfo.age) {
			output += jsonInfo.age[i]+"<BR>";
			
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