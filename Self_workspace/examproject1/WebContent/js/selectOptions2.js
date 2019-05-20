function selectCheck() {
	var value = $("#select_cate").val();
	var cate = document.getElementById("select_more_cate");
	switch (value) {
	case "모든 종류":
		cate.innerHTML = getOption();
		break;
	case "카테고리 선택":
		cate.innerHTML = getOption("세부 카테고리 선택");
		break;
	case "패션의류":
		cate.innerHTML = getOption("여성의류", "남성의류", "언더웨어", "유아동의류");
		break;
	case "잡화":
		cate.innerHTML = getOption("신발", "유아동신발/잡화", "가방/잡화", "쥬얼리/시계", "수입명품");
		break;
	case "유아동":
		cate.innerHTML = getOption("기저귀/분유/유아식", "육아용품", "장난감", "유아동의류",
				"유아동신발/잡화", "브랜드 아동패션");
		break;
	case "홈데코":
		cate.innerHTML = getOption("가구/DIY", "침구/커튼", "조명/인테리어", "생활용품",
				"주방용품", "꽃/이벤트용품");
		break;
	case "문구":
		cate.innerHTML = getOption("문구/사무용품", "사무기기");
		break;
	case "취미":
		cate.innerHTML = getOption("악기/수집", "반려동물용품");
		break;
	case "컴퓨터":
		cate.innerHTML = getOption("노트북/PC", "모니터/프린터", "PC주변기기", "저장장치");
		break;
	case "디지털":
		cate.innerHTML = getOption("휴대폰", "카메라", "태블릿", "게임", "음향기기");
		break;
	case "가전":
		cate.innerHTML = getOption("대형가전", "주방가전", "계절가전", "생활/미용가전", "음향가전",
				"건강가전");
		break;
	case "스포츠":
		cate.innerHTML = getOption("스포츠의류/운동화", "휘트니스/수영", "구기/라켓", "골프",
				"자전거/보드", "캠핑/낚시", "등산");
		break;
	case "건강":
		cate.innerHTML = getOption("건강/의료용품", "건강식품", "운동용품");
		break;
	case "자동차":
		cate.innerHTML = getOption("자동차용품", "타이어/부품");
		break;
	case "공구":
		cate.innerHTML = getOption("공구설비/자재");
		break;
	case "여행":
		cate.innerHTML = getOption("여행/항공권");
		break;
	case "도서":
		cate.innerHTML = getOption("도서음반/e교육");
		break;
	case "티켓/e쿠폰":
		cate.innerHTML = getOption("티켓", "e쿠폰", "상품권");
		break;
	}
}

function getOption() {
	var str = "";
	if($("#select_cate").parent().attr("class") == "options") {
		str += "<option value='모든 종류'>모든 종류</option>";
	}
	for (var i = 0; i < arguments.length; i++) {
		str += "<option value='" + arguments[i] + "'>" + arguments[i]
				+ "</option>";
	}
	return str;
}

function selectMoreCate(category) {
	$("#select_more_cate").children("option[value='" + category + "']").prop("selected", true);
}