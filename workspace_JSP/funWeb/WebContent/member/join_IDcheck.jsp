<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	//8. 사용함 버튼을 클릭했을 때 호출되는 함수
	
	result = function() {
		//join.jsp(부모창)페이지의 아이디 입력란의 값을 세팅
		opener.document.fr.id.value = document.nfr.userid.value;
		//작은창 닫음
		window.close();
	}

</script>


</head>
<body>
<%
	
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
	//1.join.jsp의 winopen()함수에 의해 전달받은 user_id값 가져오기
	//2.밑의 중복확인 버튼을 클릭시 아래의 <form>태그로부터 요청받은 userid값 받기
	String id = request.getParameter("userid");
	
	//3.DB작업할 객체 생성
	MemberDAO dao = new MemberDAO();
	
	//4.memberDAO클래스 내부에 아이디중복체크 유무값을 가져오기위해서 idcheck()메소드 추가
	
	//5. 아래의 <form>태그로부터 요청받은 id값을 DB에 저장되어 있는 id값과 비교하기 위해
	//	idchech()메소드 호출시 전달하여 판단
	int check = dao.idcheck(id);
	
	//6. check == 1 "사용중인 ID입니다."
	//	check == 0 "사용가능한 ID입니다."
%>


	<form action="join_IDcheck.jsp" method="POST" name="nfr">
		아이디 : <input type="text" name="userid" value=<%=id %>>
		<input type="submit" value="중복확인"><BR>
<%	if(check == 1){
		out.println("사용중인 ID입니다.");
	}else{
		out.println("사용가능한 ID입니다.");
%>
		<input type="button" value="사용"  onclick="result()"><BR>
<%	//7. 사용가능한 아이디 이면 사용함 버튼을 눌러서 부모창에 사용가능한 ID뿌려주기
	}
%>
	</form>


</body>
</html>