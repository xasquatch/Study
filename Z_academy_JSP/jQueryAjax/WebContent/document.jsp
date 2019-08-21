<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	//웹브라우저가 document.jsp페이지의 소스코드를 모두 로딩했을 때
	$(function() {
		$.ajax({
			url : 'document.xml', //요청URL,  document.xml파일을 비동기 방식으로 읽어올 대상으로 설정
			type : 'GET',
			timeout : 1000, //통신에러 최대대기시간을 1초로 설정
			
			//에러시 처리할 콜백함수 정의, 간단히 에러메시지를 경고창으로 띄움
			error : function() {alert("ERROR");},
			
			success : function(xml) {//요청에 성공했을 때 , 응답데이터를 xml변수로 전달받기
				
				$(xml).find("cat").each(function() {
					var item_text = $(this).text();
					alert(item_text);
				});
				
			}
		});
	})

</script>
</head>
<body>

</body>
</html>