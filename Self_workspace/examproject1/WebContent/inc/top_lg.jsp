<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script>
//javascript
function login() {
	var width = 480;
	var height = 500;
	var winL = (screen.width - width) / 2;
	var winT = (screen.height - height) / 2;
	var property = "width=" + width + "," + "height=" + height + "," 
					+ "left=" + winL + "," + "top=" + winT + " menubar=no";
	
	window.open("http://localhost:<%=request.getServerPort() %><%=request.getContextPath() %>/member/login.jsp", "Login Page", property);
}
</script>
    
<%
request.setCharacterEncoding("utf-8");
String id = (String)session.getAttribute("id");
%>
    
	<div id="top_lg">
	<%
		if(id == null || id.isEmpty()) {
			%>
			<ul id="login">
				<li><a href="javascript:login();">로그인</a></li>
				<li><a href="http://localhost:<%=request.getServerPort() %><%=request.getContextPath() %>/member/register.jsp">회원가입</a></li>
			</ul>
			<%	
		} else {
			%>
			<ul id="login">
				<li><a href="http://localhost:<%=request.getServerPort() %><%=request.getContextPath() %>/board/sell.jsp">판매</a></li>
				<li><a href="http://localhost:<%=request.getServerPort() %><%=request.getContextPath() %>/board/mylist_sell.jsp">내 목록</a></li>
				<li><a href="http://localhost:<%=request.getServerPort() %><%=request.getContextPath() %>/member/logoutProc.jsp">로그아웃</a></li>
			</ul>
			<ul id="user_info">
				<li><a href="http://localhost:<%=request.getServerPort() %><%=request.getContextPath() %>/member/pass_check.jsp" title="내정보"><%=id %></a>님 환영합니다.</li>
			</ul>
			<%
		}
	%>
		<div class="clear"></div>
	</div>