/*
Register.html 값들이 유효한지 확인함
- 이름: 2자~5자
 - ID: 3자~8자
 - 비밀번호 : 8자~12자, 초기화
 - 비밀번호 확인
 - 주민번호 앞자리 6자리
 - 주민번호 뒷자리 7자리
 */

 // 가입 버튼 눌렀을때 Register.html 값들이 유효한지 확인 하기 위한 CheckForm()함수 만들기
function CheckForm() {
	//이름을 입력 할수 있는 <input>태그 선택해서 uName변수에 저장
		var uName = register.document.getElementById('uName').value;
	//ID를 입력 할수 있는 <input>태그를 선택하여 uID변수에 저장
		var uID = register.document.getElementById('uID').value;
	//비밀번호를 입력 할수 있는 <input>태그를 선택하여 uPWD변수에 저장
		var uPWD = register.document.getElementById('uPWD').value;
	//비밀번호 확인 을 입력 할수 있는 <input>태그를 선택하여 uPWD_Confirm변수에 저장
		var uPWD_confirm = register.document.getElementById('uPWD_confirm').value;
	//주민번호 앞자리를 입력할수 있는 <input>태그를 선택하여 uBirth변수에 저장
		var uBirth = register.document.getElementById('uBirth').value;
	//주민번호 뒷자리를 입력할수 있는 <input>태그를 선택하여 uBirth_2변수에 저장
		var uBirth_2 = register.document.getElementById('uBirth_2').value;
	//직업을 선택 할수 있는  select 태그를 선택하여 work변수에 저장
		var work = register.document.getElementById('work').value;
	//가입 동기 입력란 을 선택하여 motivation변수에 저장
		var motivation = register.document.getElementById('motivation').value;
	//성별 라디오 버튼을 선택하여 sex변수에 저장
		var sex = register.document.getElementById('sex').value;
	//취미 체크박스들을 선택하여 hobby변수에 저장 
		var hobby = register.document.getElementById('h1').value;

	//이름을 2자 미만 또는 5자보다 초과 작성 했을 경우  
		//"이름은 2자~5자 이내로 작성하시오" <-경고메세지창
		// 이름 입력란이 선택이 되도록 하기
		// return false
	
	//아이디를 입력 하지 않았을 경우 
		//"아이디를 입력해주세요." <-경고메세지창
		// 아이디 입력란에 포커스 주기
		// return false
	
	//비밀번호를 8자 미만 또는 12자 보다 초과로 작성 했을 경우
		//"비밀번호는 8자~12자 이내입니다." <-경고메세지창
		//비밀번호 입력란에 빈공백 ""주기
		// return false
	

	//비밀번호 값과 비밀번호확인 값이 다를 경우 
		//"비밀번호 값이 다릅니다."  <-경고메세지창
		//비밀번호 확인 란에 빈공백 주기
		// return false
	

	// 입력한 주민번호 앞자리와 뒷자리를 CheckRRN()함수의 인자로 전달하여
	// 올바른 주민번호를 입력 하지 않았을 경우  false값을 리턴 
	if (CheckRRN(uBirth, uBirth_2) == false) {
		return false;
	}
	
	//가입 동기를 입력하지 않았을 경우
		//"가입인사를 적어주세요~" <-경고메세지창
		//return false;

	//성별을 선택 하지 않았을 경우
		//"성별을 체크해주세요." <-경고메세지창
		//return false;
	
	//취미를 체크 하지 않았을 경우 
		//"취미를 체크해주세요." <-경고메세지창
		//return false;
	
	
	//직업을 체크 하지 않았을 경우
	if (work.options.selectedIndex == 0) {
		alert("직업을 체크해주세요.");
		return false;
	}

}

//올바른 주민번호를 입력 하지 않았을 경우  false값을 리턴 하는 CheckRRN메소드 만들기 
function CheckRRN(num1, num2) { //입력한 주민번호 앞자리와 뒷자리를 전달받아

	/*
	 * 주민번호 예외처리 (주민번호 앞번호: YYMMDD) 1. 
	 * 앞번호 6자리, 뒷번호 7자리 아닌 경우 2. 
	 * MM이 1월~12월 외의 값인 경우 3. 
	 * DD이 1일~31월 외의 값인 경우 4. 
	 * 국내기준 : 뒷번호 시작이 1~4 외의 값인 경우
	 */
	//예를 들어 입력한  주민번호의 앞자리 880214중에 02문자열만 잘라내어 mm변수에 저장
	
	//예를 들어 입력한  주민번호의 앞자리 880214중에 14문자열만 잘라내어 dd변수에 저장
	
	//예를 들어 입력한 주민번호의 뒷자리 1234567 중에 1문자열만 잘라내어 sex변수에 저장

	
	//올바른 주민 등록번호 형식인지 유효성 체크하자
	//만약 입력한 주민 번호의 앞자리 개수가 6자가 아니거나,
	//    입력한 주민 번호의 뒷자리 개수가7자가 아니거나,
	//    mm변수에 저장된 값이 1미만 이거나 12초과 이고,
	//    dd변수에 저장된 값이 1미만 이거나 31초과 이고,
	//	  sex변수에 저장된 값이  1미만 이거나 4초과 라면?
		 //"올바른 주민등록번호 형식이 아닙니다." <-경고 메세지 창 띄우기
		 //주민번호 앞자리 입력란에 포커스 주기
		// return false;
	

}


//취미 체크 여부 확인 함수 CheckValue()만들기  //주석달기!!!!!!!
function CheckValue(obj) {// 체크 여부 확인
	
	var value = 0;
	//주석 :
	for (var i = 0; i < obj.length; i++) {
		if (obj[i].checked == true) {
			value = 1;
			break;
		}
	}
	//주석:
	if (value == 0)
		return false;
	else
		return true;
}

//아이디 체크 메소드 만들기 
function CheckID() { 
	window.open("CheckID.html", "아이디 중복확인", "width=500, height=300");
	
	
	
	
}