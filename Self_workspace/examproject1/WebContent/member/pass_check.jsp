<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내정보</title>
<link rel="stylesheet" href="../css/main.css"/>
</head>
<body>
	<%@include file="../inc/top_lg.jsp" %>
	
	<%
	if(id == null) {
		%>
		<script>
			alert("해당 서비스는 로그인 후 이용 가능합니다.");
			location.href = "../index.jsp";
		</script>
		<%
	}
	%>
	
		<header>
			<div id="ui_top_banner">
				<div id="wrap">
					<a href="../index.jsp"><img src="../images/new_logo.png" alt="Hbay Logo" id="logo"/></a>
					<h1 id="ui_title">내정보</h1>
					
					<ul id="ui_top_menu">
						<li><a href="pass_check.jsp" class="ui_selected">내정보 관리</a></li>
						<li><a href="pass_change.jsp">비밀번호 변경</a></li>
						<li><span class="divider"></span></li>
						<li><a href="close_acc.jsp">회원탈퇴</a></li>
						<div class="clear"></div>
					</ul>
					<div class="clear"></div>
				</div>
			</div>
		</header>
		
		<div id="wrap" class="wrap_min">
			<article>
				<div id="pass_check">
					<h1>비밀번호 재확인</h1>
					<p>본인확인을 위해 한번 더 비밀번호를 입력해 주세요.</p>
					<p>비밀번호는 타인에게 노출되지 않도록 주의해 주세요.</p>
				</div>
				<form action="pass_checkProc.jsp" method="post">
					<div id="user_info_form">
					<table>
						<tr>
							<td class="label_td"><label for="id">아이디</label></td>
							<td><%=id %></td>
						</tr>
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