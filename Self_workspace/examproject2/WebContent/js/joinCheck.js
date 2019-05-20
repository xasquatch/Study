// 회원가입 input태그 클릭 함수
(function($) {
	$(function() {
	    $('.input-label').keypress(function(){
	        $(this).trigger('focusin');
	    });
	    $('.input-label').each(function() {
	        if($(this).val().length) {
	            $(this).trigger('focusin');
	        }
	    });
	    
		$('.input-label').focusin(function(){
			$(this).css({'opacity':1, filter: 'alpha(enabled="false")'});
		});
		$('.input-label').focusout(function(){
			if(!$(this).val()) {
				$(this).animate({'opacity':0}, 500);
			} else {
				$(this).css({'opacity':1});
			}
		});
	});
})(jQuery);

// 회원가입 유효성 검사
function send(){
	// 이름 입력여부 검사
	if(document.f.hname.value==""){
		 alert("이름을 입력하지 않았습니다.");
		 return
	}
	// 이름 영문, 숫자 입력불가
	for (i=0;i<document.f.hname.value.length ;i++ ){
		 ch=document.f.hname.value.charAt(i);
		 if (!(ch>='가' && ch<='힣')){
		 alert ("이름은 한글만 입력가능합니다.");
		 document.f.hname.select();
		 return
	 }
	}
	// 아이디 입력여부 검사
	if(document.f.id.value==""){
		 alert("아이디를 입력하지 않았습니다.");
		 return
	}
	// 아이디 소문자, 숫자만 허용
	for (i=0;i<document.f.id.value.length ;i++ ){
		 ch=document.f.id.value.charAt(i);
		 if (!(ch>='0' && ch<='9') && !(ch>='a' && ch<='z')){
		 alert ("아이디는 소문자, 숫자만 입력가능합니다.");
		 document.f.id.select();
		 return
	 }
	}
	// 아이디 길이 체크 (6~12자)
	if (document.f.id.value.length<6 || document.f.id.value.length>12){
		alert ("아이디를 6~12자까지 입력해주세요.");
		document.f.id.select();
		return
	}
	// 비밀번호 입력여부 체크
	if(document.f.password1.value==""){
		alert("비밀번호를 입력하지 않았습니다.");
		return
	}
	// 비밀번호 길이 체크(4~8자까지 허용)
	if (document.f.password1.value.length<4 || document.f.password1.value.length>8){
		 alert ("비밀번호를 4~8자까지 입력해주세요.")
		 document.f.password1.select();
		 return
	}
	// 비밀번호와 비밀번호 확인 일치여부 체크
	if (document.f.password1.value!=document.f.password2.value){
		 alert("비밀번호가 일치하지 않습니다")
		 document.f.password1.value="";
		 document.f.password2.value="";
	 	 return
	}
	// 이메일 입력여부 체크
	if(document.f.email.value==""){
		alert("이메일을 입력하지 않았습니다.");
		return
	}
	
	var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	if(exptext.test(document.f.email.value)==false){
		// 이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐 경우
		alert("이메일 형식이 올바르지 않습니다.");
		document.f.email.focus();
		exit;
	}
	
	// 폰번호 입력여부 체크
	if(document.f.etcphone.value==""){
		alert("휴대폰번호를 입력하지 않았습니다.");
		return
	}
	// 주소 입력여부 체크
	if(document.f.sample6_postcode.value==""){
		alert("주소를 입력하지 않았습니다.");
		return
	}
	 
	document.f.submit();
}

//아이디 중복 검사
function id_btn(){
	var id = document.f.id.value;
 	if(id =="") {
 		alert("아이디를 입력해주세요.");
 		document.f.id.focus();
 	} else {
 		// 아이디 길이 체크 (6~12자)
 		if (id.length<6 || id.length>12){
 			alert ("아이디를 6~12자까지 입력해주세요.");
 			document.f.id.select();
 			return
 		}else
 			window.open("join_id.jsp?userid="+id, "ID_Check", "width=390, height=170, top=250, left=800");
 		
 	}
}