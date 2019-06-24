<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
function login() {
	$('#masage').modal();
	
}
</script>
<header id="nav-header">

<div id="nav-image" onclick="location.href='${pageContext.request.contextPath}/index.jsp'">
		<span class="glyphicon glyphicon-user">
		</span>
		my note
</div>

<div id="nav-menubar">
	<div class="visible-lg">
		<ul id="menulist">
			<li>갤러리</li>
			<li>게시판</li>
			<c:choose>
				<c:when test="${empty sessionScope.userid}">
					<li onclick="login();">로그인</li>
					<li onclick="location.href='${pageContext.request.contextPath}/mypage/signup.jsp'">회원가입</li>
				</c:when>
				<c:otherwise>
					<li>로그아웃</li>
					<li>나의 정보</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	<div class="hidden-lg" id="hamburger" onclick="">
		<span class="glyphicon glyphicon-menu-hamburger">
		</span>
	</div>
</div>
</header>
<script>
	


</script>