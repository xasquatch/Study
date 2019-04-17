<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학번, 이름, 학년, 선택과목을 입력하는 양식</h1>
	<form action="requestTestPro.jsp" method="POST">
		학번 : <input type="text" name="num"><BR>
		이름 : <input type="text" name="name"><BR>
		학년 : 
			<input type="radio" name="grade" value="1" checked="checked">&nbsp;1학년
			<input type="radio" name="grade" value="2">&nbsp;2학년
			<input type="radio" name="grade" value="3">&nbsp;3학년
			<input type="radio" name="grade" value="4">&nbsp;4학년
			<BR>
		과목 : <select name="subject">
				<option value="JAVA">JAVA</option>
				<option value="JSP">JSP</option>
				<option value="XML">XML</option>
			 </select>
			 <BR>
			 <input type="submit" value="입력">
	</form>
</body>
</html>