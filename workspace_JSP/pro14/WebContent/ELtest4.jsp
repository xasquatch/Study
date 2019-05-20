<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>표현언어의 여러가지 연산자들</title>
</head>
<body>
	
	<h2>논리 연산자를 이용하여 연산자 결과를 EL태그로 출력</h2>
		<!-- 
		표현언어에서 논리연산자 사용방법
		
		1. 	&&연산자나 and연산자는 논리곱 연산을 합니다.
		2.	||연산자나 or연산자는 논리합 연산을 합니다.
		3.	!연산자나 not연산자는 반대의 결과를 출력합니다.  
			
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
					${(10 == 10)&&(20 == 20)}<BR>
					${(10 == 10)and(20 == 20)}<BR>
					
					${(10 == 10)||(20 == 30)}<BR>
					${(10 == 10)or(20 == 30)}<BR>
					
					${!(20 != 10)}<BR>
					${not(20 != 10)}<BR>
					
					
				</h1>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		document.querySelector("#h1").innerText = document.querySelector('#h2').innerText; 
	</script>
</body>
</html>