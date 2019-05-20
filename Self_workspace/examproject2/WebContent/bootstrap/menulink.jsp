<%@page import="mybean.MemberDto"%>
<%@page import="mybean.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 메뉴 링크  -->
<%
String Mid = (String)session.getAttribute("id");

if(Mid==null){
%>	<div class="mtxt01">
		<ul>
			<li><a href="../shop/login.jsp">LOG-IN</a></li>
			<li>|</li>
			<li><a href="../shop/join.jsp">JOIN</a><!--font color="#e7a092">
					(무료배송쿠폰)</font--></li>
			<li>|</li>
			<li><a href="../shop/board.jsp">BOARD</a></li>
			<li>|</li>
			<li><a href="../shop/fboard.jsp">FILE BOARD</a></li>
			<li>|</li>
			<li><a href="../shop/contact.jsp">CONTACT</a></li>
			<li>|</li>
			<li><a
				href="javascript:CreateBookmarkLink('url', 'name');">+BOOKMARK</a></li>
		</ul>
	</div>
<%	
}else{
%>
	<div class="mtxt01">
	<%=Mid%>님 환영합니다.<br/>
	<ul>
		<li><a href="../shop/logout.jsp">LOG-OUT</a></li>
		<li>|</li>
		<li><a href="../shop/mypage.jsp">MY PAGE</a></li>
		<li>|</li>
		<li><a href="../shop/board.jsp">BOARD</a></li>
		<li>|</li>
		<li><a href="../shop/fboard.jsp">FILE BOARD</a></li>
		<li>|</li>
		<li><a href="../shop/contact.jsp">CONTACT</a></li>
		<li>|</li>
		<li><a
			href="javascript:CreateBookmarkLink('url', 'name');">+BOOKMARK</a></li>
	</ul>
</div>	
<%	
}
%>    
<!-- 메뉴 링크 끝 -->