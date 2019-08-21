<%@page import="java.util.List"%>
<%@page import="sec01.ex01.MemberDAO"%>
<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	//memberForm.html페이지에서 요청한 회원내용을 전달 받기 전 request영역에 들어있는 데이터 한글처리

	request.setCharacterEncoding("utf-8");
	
%>
<!-- 	자바코드로 new MemberBean()객체 생성X → useBean액션태그로 MemberBean객체 생성
		useBean 액션태그로 id가 m인 MemberBean객체를 생성합니다.
		생성된 MemberBean객체를 참조할 범위 scope속성의 값을 page로 지정하며
		현재 member2.jsp에서만 memberbean객체를 공유해서 사용할 수 있다.
 -->
	<jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page" />
			<%--
				<jsp:setProperty>액션태그에 param속성을 다음과 같이 생략하고 property속성 값만 지정하되
				회원가입창(memberForm.html)의 <input>태그에 name속성값과
				<jsp:setProperty>액션태그의 property속성값이 일치하면
				자동으로 MemberBean의 변수에 저장해준다.
	 		 --%>
		<jsp:setProperty name="m" property="*" />
<%
	
		//회원정보를 DB의 테이블에 추가 하기 위해 MemberDao객체 생성
		
		MemberDAO dao = new MemberDAO();
		dao.addMember(m);
		//회원정보를 DB의 테이블에 추가하기 위해 addMember()메소드 호출 시 MemberBean객체 전달하여
		//DB insert작업을 함
		
		//DB의 테이블에 저장되어 있는 전체 회원정보를 검색하기 위해 메소드 호출
		List memList = dao.listMember();
		
%>
	
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center" width="100%">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%">아이디</td>
			<td width="7%">비밀번호</td>
			<td width="5%">이름</td>
			<td width="11%">이메일</td>
			<td width="5%">가입일</td>
		</tr>
		<%
			//만약에 DB의 테이블에서 조회한 결과가 없으면
			if(memList.size() ==0){
		%>		
			<tr>
				<td colspan="5">
					<p align="center">
						<B><span style="font-size : 9pt">등록된 회원이 없습니다.</span></B>
					</p>
				</td>
			</tr>
		<%	
			}else{
				for(int i = 0;i<memList.size();i++){
					
					MemberBean mb = (MemberBean)memList.get(i);
		%>
			<tr align="center">
				<td><%=mb.getId() %></td>
				<td><%=mb.getPwd() %></td>
				<td><%=mb.getName() %></td>
				<td><%=mb.getEmail() %></td>
				<td><%=mb.getJoindate() %></td>
			</tr>	
		<%		
				}
			}
		%>
			<tr height="1" bgcolor="#99ccff">
				<td colspan="5"></td>
			</tr>

</body>
</html>