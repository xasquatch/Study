<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	function checkz() {
			var getIntro = $("#intro").val().replace(/\s|/gi, '');
			var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
			var getCheck = RegExp(/^[a-zA-Z0-9]{4,12}$/);
			var getName = RegExp(/^[가-힣]+$/);
			var fmt = RegExp(/^\d{6}[1234]\d{6}$/); //형식 설정
			var buf = new Array(13); //주민등록번호 배열


			//이름의 유효성 검사
			if (!getCheck.test($("#id").val())) {
				alert("형식에 맞게 입력해주세요");
				$("#id").val("");
				$("#id").focus();
				return false;
			}

			//비밀번호
			if (!getCheck.test($("#passwd").val())) {
				alert("형식에 맞춰서 PW를 입력해줘용");
				$("#passwd").val("");
				$("#passwd").focus();
				return false;
			}

			//아이디랑 비밀번호랑 같은지
			if ($("#id").val() == ($("#passwd").val())) {
				alert("비밀번호가 ID와 똑같으면 안!대!");
				$("#passwd").val("");
				$("#passwd").focus();
			}

			//비밀번호 똑같은지
			if ($("#passwd").val() != ($("#passwd2").val())) {
				alert("비밀번호가 틀렸네용.");
				$("#passwd").val("");
				$("#passwd2").val("");
				$("#passwd").focus();
				return false;
			}

			//이메일 공백 확인
			if ($("#email").val() == "") {
				alert("이메일을 입력해주세요");
				$("#email").focus();
				return false;
			}

			//이메일 유효성 검사
			if (!getMail.test($("#email").val())) {
				alert("이메일형식에 맞게 입력해주세요")
				$("#email").val("");
				$("#email").focus();
				return false;
			}

			//이름 유효성
			if (!getName.test($("#name").val())) {
				alert("이름 똑띠 쓰세용");
				$("#name").val("");
				$("#name").focus();
				return false;
			}

</style>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>

</body>
</html>