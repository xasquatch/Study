<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id="bean" class="sec01.ex01.MemberBean" scope="page"></jsp:useBean>
<!-- 생성한 memberbean객체에 name속성에 값을 설정합니다. -->
<jsp:setProperty property="name" name="bean" value="이순신"/>

<!-- usebean액션태그를 이용한 ArrayList클래스에 대한 객체 생성 -->
<jsp:useBean id="list" class="java.util.ArrayList" scope="page"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<h1>empty연산자</h1>
	<hr>
	<h2>
		<!-- 변수 bean의 name속성에 값이 설정되어 있으므로 false를 반환-->
		${bean.name}<BR>
		${empty bean}<BR>
		${not empty bean}<BR> <!-- TRUE 반환 -->
		
		<HR>
		
		<!-- ArrayList객체인 list는 비어있으므로 true를 반환 -->
		${list}<br>
		${empty list}<br>
		${not empty list}<br>
		
		<hr>
		
		<!-- 문자열에 대해 false를 반환 -->
		${"hello!"}<br>
		${empty "hello!"}<br>
		${empty null}<br> <!-- null은 true를 반환 -->
		${empty "" }<br> <!-- 빈 문자열은 true를 반환 -->
	</h2>
		<!-- 
			empty 연산자는 자바빈의 속성이 값으로 설정되었는지 또는 list, map같은 저장객체에 값이 존재하는지를 판단하는 연산자 입니다.
		 -->
	
</body>
</html>