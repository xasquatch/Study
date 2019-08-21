<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<!-- 		현재 페이지인 login.jsp를 재요청 -->
		<form action='./login.jsp'method='POST'>
			ID<input type='text' name='id'><BR>
			PW<input type='password' name='pw'>
			<input type="submit" value="로그인">&nbsp;&nbsp;
			<input type="reset" value="취소">
		</form>
<% 
		if(request.getMethod().equals("POST")){
			//로그인 요청시 request영역으로 전달된 id,pw넘겨받아 저장
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			//DB에 저장되어 있는 id값 "master"와 로그인시 입력한 id값이 같다면
			if("master".equals(id)){
						//DB에 저장되어 있는 pw값 "1111"와 로그인시 입력한 pw값이 동일할 때
				if("1111".equals(pw)){
					//session객체영역에 "id"라는 키에 해당하는 로그인시 입력한 id변수값을 저장
					session.setAttribute("id", id);
					//index.jsp 메인페이지로 이동
					response.sendRedirect("index.jsp");
				}else{	//DB에 저장되어 있는 pw값 "1111"와 로그인시 입력한 pw값이 다를 때
%>
					<script type="text/javascript">
						window.alert("패스워드가 틀림");
					
					</script>
<%					
				}//end if - inner3-1
			
			}else{//DB에 저장되어 있는 id값 "master"와 login.jsp에서 입력한 id값이 다를 때
			
				//DB에 저장되어 있는 pw값 "1111"과
				//login.jsp에서 입력한 pw값이 같을 때
				if("1111".equals(pw)){
%>
				<script type="text/javascript">
				window.alert("아이디가 틀림");
				</script>
<%					
				}else{
%>
				<script type="text/javascript">
					window.alert("둘다 틀림")
				</script>
<%				
				}//end if - inner3-2
			
			}//end if - inner2
		}//end if - inner
%>

</body>
</html>