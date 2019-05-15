<%--자바스크립트에서 회원정보를 JSON객체로 만들어 매개변수를 이름 jsonInfo로	ajax통신을 이용해 서블릿으로 전송함 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#checkJson").click(function() {
			//전송할 회원정보로 JSON 데이터 형식의 문자열로 만들어서 변수에 저장
			
			$.ajax({
				type : "POST",
				url : "<%=request.getContextPath()%>/json2",
				
				success: function(data,textStatus) {
					//서버(JsonServlet2.java)에서 응답한 data변수의 값은
					//JSON객체 배열 데이터 형태의 문자열이다.
					
					//parse(data)메소드를 호출하면
					//JSON객체배열 데이터 형태의 문자열을 파싱해서 JSONObject객체로 변환한다.
					//참고 : JSONObject객체 내부를 살펴보면 HASHMAP구조로 인덱스 위치에
					//		key와 value값을 쌍으로 저장하고 있다
					var jsonInfo = JSON.parse(data);
					
					var memberInfo = "회원정보<BR>";
					memberInfo += "================<BR>";
					for ( var i in jsonInfo.members) {
						memberInfo += "이름 : "+jsonInfo.members[i].name +"<br>";
						memberInfo += "나이 : "+jsonInfo.members[i].age +"<br>";
						memberInfo += "성별 : "+jsonInfo.members[i].gender +"<br>";
						memberInfo += "별명 : "+jsonInfo.members[i].nickname +"<br>"+"<br>"+"<br>";
					}
					document.querySelector("#output").innerHTML = memberInfo;
					
				},
				error: function(data,textStatus) {alert("에러발생")},
				complete: function(data,textStatus) {}
			});//end - $.ajax()
			
		});
	});
	
</script>
</head>
<body>
	<a id="checkJson" style="cursor:pointer;">출력</a>
	<div id="output"></div>

</body>
</html>