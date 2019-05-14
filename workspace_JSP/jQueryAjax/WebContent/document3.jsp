<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#btn").click(function() {
		
		$.ajax({
				url:'test.js',
				type:'post',
				dataType:'json',
				success : function(obj) {
					alert(obj[0].name + "\n" + obj[0].tel);
				}
				
				});
		
	});

})
</script>
</head>
<body>
	<input type="button" id="btn" value="BUTTON">
</body>
</html>

