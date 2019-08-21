<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>표현언어의 여러가지 연산자들</title>
</head>
<body>
	<script type="text/javascript">
		document.querySelector("#h1").html() = document.querySelector("#h1").value(); 
	</script>
	
	<h2>여러가지 산술연산자</h2>
	<table>
	<th>
		<h1 id="h1">
		</h1>
	</th>
	<td>
		<h1 id="h2">
			${10+10}<br>
			${20-10}<br>
			${10*10}<br>
			<!-- div를 사용해 나누기 연산을 하여 EL태그로 출력 -->
			${100 div 9 }<br>
			${100 % 9 }<br>
			${100 mod 9 }<br>
			
		</h1>
	</td>
	</table>
</body>
</html>