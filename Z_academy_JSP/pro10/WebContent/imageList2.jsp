<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
.lst_type {
	overflow: hidden;
	width: 80%;
	padding: 0 10px 10px;
	margin: 0 auto
}

.lst_type li {
	overflow: hidden;
	clear: both;
	margin: 10px 0 0;
	color: #2d2c2d;
	font-family: '돋움', Dotum;
	font-size: 12px;
	line-height: 100px;
	list-style: none;
	border-bottom: 2px solid lightgray;
	position: relative;
}

.lst_type li img {
	display: inline;
	float: left;
	position: absolute;
}

.lst_type li a {
	color: #2d2c2d;
	text-decoration: none;
	margin-left: 340px
}

.lst_type li a:hover {
	text-decoration: underline
}

.lst_type li span {
	color: blue;
	margin-left: 330px;
	font-family: '돋움', Dotum;
	font-size: 14px;
}
</style>

</head>
<body>
	<%-- for반복문을 이용해 <ul>태그안에 <li>태그를 연속적으로 출력해서 이미지를 나타냅니다. --%>
	<ul class="lst_type">
		<!-- 리스트의 헤더를 표시 합니다. -->
		<li><span style="margin-left: 50px">이미지</span> <span>이미지
				이름</span> <span>선택하기</span></li>
		<%
			for (int i = 0; i < 10; i++) { //for반복문을 이용해 <li>태그를 연속해서 출력 합니다.
		%>
		<li><a href="#" style="margin-left: 50px"> <img
				src="image/duke.png" width="90" height="90">
		</a> <a href="#"> <strong>이미지 이름 : 듀크<%=i%></strong>
		</a> <a href="#"> <input type="checkbox" name="chk<%=i%>">
		</a></li>
		<%
			}
		%>

	</ul>



</body>
</html>








