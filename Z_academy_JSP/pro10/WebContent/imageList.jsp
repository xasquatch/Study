<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.Lst_type{
		overflow: hidden;
		width : 80%;
		padding: 0 10px 10px;
		margin: 0 auto 0 0;
	}
	.Lst_type li{
		overflow: hidden;
		clear: both;
		margin: 10px 0 0;
		color: #2d2c2d;
		font-family: '궁서체';
		line-height: 100px;
		list-style:none;
		border-bottom: 2px solid lightgray;
		position : relative;
	}
	.Lst_type li img{
		display: inline;
		float: left;
		position: absolute;
	}
	.Lst_type li a{
		color:#2d2c2d;
		text-decoration: none;
		margin-left: 340px; 
	}
	.Lst_type li a:hover {
 		text-decoration: underline; 
	}
	.Lst_type li span {
		color: blue;
		margin-left: 330px;
		font-family: '돋움';
		font-size: 14px;
	}
</style>
</head>
<body>
<!-- 	for반복문을 이용해 <ul>태그안에 <li>태그를 연속적으로 출력해서 이미지를 나타냅니다. -->
		<ul class="Lst_type">
	<%
		
	%>
<!-- 	리스트의 헤더를 표시합니다. -->
			<li>
				<span style="margin-left : 50px">이미지</span>
				<span>이미지 이름</span>
				<span>선택하기</span>
			</li>
	<%
		for(int i = 0; i< 10; i++){
	%>
			<li>
				<a href="#" style="margin-left:50px"><img src="image/duke.png" width="90" height="90"></a>
				<a href="#"><strong>이미지이름 : 듀크<%=i %></strong></a>
				<a href="#"><input type="checkbox" name="chk<%=i%>"></a>
			</li>
	<%
		}
	%>
		</ul>
</body>
</html>