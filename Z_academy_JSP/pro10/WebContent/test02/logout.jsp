<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션객체 메모리 영역에 있는 값을 모두 초기화
	session.invalidate(); //← 모두 초기화
%>
	<script type="text/javascript">
		window.alert("로그아웃되었습니다");
		location.href="index.jsp";
	</script>
<%
	//세션영역의 값 제거 후 index.jsp 메인 페이지로 이동 이동시 session영역 유지
// 	response.sendRedirect("index.jsp");
	
%>   