<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html" charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="../js/script.js"></script>
<link href="../css/style.css" rel="stylesheet">
<title>회원가입</title>
</head>
<body>

<c:import url="/inc/header.jsp"></c:import>

<div id="content">
	<h1 style="text-align: center;">회원가입<BR><small>아래 정보를 입력해주세요</small></h1>
	<div class="innerform col-lg-6 col-xs-12">
		<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
		  <ol class="carousel-indicators">
		    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
		  </ol>
		
		  <div class="carousel-inner" role="listbox">
		    <div class="item active">
		      <img src="${pageContext.request.contextPath}/img/img3.jpg" alt="...">
				<div class="carousel-caption">
					<p>지금 이 순간에도 많은 사람들이 이미 함께하고 있습니다</p>
				</div>
		    </div>
		    <div class="item">
		      <img src="${pageContext.request.contextPath}/img/img2.jpg" alt="...">
				<div class="carousel-caption">
					<h3>경험해보세요!</h3>
					<p>이태껏 경험해보지 못했던 기능</p>
				</div>
		    </div>
		    ...
		  </div>
		
		  <!-- Controls -->
		  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
		</div>
	</div>
	<div class="innerform col-lg-6 col-xs-12">
	    <form class="form-horizontal" action="idchecking.do" method="POST">
<script type="text/javascript">
function idcheck() {
    var id = $('#id').val();
    var pattern = /([^a-zA-Z0-9-_])/;
    	if(id.length === 0){
    		$('#message-body').html("아이디를 먼저 입력해주세요.");
    		$('#message').modal("show");
    		return;
    	}else if(pattern.test(id)){
			$('#message-body').html("영소문자와 숫자만 가능합니다.");
 	    	$('#message').modal("show");
    	    return;
    	};
        $.ajax({
            type : 'POST',
            url : 'idchecking.do',
            data : {
                id : id
            },
            success : function(result) {
                if (result == 1) {
                    $('#message-body').html("사용가능한 ID입니다.");
                    $('#checkType')
                            .attr('class', 'modal-content panel-success');
                } else {
                    $('#message-body').html("중복 : 사용할 수 없는 ID입니다.");
                    $('#checkType')
                            .attr('class', 'modal-content panel-warning');
                }
                $('#message').modal("show");
            }
        })
    }


