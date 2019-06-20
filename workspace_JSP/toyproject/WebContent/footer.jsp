<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<footer id="nav-footer">













<!-- MODAL FORM -->
<div id="masage" class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="modalTitle"></h4>
        </div>
	        <div class="modal-body">
			<form class="form-horizontal">
				<div class="form-group">
					<label class="col-xs-2 control-label" for="id">아이디</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" id="id" placeholder="아이디" maxlength="15" required="required">
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label" for="pwd1">비밀번호</label>
					<div class="col-xs-10">
						<input type="password" class="form-control" id="mypwd1" placeholder="비밀번호" maxlength="15" required="required" onkeydown="passchecking();">
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label" for="pwd2">비밀번호 확인</label>
					<div class="col-xs-10">
						<input type="password" class="form-control" id="mypwd2" placeholder="비밀번호 확인" maxlength="15" required="required" onkeydown="passchecking();">
					</div>
				</div>
				<div class="form-group">
					<div id="passcheck"></div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label" for="name">이름</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" id="name" placeholder="이름" maxlength="15">
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label" for="CallNumber">연락처</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" id="CallNumber" placeholder="연락처" onkeydown="changnumber" maxlength="15">
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

				        var mypwd1 = $('#mypwd1').val();
				        var mypwd2 = $('#mypwd2').val();
				         
				        if((mypwd1!=mypwd2)||mypwd1 == ""||mypwd2 == ""){
				            $('#passcheck').html("비밀번호 확인하셨나요?");
						}
				        else{
				            $('#passcheck').html("잘하셨어요!");
				        }
				    }
					
				</script>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label" for="email">이메일</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" id="email" placeholder="이메일" maxlength="45" >
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label" for="address">우편번호</label>
					<div class="col-xs-8">
						<input type="text" class="form-control" name="myaddr1" id="sample3_postcode" placeholder="우편번호">
					</div>
					<div class="col-xs-2">
						<input type="button" style="border:1px solid rgba(0,0,0,0.2);" class="btn btn-default" onclick="sample3_execDaumPostcode()" value="우편번호 찾기"><br>
					</div>
					<div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 0;position:relative">
						<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnFoldWrap"
						 style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label" for="address">주소</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" name="myaddr2" id="sample3_address" placeholder="주소">
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label" for="address">상세주소</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" name="myaddr3" id="sample3_detailAddress" placeholder="상세주소">
					</div>
				</div>
				<div class="form-group">
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
				<div class="form-group">
					<label class="sr-only" for="submit">입력완료</label>
					<button type="submit" class="btn btn-primary">입력완료</button>
				</div>
			</form>
	        </div>
        <div class="modal-footer">
        </div>
      </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
  </div><!-- /.modal -->
</footer>