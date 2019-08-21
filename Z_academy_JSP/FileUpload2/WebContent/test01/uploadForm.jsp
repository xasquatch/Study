<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String contextPath = request.getContextPath();

%>
</head>
<body>

	<form action="<%=contextPath%>/upload.do" method="POST" enctype="multipart/form-data">
		파일 1 : <input type="file" name = "file1"><br> 
		파일 2 : <input type="file" name = "file2"><br>
		파라미터1 : <input type="text" name = "param1"><br>
		파라미터2 : <input type="text" name = "param2"><br>
		파라미터3 : <input type="text" name = "param3"><br>
		<input type="submit" value = "업로드">
	</form>

</body>
</html>