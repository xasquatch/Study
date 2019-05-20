$(function() {
	$("#options").hide();
		
	//검색 옵션 보이기/숨기기
	$("#search_option_btn").on("click", function() {
		if($("#options").css("display") == "none") {
			$(this).text("검색 옵션 숨기기");
			$(this).css("background-image", "url('../images/Arrow-Up.png')");
		} else {
			$(this).text("검색 옵션 보기");
			$(this).css("background-image", "url('../images/Arrow-Down.png')");
		}
		$("#options").stop().slideToggle();
	});
});