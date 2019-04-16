<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	//scoreTest.html로부터 요청받은 점수를 request객체 영역에서 꺼내오기
	int score = Integer.parseInt(request.getParameter("score"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		시험점수
		<%=score%>점
	</h1>
	<BR>
	<%
		if (score >= 90) {
	%>
	<h1>A학점입니다.</h1>
	<%
		} else if (score >= 80) {
	%>
	<h1>B학점입니다.</h1>
	<%
		} else if (score >= 70) {
	%>
	<h1>C학점입니다.</h1>
	<%
		} else {
	%>
	<h1>F학점입니다.</h1>
	<%
		}
	%>
	<br>
	<a href="scoreTest.html">시험점수 입력</a>

</body>
</html>