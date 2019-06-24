<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<footer id="nav-footer">

<!-- MODAL FORM -->
<div id="masage" class="modal fade bs-example-modal-sm" role="dialog" aria-labelledby="gridSystemModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h2>LOGIN</h2>
        </div>
	        <div class="modal-body">
		    	<form action="${path}/login.act" method="POST">
						<input type="text" maxlength="15" class="form-control" id="c_loginid" name="c_loginid" placeholder="Enter ID" value="${cookie.key.value}">
						<input type="password" maxlength="15" class="form-control" name="c_pwd" placeholder="Password">
						<input type="checkbox" id="cookieID">아이디 저장<span style="font-size: 0.7rem">
							<BR>(<b>한달</b>간 저장됩니다)</span><br>
							<div align="center">
						<button type="submit" class="btn btn-default btn">로 그 인</button>
						<button type="button" class="btn btn-default btn" onclick="location.href='${pageContext.request.contextPath}/mypage/signup.jsp'">회원가입</button>
					</div>
				</form>
	        </div>
        <div class="modal-footer">
        </div>
      </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
  </div><!-- /.modal -->
  
<!---------------------------- 모달 ---------------------------->
  <div id="message" class="modal fade bs-example-modal-sm" role="dialog" aria-labelledby="gridSystemModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				${requestScope.message_header }
        </div>
	        <div id="message-body" class="modal-body">
				${requestScope.message_body }
	        </div>
        <div class="modal-footer">
        </div>
      </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
  </div><!-- /.modal -->
  
  
  
  
  
  
  
  
  
  
  
</footer>