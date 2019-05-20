/* 주문 유효성 검사 */
function orderCheck(){
	// 이름 입력여부 검사
	if(document.f.hname.value==""){
		 alert("이름을 입력하지 않았습니다.");
		 return false;
	}
	// 이름 유효성 검사 (영문소문자, 숫자 입력불가)
	for (i=0;i<document.f.hname.value.length ;i++ ){
		 ch=document.f.hname.value.charAt(i);
		 if (!(ch>='가' && ch<='힣')){
		 alert ("이름은 한글만 입력가능합니다.");
		 document.f.hname.select();
		 return false;
	 }
	}
	// 폰번호 입력여부 체크
	if(document.f.etcphone.value==""){
		alert("휴대폰번호를 입력하지 않았습니다.");
		return false;
	}
	// 주소 입력여부 체크
	if(document.f.sample6_postcode.value==""){
		alert("주소를 입력하지 않았습니다.");
		return false;
	}
	// 상세주소 입력여부 체크
	if(document.f.sample6_address2.value==""){
		alert("상세주소를 입력하지 않았습니다.");
		return false;
	}
	
	document.f.submit();
}