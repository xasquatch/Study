<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="../js/bookmark.js"></script>
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="../css/common.css" />
<link type="text/css" rel="stylesheet" href="../css/index.css" />
<title>▒ 메인화면 ▒</title>
<style type="text/css">
.jssora051 {display:block;position:absolute;cursor:pointer;}
.jssora051 .a {fill:none;stroke:#fff;stroke-width:360;stroke-miterlimit:10;}
.jssora051:hover {opacity:.8;}
.jssora051.jssora051dn {opacity:.5;}
.jssora051.jssora051ds {opacity:.3;pointer-events:none;}
</style>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div style="min-height: 50px;">
        <!-- Jssor Slider Begin -->
        <div id="slider1_container" style="visibility: hidden; position: relative; margin: 0 auto;
        top: 0px; left: 0px; width: 1300px; height: 500px; overflow: hidden;">
            <!-- Loading Screen -->
            <div data-u="loading" class="jssorl-009-spin" style="position:absolute;top:0px;left:0px;width:100%;height:100%;text-align:center;background-color:rgba(0,0,0,0.7);">
                <img style="margin-top:-19px;position:relative;top:50%;width:38px;height:38px;" src="../svg/loading/static-svg/spin.svg" />
            </div>

            <!-- 메인 슬라이드 -->
            <div data-u="slides" style="position: absolute; left: 0px; top: 0px; width: 1300px; height: 500px; overflow: hidden;">
                <div><img data-u="image" src="../img/gallery/1300x500/4.jpg" /></div>
                <div><img data-u="image" src="../img/gallery/1300x500/5.jpg" /></div>
                <div><img data-u="image" src="../img/gallery/1300x500/3.jpg" /></div>
                <div><img data-u="image" src="../img/gallery/1300x500/6.jpg" /></div>
            </div>
       
            <div data-u="navigator" class="jssorb031" style="position:absolute;bottom:12px;right:12px;" data-autocenter="1" data-scale="0.5" data-scale-bottom="0.75">
                <div data-u="prototype" class="i" style="width:16px;height:16px;">
                    <svg viewBox="0 0 16000 16000" style="position:absolute;top:0;left:0;width:100%;height:100%;">
                        <circle class="b" cx="8000" cy="8000" r="5800"></circle>
                    </svg>
                </div>
            </div>
            <div data-u="arrowleft" class="jssora051" style="width:55px;height:55px;top:0px;left:25px;" data-autocenter="2" data-scale="0.75" data-scale-left="0.75">
                <svg viewBox="0 0 16000 16000" style="position:absolute;top:0;left:0;width:100%;height:100%;">
                    <polyline class="a" points="11040,1920 4960,8000 11040,14080 "></polyline>
                </svg>
            </div>
            <div data-u="arrowright" class="jssora051" style="width:55px;height:55px;top:0px;right:25px;" data-autocenter="2" data-scale="0.75" data-scale-right="0.75">
                <svg viewBox="0 0 16000 16000" style="position:absolute;top:0;left:0;width:100%;height:100%;">
                    <polyline class="a" points="4960,1920 11040,8000 4960,14080 "></polyline>
                </svg>
            </div>
        </div> 
    </div><!-- 페이지의 나머지 부분을 다른 컨테이너에 포장하여 모든 컨텐츠의 중심을 맞춤 -->
	<div class="container marketing">
		<div style="height: 35px;"></div>
		<%@ include file="../bootstrap/menulink.jsp"%>
		<div style="height: 50px;"></div>
		<div class="mline01"></div>
		<div style="height: 50px;"></div>
		<div class="mtxt02">
			<p>
				T. 051.806.9596<span>|</span>MON - FRI AM 10:00 ~ PM 05:00<span>|</span>SAT
				/ SUN / HOLIDAY OFF
			</p>
			<p>
				BANK INFO<span>|</span>NH. 302-1239-6397-71<span>|</span>IBK.
				010-2245-9586<span>|</span>SHINHAN. 140-010-565880<span>|</span>
			</p>
		</div>
		<div style="height: 50px;"></div>
		
		<div class="itembox">
			<hr class="featurette-divider">
			<div class="row featurette">
				<div class="col-md-4">
					<a href="../shop/flower.jsp?num=1">
						<img class="featurette-image img-responsive" src="../img/꽃다발1.jpg"
							 style="height: 300px;" alt="Generic placeholder image">
					</a>		 
					<h2 class="featurette-heading">
						[HANDTIED] 파스텔 꽃다발<br>￦20,000 
					</h2>
				</div>
				<div class="col-md-4">
					<a href="../shop/flower.jsp?num=8">
						<img class="featurette-image img-responsive" src="../img/플라워박스2.jpg"
							 style="height: 300px;" alt="Generic placeholder image">
					</a>
					<h2 class="featurette-heading">
						[FLOWER BOX] 핑크 플라워 박스<br>￦65,000 
					</h2>
				</div>
				<div class="col-md-4">
					<a href="../shop/flower.jsp?num=2">
						<img class="featurette-image img-responsive"  src="../img/꽃다발2.jpg"
							style="height: 300px;" alt="Generic placeholder image">
					</a>		
					<h2 class="featurette-heading">
						[HANDTIED] 튤립 꽃다발<br>￦23,000 
					</h2>
				</div>
			</div>
			<hr class="featurette-divider">
			<div class="row featurette">
				<div class="col-md-4">
					<a href="../shop/flower.jsp?num=7">
						<img class="featurette-image img-responsive"  src="../img/플라워박스1.jpg"
							style="height: 300px;" alt="Generic placeholder image">
					</a>
					<h2 class="featurette-heading">
						[FLOWER BOX] 플라워 용돈 박스<br>￦555,000 
					</h2>
				</div>
				<div class="col-md-4">
					<a href="../shop/flower.jsp?num=11">
						<img class="featurette-image img-responsive"  src="../img/부케3.jpg"
							style="height: 300px;" alt="Generic placeholder image">
					</a>	
					<h2 class="featurette-heading">
						[WEDDING] 스위트피 부케<br>￦40,000 
					</h2>
				</div>
				<div class="col-md-4">
					<a href="../shop/flower.jsp?num=5">
						<img class="featurette-image img-responsive"  src="../img/꽃바구니1.jpg"
							style="height: 300px;" alt="Generic placeholder image">
					</a>
					<h2 class="featurette-heading">
						[BASKET] 핑크 꽃바구니<br>￦45,000 
					</h2>
				</div>
			</div>
			<hr class="featurette-divider"><br>
			
			<footer>
				<p class="pull-right">
					<a href="#"><img src="http://cdn1-aka.makeshop.co.kr/design/sappun/wizdesign/up.png"/></a>
				</p>
				<p>
					&copy; Jssor Slider 2009 - 2016. &middot; <a href="#">Privacy</a>
					&middot;
				</p>
			</footer>
		</div>
	</div><!-- container 끝 -->
	<%@ include file="../bootstrap/footer.jsp"%>

	<!-- Bootstrap core JavaScript 페이지가 더 빨리 로딩되도록 문서의 마지막에 배치 -->
	<script src="../js/jquery-1.9.1.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/docs.min.js"></script>
	<script src="../js/ie10-viewport-bug-workaround.js"></script><!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script type="text/javascript" src="../js/jssor.slider.min.js"></script><!-- json 슬라이더 스크립트 -->
	<script>
       jQuery(document).ready(function ($) {

           var options = {
               $FillMode: 2,                                      
               $AutoPlay: 1,                                      
               $Idle: 2000,                                       
               $PauseOnHover: 1,                                  
               $ArrowKeyNavigation: 1,   			                
               $SlideEasing: $Jease$.$OutQuint,                   
               $SlideDuration: 800,                               
               $MinDragOffsetToSlide: 20,                          
               $SlideSpacing: 0, 					                
               $UISearchMode: 1,                                   
               $PlayOrientation: 1,                                
               $DragOrientation: 1,                                
               $BulletNavigatorOptions: {                          
                   $Class: $JssorBulletNavigator$,                
                   $ChanceToShow: 2,                              
                   $SpacingX: 8,                                   
                   $Orientation: 1                                
               },

               $ArrowNavigatorOptions: {                           
                   $Class: $JssorArrowNavigator$,                 
               }
           };

           var jssor_slider1 = new $JssorSlider$("slider1_container", options);

           function ScaleSlider() {
               var bodyWidth = document.body.clientWidth;
               if (bodyWidth)
                   jssor_slider1.$ScaleWidth(Math.min(bodyWidth, 1920));
               else
                   window.setTimeout(ScaleSlider, 30);
           }
           ScaleSlider();

           $(window).bind("load", ScaleSlider);
           $(window).bind("resize", ScaleSlider);
           $(window).bind("orientationchange", ScaleSlider);
       });
    </script>
</body>
</html>