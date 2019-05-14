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
				url:'ak.jsp',
				type:'post',
				data:'input_id='+$("#input_id").val()+ '&' +'input_name='+$("#input_name").val(),
				timeout:1000,
				error: function() {alert("ERROR")},
				success: function(msg) {
					var str = msg+"";
					$('input[type^=text]').attr('value','');
					$("#div_tab").html(str);
				}
			});
		});
	});
</script>
</head>
<body>
	<input type="text" id="input_id" value="">
	<input type="text" id="input_name" value="">
	<input type="button" id="btn" value="BUTTON">
	
	<div id="div_tab"></div>
</body>
</html>

