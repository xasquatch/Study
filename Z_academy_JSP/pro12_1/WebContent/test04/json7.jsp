<!-- Iot반 고태흥 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#checkJson").on("click", function() {
			$.ajax({
				type:"POST",
				async:true,
				url:"<%=request.getContextPath()%>/json3",
				success: function(data,textStatus) {
					var jsonInfo = JSON.parse(data);
					
					var bookInfo = "회원정보<BR>==========================================<BR>";
					var tableStyle = "style='text-align: center; display: inline-block;'";
					for ( var i in jsonInfo.books) {
						bookInfo += "<table border='1' "+tableStyle+">";
						bookInfo += "<tr><th>이름</th><td>"+jsonInfo.books[i].title+"</td></tr>";
						bookInfo += "<tr><th>저자</th><td>"+jsonInfo.books[i].writer+"</td></tr>";
						bookInfo += "<tr><th>가격</th><td>"+jsonInfo.books[i].price+"</td></tr>";
						bookInfo += "<tr><th>장르</th><td>"+jsonInfo.books[i].genre+"</td></tr>";
						bookInfo += "<tr><td colspan='2'><img width=150 heigth=250 src="+jsonInfo.books[i].image+"></td></tr>";
						bookInfo += "</table>";
					}
// 					document.querySelector("#output").innerHTML = bookInfo;
					$("#output").html(bookInfo);
				},
				error: function() {window.alert("ERROR OCCURRED")}
			});
		});
	});
</script>
</head>
<body>
	<a id="checkJson" style="cursor:pointer; font-weight:bold; color:red;">데이터수신하기</a>
	<div id="output"></div>
</body>
</html>