<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>표현언어의 여러가지 연산자들</title>
</head>
<body>
	
	<h2>표현언어 (EL태그)를 사용하여 비교연산자로 연산한 결과값 출력</h2>
		<!-- 
		표현언어에서 비교연산자 사용방법
		
		1. 값이 같은지 비교할 떄는 == 또는 eq연산자를 사용합니다.
		2. 값이 같지 않은지 비교할 때 !=또는 ne연산자를 사용합니다.
		3. 대소 비교 시 >와 <연산자 그리고 gt와 lt도 각각 연산자로 사용할 수 있습니다.
		4. 대소 및 동등 비교를 동시에 할 때는 >=와 <= 연산자 그리고 ge와 le도 각각 연산자로 사용할 수 있음.
		
		 -->
	<hr>
	<table>
		<tr>
			<th>
				<h1 id="h1">
					
				</h1>
			</th>
			<td bgcolor = "gray">
			</td>
			<td>
				<h1 id="h2">
					${10 == 10}<br>
					${10 eq 10}<br>
					${"hello" == "hello"}<br>
					${"hello" eq "hello"}<br>
					${20 != 10}<br>
					${20 ne 10}<br>
					${"hello" != "apple"}<br>
					${"hello" ne "apple"}<br>
					${10 < 10}<br>
					${10 lt 10}<br>
					${100 > 10}<br>
					${100 gt 10}<br>
					${100 >= 10}<br>
					${100 ge 10}<br>
				</h1>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		document.querySelector("#h1").innerHTML = document.querySelector('#h2').innerText; 
	</script>
</body>
</html>