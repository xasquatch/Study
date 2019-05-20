<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 탈퇴</title>
<link rel="stylesheet" href="../css/main.css"/>
<script type="text/javascript">
	function checkForm() {
		if(!agree.checked) {
			alert("탈퇴 안내를 확인하고 동의해 주세요.");
			return false;
		}
		
		if(pass.value == "") {
			alert("비밀번호를 입력해 주세요.");
			return false;
		}
	}
</script>
</head>
<body>
	<%@include file="../inc/top_lg.jsp" %>
	
	<header>
			<div id="ui_top_banner">
				<div id="wrap">
					<a href="../index.jsp"><img src="../images/new_logo.png" alt="Hbay Logo" id="logo"/></a>
					<h1 id="ui_title">내정보</h1>
					
					<ul id="ui_top_menu">
						<li><a href="pass_check.jsp">내정보 관리</a></li>
						<li><a href="pass_change.jsp">비밀번호 변경</a></li>
						<li><span class="divider"></span></li>
						<li><a href="close_acc.jsp" class="ui_selected">회원탈퇴</a></li>
						<div class="clear"></div>
					</ul>
					<div class="clear"></div>
				</div>
			</div>
		</header>
		
		<div id="wrap" class="wrap_min">
			<article>
				<div id="close_acc">
					<h1>회원 탈퇴</h1>
					<p>회원정보 및 작성 게시물, 개인형 서비스 이용기록은 모두 삭제되며, 삭제된 데이터는 복구되지 않습니다.</p>
					<p>삭제되는 내용을 확인하시고 필요한 데이터는 미리 백업을 해주세요.</p>
				</div>
				<form action="close_accProc.jsp" method="post" onsubmit="return checkForm();">
				<div id="user_info_form">
					<h2>사용하고 계신 아이디(<span class="blue"><%=id %></span>)는 탈퇴할 경우 재사용 및 복구가 불가능합니다.</h2>
					<p><span class="orange">탈퇴한 아이디는 본인과 타인 모두 재사용 및 복구가 불가</span>하오니 신중하게 선택하시기 바랍니다.</p>
					<br/><br/>
					
					<h2>탈퇴 후 회원정보 및 개인형 서비스 이용기록은 모두 삭제됩니다.</h2>
					<p>삭제되는 내역은 아래와 같습니다.</p>
					<table id="close_info">
						<tr>
							<td>게시물</td>
							<td>현재 진행중인 판매 게시글 일괄 삭제 처리 (단 거래가 완료된 게시물은 자동으로 삭제되지 않음)</td>
						</tr>
						<tr>
							<td>개인정보</td>
							<td>회원가입시 입력한 주소, 이메일 등의 정보 삭제 처리</td>
						</tr>
					</table>
					<br/><br/>
					
					<h2>탈퇴 후에도 등록한 댓글과 거래정보는 그대로 남아 있습니다.</h2>
					<p>삭제를 원하는 게시글이 있다면 <span class="orange">반드시 탈퇴 전 비공개 처리하거나 삭제하시기 바랍니다.</span></p>
					<p>탈퇴 후에는 회원정보가 삭제되어 본인 여부를 확인할 수 있는 방법이 없어, 게시글을 임의로 삭제해드릴 수 없습니다.</p>
					<br/><br/>
					
					<input type="checkbox" id="agree"/> <span>안내사항을 모두 확인하였으며, 이에 동의합니다.</span>
					<br/><br/>
					
					<table>
						<tr>
							<td class="label_td"><label for="pass">비밀번호</label></td>
							<td><input type="password" name="pass" id="pass" placeholder="비밀번호 입력"/></td>
						</tr>
					</table>
				</div>
				<div id="pass_recheck_btn">
					<input type="submit" value="확인" class="btn"/>
					<input type="reset" value="취소" class="btn"/>
				</div>
				</form>
			</article>
		</div>
	
	<%@include file="../inc/footer.jsp" %>
</body>
</html>