<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/main.css"/>
<script type="text/javascript" src="../js/jquery-3.1.1.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	var id_Check = false;
	var pass_Check = false;
	var email_Check = false;

	$(function() {
		$(".genderBtn[for='male']").css("background-color", "#ddd");
		$(".genderBtn").on("click", function() {
			$(".genderBtn").css("background-color", "#fff");
			$(this).css("background-color", "#ddd");
		});
	});
	
	//우편번호 api
	function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('address').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('address2').focus();
            }
        }).open();
    }
	
	function sendEmail() {
		var width = 430;
		var height = 200;
		var winL = (screen.width - width) / 2;
		var winT = (screen.height - height) / 2;
		var property = "width=" + width + "," + "height=" + height + "," 
						+ "left=" + winL + "," + "top=" + winT + " menubar=no";
		
		email_Check = false;
		window.open("authMail.jsp?to=" + email.value, "인증 페이지", property);
	}
	
	function checkPass() {
		if($("#pass").val() != "") {
			if($("#pass").val() != $("#pass2").val()) {
				$("#passCheck").css("color", "red");
				$("#passCheck").text("비밀번호가 다릅니다.");
				pass_Check = false;
			} else {
				$("#passCheck").css("color", "green");
				$("#passCheck").text("비밀번호가 동일합니다.");
				pass_Check = true;
			}
		} else {
			$("#passCheck").html("&nbsp;");
		}
	}
	
	function checkId() {
		if(!isAcceptableId($("#id").val())) {
			$("#idCheck").css("color", "red");
			$("#idCheck").text("3~15글자 사이의 소문자영어, 숫자만 입력 가능합니다.");
			id_Check = false;
			return;
		}
		
		$.ajax({
			type: "get",
			url: "id_dup_check.jsp",
			data: ({id: $("#id").val()}),
			success: function(data) {
				if(jQuery.trim(data) == "false") {
					$("#idCheck").css("color", "green");
					$("#idCheck").text("사용가능한 아이디입니다.");
					id_Check = true;
				} else {
					$("#idCheck").css("color", "red");
					$("#idCheck").text("이미 사용중인 아이디입니다.");
					id_Check = false;
				}
			}
		});
	}
	
	function isAcceptableId(input) {
		if(input == "") {
			return false;
		}
		
		if(input.length < 3 || input.length > 15) {
			return false;
		}
		
		for(var i = 0; i < input.length; i++) {
			if(input.charAt(i) < '0' || input.charAt(i) > '9') {
				if(input.charAt(i) < 'a' || input.charAt(i) > 'z') {
					return false;
				}
			}
		}
		return true;
	}
	
	function checkForm() {
		if(!id_Check) {
			alert("아이디가 옳바르지 않거나 이미 사용중입니다.");
			$("#id").focus();
			return false;
		}
		
		if(!pass_Check) {
			alert("비밀번호가 동일하지 않습니다.");
			$("#pass").focus();
			return false;
		}
		
		if(!email_Check) {
			alert("이메일 인증이 완료되지 않았습니다. 이메일 인증후 다시 시도해주세요.");
			$("#email").focus();
			return false;
		}
		
		var dt = new Date();
		if(Number($("#year").val()) < dt.getFullYear() - 200 || Number($("#year").val()) > dt.getFullYear()) {
			alert("생년월일을 올바르게 입력하지 않았습니다.");
			$("#year").focus();
			return false;
		}
		if(Number($("#day").val()) < 1 || Number($("#day").val()) > 31) {
			alert("생년월일을 올바르게 입력하지 않았습니다.");
			$("#day").focus();
			return false;
		}
		if(month.selectedIndex == 0) {
			alert("생년월일을 올바르게 입력하지 않았습니다.");
			$("#month").focus();
			return false;
		}
		
		return true;
	}
</script>
<title>회원가입</title>
</head>
<body id="reg_body">
	<div id="reg_wrap">
<!-- 		<h1>Register Form</h1> -->
		<a href="../index.jsp"><img src="../images/new_logo.png" id="reg_logo"/></a>
		<form action="registerProc.jsp" method="post" id="reg_form" onsubmit="return checkForm();">
			<h3>Hbay 무료 회원가입</h3>
			<label for="id">아이디</label>
				<input type="text" name="id" id="id" onblur="checkId();" required/>
				<span id="idCheck" class="check_status">&nbsp;</span>
			<label for="pass">비밀번호</label>
				<input type="password" name="pass" id="pass" onkeyup="checkPass();" required/>
			<label for="pass2">비밀번호 재확인</label>
				<input type="password" name="pass2" id="pass2" onkeyup="checkPass();" required/>
				<span id="passCheck" class="check_status">&nbsp;</span>
			<label for="mem_name">이름</label>
				<input type="text" name="mem_name" id="mem_name" required/>
			<label for="male">성별</label>
				<div id="Jgender">
					<input type="radio" name="gender" id="male" value="M" checked/>
					<label for="male" class="genderBtn">남자</label>
					<input type="radio" name="gender" id="female" value="F"/>
					<label for="female" class="genderBtn">여자</label>
				</div>
			<label for="year">생년월일</label>
			<div id="birth">
				<input type="text" name="year" id="year" placeholder="년" required/>
				<span class="divider"></span>
				<select name="month" id="month">
					<option value="mon">월</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
				</select>
				<span class="divider"></span>
				<input type="text" name="day" id="day" placeholder="일" required/>
			</div>
			<label for="postcode">주소</label>
				<input type="text" name="postcode" id="postcode" placeholder="우편번호" class="textWithBtn" required>
				<input type="button" onclick="execDaumPostcode()" value="찾기" class="btn"><br>
				<input type="text" name="address" id="address" placeholder="주소" required readonly>
				<input type="text" name="address2" id="address2" placeholder="상세주소" required>
			<label for="email">이메일</label>
				<input type="email" name="email" id="email" class="textWithBtn" required/>
				<input type="button" class="btn" value="인증 요청" onclick="sendEmail();"/>
				<span id="emailCheck" class="check_status">&nbsp;</span>
			<input type="submit" id="regBtn" value="회원가입"/>
		</form>
	</div>
</body>
</html>