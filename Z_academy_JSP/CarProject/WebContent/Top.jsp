<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<style type="text/css">
			#login{
				/*정렬 오른쪽 밖여백  20  64  0  0*/
				float: right;
				margin: 20px 64px 0 0;
				/*폰트 사이즈 12px*/
				font-size: 12px;
				/*단어 간격 5px*/
				word-spacing: 5px;
			}
			#login a{
				/*하이퍼링크 밑줄 없애기, 글자색 #333 */
				text-decoration: none;
				color: #333;
			}
			
			#login a:HOVER {
				/*마우스포인터를  a태그위에 올렸을때 글자색을 #F90변경*/
				color: #F90;
			}
			
		#logo{
			/*정렬 왼쪽*/
			float: left;
			/*너비 265px*/
			width: 265px;
			/*밖여백 60px 0 0 40px*/
			margin: 60px 0 0 40px;
		}		
	</style>

</head>
<body>
		<%-- 메인 로고 이미지 표시 --%>
		<div id="logo">
			<a href="CarMain.jsp">
				<img src="img/RENT.jpg" width="300" height="80">
			</a>
		</div>
		<%-- login | join 링크 표시 --%>
		<table width="1000" height="5">
			<tr>
				<td align="right" colspan="5">
					<%
						//로그인 처리시..session값 이동 경로
						//login.jsp > MemberController.java > CarMain.jsp -> Top.jsp
						
						//세션 id값 전달받기
						String id = (String)session.getAttribute("id");
						
						//세션값 없음 -> MemberFrontController.java서블릿을 요청할 주소 설정
						if(id == null){
					%>
						<div id="login">
							<a href="./MemberLogin.me">login</a> | 
							<a href="./MemberJoin.me">join</a>
						</div>		
					<%		
						//세션값이 있으면-> MemberFrontController.java서블릿을 요청할 주소 설정
						}else{
					%>		
						<div id="login">
							<%=id %>님..
							<a href="./MemberLogout.me">logout</a> | 
						</div>
					<%		
						}
					%>
				</td>
			</tr>
		</table>
		<%-- login | join 링크 표시 --%>
		
		
		<%--메뉴 부분 만들기 --%>
		<table width="1000" background="img/aa.jpg" height="5">
			<tr>
				<%--예약하기 메뉴 --%>
				<td align="center" bgcolor="red">
					<a href="CarMain.jsp?center=CarReservation.jsp">
						<img src="img/bb.jpg">
					</a>
				</td>
				<%--예약확인 메뉴 --%>
				<td align="center" bgcolor="red">
					<a href="CarMain.jsp?center=CarReserveConfirm.jsp">
						<img src="img/cc.jpg">
					</a>
				</td>	
				<%--자유게시판 메뉴 --%>			
				<td align="center" bgcolor="red">
					<a href="CarMain.jsp?center=BoardListController.do">
						<img src="img/dd.jpg">
					</a>
				</td>	
				<%--이벤트 메뉴 --%>		
				<td align="center" bgcolor="red">
					<a href="CarMain.jsp?center=CarEvent.jsp">
						<img src="img/even.jpg">
					</a>
				</td>				
				<%--고객센터(공지사항 게시판)메뉴 --%>
				<td align="center" bgcolor="red">
					<a href="CarMain.jsp?center=AdminBoardListController.do">
						<img src="img/ee.jpg">
					</a>
				</td>					
			</tr>
		</table>
		
		
		
</body>
</html>




