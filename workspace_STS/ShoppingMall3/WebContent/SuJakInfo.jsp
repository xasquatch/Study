<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script type="text/javascript">
		//아래의 카드담기 버튼을 눌렀을때 호출되는 메소드
		function cart() {
		 //<input type="hidden">태그의 value값을 각각 얻어 변수에 저장
		 var qtyid = document.getElementById("qtyid").value;
		 var sunoid = document.getElementById("sunoid").value;
		 var suimgid = document.getElementById("suimgid").value;
		 var supriceid = document.getElementById("supriceid").value;
		 var sunameid = document.getElementById("sunameid").value;
		 //하나의 주소를 만들어 해당하는 카트담기 요청(sutoolcart.do)
		 var url = "sutoolcart.do?suno=" + sunoid + "&suimg=" + suimgid + 
				   "&suprice=" + supriceid + "&suname=" + sunameid + 
				   "&suqty=" + qtyid;
		 //자바스크립트의 페이지 요청기술
		 location.href=url;
		 
		 
		}
	
	</script>

</head>
<body bgcolor="white">
	<center>
		<h2><font color="yellow">수작업 공구 구매</font></h2>
		<!-- 구매하기 버튼을 눌렀을떄 구매요청! -->
		<form action="sutoolbuy.do" method="post">
			<table width="800" align="center" border="0">
				<tr align="center">
					<td rowspan="4" width="300">
						<img src="img/${sbean.suimg}" width="300">
					</td>
					<td align="center" width="100">
						<font size="2" color="white">공구 이름</font>
					</td>
					<td align="center" width="150">
						<font size="2" color="white">${sbean.suname}</font>
					</td>
				</tr>
				<tr>
					<td align="center">
						<font size="2" color="white">구매 수량</font>
					</td>
					<td align="center">
						<select name="suqty" id="qtyid">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</td>
				</tr>
				<tr align="center">
					<td align="center" width="100">
						<font size="2" color="white">판매금액</font> 
					</td>
					<td align="center" width="150">
						<font size="2" color="white">${sbean.suprice}원</font> 
					</td>								
				</tr>
				<tr align="center">
					<td align="center" colspan="2">
						<input type="button" 
						       value="목록보기" 
						       onclick="location.href='sujak.do'">
						<input type="button"
							   value="카드담기"
							   onclick="cart()">
						<input type="submit" value="구매하기">
					</td>
				</tr>
			</table>
			
<!-- 카트담기 또는 구매하기 버튼을 눌렀을때..<input type="hidden">태그로 값전달 -->
<input type="hidden" name="suno" id="sunoid" value="${sbean.suno}">
<input type="hidden" name="suimg" id="suimgid" value="${sbean.suimg}">
<input type="hidden" name="suprice" id="supriceid" value="${sbean.suprice}">
<input type="hidden" name="suname" id="sunameid" value="${sbean.suname}">
			
		</form>
		<p>
			<hr color="yellow">
			<font size="2" color="white">
				<b>상품 상세보기</b>
				<p>${sbean.suinfo}</p>
			</font>
		</p>
	</center>
</body>
</html>



