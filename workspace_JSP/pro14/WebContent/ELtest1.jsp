<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>표현언어{EL태그}에서 사용되는 데이터들</title>
</head>
<body>
	<h1>표현언어로 여러가지 데이터 출력하기</h1>
	<h1>
		\${100} : ${100}<BR>
		\${hi} : ${"hi"}<BR>
		\${10+1} : ${10+1}<BR>
		<!-- 숫자형 문자열과 실제 숫자를 더하면 문자열을 자동으로 숫자로 변환하여 더함 -->
		\${"10"+1} : ${"10"+1}<BR>
		
		<!-- null과 10을 더하면 10이 됩니다. -->
		\${null+10} : ${null+10}<BR>
		
		<!-- 문자열(숫자형 문자열 제외)과 숫자를 더할 수 없습니다. -->
		<%-- \${"안녕"+11 } : ${"안녕"+11}<BR> --%>
		
		<!-- 문자열(숫자형 문자열 제외)과 문자열도 더할 수 없습니다. -->
		<%-- \${"hello" +"wolrd"} : ${"hello" +"wolrd"}<br> --%>
		
		
		
		 
	</h1>

</body>
</html>