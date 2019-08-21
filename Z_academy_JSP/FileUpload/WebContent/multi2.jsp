<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>하고싶은 말</title>
<script type="text/javascript">
	function addInput() {
		//추가할 파일 수 값 가져오기
		var filecnt = document.f.add.value;
		//div태그 위치 주소 가져오기
		var div = document.getElementById("inputDIv");
			//추가할 파일 수 만큼 반복하여 <input type="file">태그를 생성하여
			//div태그영역에 추가
		for (i = 0; i < filecnt; i++) {
			var msg = "<input type='file' name='Upfile"+i+"'/><BR>";
			//div영역안에 위의 <input type="file">을 누적
			div.innerHTML += msg;
		}
	}

	function fnElementCheck(f) {
		var cnt = f.elements.length;
		var filecnt = 1;
		for(i=0;i<=cnt;i++){
			if(f.elements[i].type == "file"){
				if(f.elements[i].value == ""){
					var msg = filecnt + "번째 파일 정보가 누락되었습니다 \n 올바른 입력을 해주세요"
					
					alert(msg);
					f.focus();
				return;
				}
			}
			filecnt++;
		}
		f.submit();
	}
</script>
</head>
<body>
	<h2>다중 파일 업로드</h2>
	<form action="multi_pro.jsp" method="POST" enctype="multipart/form-data" name="f">
		이름 : <input type="text" name="name"><br>
		주소 : <input type="text" name="addr"><br>
		하고싶은 말: <br>
		<textarea rows="3" cols="70" name = "note"></textarea><br>
		추가할 파일 수 : <input type="text" name="add" size="2">
		<input type="button" value="파일 선택 추가" onclick="addInput();"><br>
		
		<div id="inputDIv"></div>
	
		<input type="button" value="업로드" onclick="fnElementCheck(this.form)">
	</form>

</body>
</html>