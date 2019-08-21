
<%@page import="sec01.ex01.MemberDAO"%>
<%@page import="sec01.ex01.MemberBean"%>
<%@page import="java.util.List"%>

<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	member.jsp설명
	- 전송된 회원 정보를 getParameter()메소드를 이용해 가져온 후
	MemberBean객체를 생성하여 입력한 회원정보를 변수에 저장 합니다.
	그런 다음 MemberDAO객체의 addMember()메소드를 호출해 인자로 전달 합니다.
	새 회원 추가 후, 다시 입력 MemberDAO의 lstMembers()메소드를 호출해
	DB의 모든 회원 정보를 조회하고 목록으로 출력합니다.
 --%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd"); 
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	MemberBean bean = new MemberBean(id,pwd,name,email);
	
	//4.입력한 회원정보를 DB의 테이블에 추가하기 위해
	MemberDAO dao = new MemberDAO();
	dao.addMember(bean);
	
	List memberList = dao.listMember();
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
			if(memberList.size() ==0){
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
				for(int i = 0;i<memberList.size();i++){
					
					MemberBean mb = (MemberBean)memberList.get(i);
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
		
	</table>
</body>
</html>