</script>
			<div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 0;position:fixed; z-index: 1;">
				<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">
			</div>
			
			<div class="form-group form-group">
				<label class="col-xs-2 control-label" for="id">아이디</label>
				<div class="col-xs-7">
					<input type="text" class="form-control" id="id" placeholder="아이디" maxlength="15" required="required">
				</div>
				<div class="col-xs-3">
					<button type="button" class="btn btn-default" onclick="idcheck();">중복 확인</button>
				</div>
			</div>
			<div class="form-group form-group">
				<label class="col-xs-2 control-label" for="pwd1">비밀번호</label>
				<div class="col-xs-10">
					<input type="password" class="form-control" id="pwd1" placeholder="비밀번호" maxlength="15" required="required">
				</div>
			</div>
			<div class="form-group form-group">
				<label class="col-xs-2 control-label" for="pwd2">비밀번호 확인</label>
				<div class="col-xs-10">
					<input type="password" class="form-control" id="pwd2" placeholder="비밀번호 확인" maxlength="15" required="required" onchange="passchecking();">
				</div>
			</div>
			<div class="form-group form-group">
				<span class="col-xs-3"></span>
				<p id="passcheck" class="col-xs-6" style="text-align: center;">
				</p>
				<span class="col-xs-3"></span>
			</div>
			<div class="form-group form-group">
				<label class="col-xs-2 control-label" for="name">이름</label>
				<div class="col-xs-10">
					<input type="text" class="form-control" id="name" placeholder="이름" maxlength="15">
				</div>
			</div>
			<div class="form-group form-group">
				<label class="col-xs-2 control-label" for="CallNumber">연락처</label>
				<div class="col-xs-10">
					<input type="text" class="form-control" id="CallNumber" placeholder="연락처" onkeydown="changnumber" maxlength="13">
				</div>
			<script type="text/javascript">
						function autochecking(str) {
							str = str.replace(/[^0-9]/g, '');
						    var tmp = '';
						    if( str.length < 4){
						        return str;
						    }else if(str.length < 7){
						        tmp += str.substr(0, 3);
						        tmp += '-';
						        tmp += str.substr(3);
						        return tmp;
						    }else if(str.length < 11){
						        tmp += str.substr(0, 3);
						        tmp += '-';
						        tmp += str.substr(3, 3);
						        tmp += '-';
						        tmp += str.substr(6);
						        return tmp;
						    }else{              
						        tmp += str.substr(0, 3);
						        tmp += '-';
						        tmp += str.substr(3, 4);
						        tmp += '-';
						        tmp += str.substr(7);
						        return tmp;
						    }
						    return str;
						}
						    var cellPhone = document.getElementById('CallNumber');
						    cellPhone.onkeyup = function(event){
						    event = event || window.event;
						    var _val = this.value.trim();
						    this.value = autochecking(_val) ;
						};
					    var passchecking = function(){
	
					        var pwd1 = $('#pwd1').val();
					        var pwd2 = $('#pwd2').val();
					         
					        if((pwd1!=pwd2)||(pwd1 == "")){
					            $('#passcheck').html("비밀번호 확인하셨나요?");
							}
					        else{
					            $('#passcheck').html("잘하셨어요! 비밀번호가 일치합니다.");
					        }
					    }
						
					</script>
			</div>
			<div class="form-group form-group">
				<label class="col-xs-2 control-label" for="email">이메일</label>
				<div class="col-xs-10">
					<input type="text" class="form-control" id="email" placeholder="이메일" maxlength="45" >
				</div>
			</div>
			<div class="form-group form-group">
				<label class="col-xs-2 control-label" for="address">우편번호</label>
				<div class="col-xs-7">
					<input type="text" class="form-control" name="myaddr1" id="sample3_postcode" placeholder="우편번호">
				</div>
				<div class="col-xs-3">
					<input type="button" style="border:1px solid rgba(0,0,0,0.2);" class="btn btn-default" onclick="sample3_execDaumPostcode()" value="우편번호 찾기"><br>
				</div>
			</div>
			<div class="form-group form-group">
				<label class="col-xs-2 control-label" for="address">주소</label>
				<div class="col-xs-10">
					<input type="text" class="form-control" name="myaddr2" id="sample3_address" placeholder="주소">
				</div>
			</div>
			<div class="form-group form-group">
				<label class="col-xs-2 control-label" for="address">상세주소</label>
				<div class="col-xs-10">
					<input type="text" class="form-control" name="myaddr3" id="sample3_detailAddress" placeholder="상세주소">
				</div>
			</div>
			<div class="form-group form-group">
				<label class="col-xs-2 control-label" for="address">참고항목</label>
				<div class="col-xs-10">
					<input type="text" class="form-control" name="myaddr4" id="sample3_extraAddress" placeholder="참고항목">
				</div>
	
				
				<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
				<script>
				    // 우편번호 찾기 찾기 화면을 넣을 element
				    var element_wrap = document.getElementById('wrap');
				
				    function foldDaumPostcode() {
				        // iframe을 넣은 element를 안보이게 한다.
				        element_wrap.style.display = 'none';
				    }
				
				    function sample3_execDaumPostcode() {
				        // 현재 scroll 위치를 저장해놓는다.
				        var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
				        new daum.Postcode({
				            oncomplete: function(data) {
				                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
				
				                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
				                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				                var addr = ''; // 주소 변수
				                var extraAddr = ''; // 참고항목 변수
				
				                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				                    addr = data.roadAddress;
				                } else { // 사용자가 지번 주소를 선택했을 경우(J)
				                    addr = data.jibunAddress;
				                }
				
				                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
				                if(data.userSelectedType === 'R'){
				                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
				                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
				                        extraAddr += data.bname;
				                    }
				                    // 건물명이 있고, 공동주택일 경우 추가한다.
				                    if(data.buildingName !== '' && data.apartment === 'Y'){
				                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				                    }
				                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				                    if(extraAddr !== ''){
				                        extraAddr = ' (' + extraAddr + ')';
				                    }
				                    // 조합된 참고항목을 해당 필드에 넣는다.
				                    document.getElementById("sample3_extraAddress").value = extraAddr;
				                
				                } else {
				                    document.getElementById("sample3_extraAddress").value = '';
				                }
				
				                // 우편번호와 주소 정보를 해당 필드에 넣는다.
				                document.getElementById('sample3_postcode').value = data.zonecode;
				                document.getElementById("sample3_address").value = addr;
				                // 커서를 상세주소 필드로 이동한다.
				                document.getElementById("sample3_detailAddress").focus();
				
				                // iframe을 넣은 element를 안보이게 한다.
				                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
				                element_wrap.style.display = 'none';
				
				                // 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
				                document.body.scrollTop = currentScroll;
				            },
				            // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
				            onresize : function(size) {
				                element_wrap.style.height = size.height+'px';
				            },
				            width : '100%',
				            height : '100%'
				        }).embed(element_wrap);
				
				        // iframe을 넣은 element를 보이게 한다.
				        element_wrap.style.display = 'block';
				    }
				</script>
				
				
			</div>
			<div class="form-group form-group" style="text-align: center;">
				<label class="sr-only" for="submit">입력 완료</label>
				<button type="submit" class="btn btn-primary">입력완료</button>&nbsp;&nbsp;&nbsp;
				<button type="reset" class="btn btn-default">다시 입력</button>
			</div>
		</form>
	</div>	
</div>
    
<c:import url="/inc/footer.jsp"></c:import>
</body>
</html>