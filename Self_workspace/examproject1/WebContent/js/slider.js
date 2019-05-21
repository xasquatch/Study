var imgNum;
var size = 0;

function setSlider(target, size, numPerPage, isAuto) {
	this.size = size;
	var currentPos = 0;
	
	imgNum = Math.floor($(target + " .banner").length / numPerPage);
	$(target + " .innerDiv").css("width", size * imgNum);
	
	$(target + " .leftArrow," + target + " .rightArrow").on("mouseover", function() {
		$(target + " .leftArrow," + target + " .rightArrow").stop().animate({opacity:"0.9"}, 500);
	});
	
	$(target + " .leftArrow," + target + " .rightArrow").on("mouseout", function() {
		$(target + " .leftArrow," + target + " .rightArrow").stop().animate({opacity:"0.2"}, 500);
	});
	
	$(target + " .leftArrow").on("click", function() {
		toLeft();
		moveSlider()
	});
	
	$(target + " .rightArrow").on("click", function() {
		toRight();
		moveSlider()
	});
	
	//오토 슬라이드
	if(isAuto) {
		var autoSlide = setInterval(toRight, 5000);
		
		$(target).on("mouseout", function() {
			autoSlide = setInterval(toRight, 5000);
		});
		
		$(target).on("mouseover", function() {
			clearInterval(autoSlide);
		});
	}
	
	//inner functions
	function toLeft() {
		currentPos--;
		if(currentPos < 0) {
			currentPos = imgNum - 1;
		}
		moveSlider();
	}

	function toRight() {
		currentPos++;
		if(currentPos >= imgNum) {
			currentPos = 0;
		}
		moveSlider();
	}
	
	function moveSlider() {
		$(target + " .innerDiv").animate({marginLeft:currentPos * -size + "px"});
	}
}