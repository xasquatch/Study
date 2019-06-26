<%@page import="com.bean.board.BoardDto"%>
<%@page import="com.bean.board.BoardDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글처리
	request.setCharacterEncoding("UTF-8");

	//삭제할 글번호 얻기 
	String number = request.getParameter("num");
	int num = Integer.parseInt(number);
	
	//삭제할 글번호를 통해 DB에 저장되어있는 글에 대한 비밀번호를 얻어야 함.
	BoardDaoImpl dao  = new BoardDaoImpl();
	
	//DB에 있는 삭제할 하나의 글정보를 검색 하여 가져옴
	//이유는 삭제할 하나의 글정보 중 .. 삭제 할 글에 대한 비밀번호 값을 추출 하기 위함
	BoardDto dto = dao.getBoardInfo(num); 
	
	//글삭제시 DB에 저장되어 있는 패스워드 저장할 변수
	String dbPass = dto.getPass();
	
	//글삭제시 사용자가 입력한 패스워드 저장할 변수 
	String paramPass = "";
	
	if(request.getParameter("pass") != null){
		//사용자가 입력한 패스워드 저장
		paramPass = request.getParameter("pass");
		
		//사용자가 입력한 패스워드와 DB에 저장되어 있는 패스워드가 일치하지 않을때..
		if(!paramPass.equals(dbPass)){
%>
			<script type="text/javascript">
				window.alert("입력하신 패스워드가 올바르지 않습니다.");
				history.back();
			</script>
<%			
		}else{//사용자가 입력한 패스워드와 DB에 저장되어 있는 패스워드가 일치할때..
			
			//삭제할 글num를 deleteBoard()호출시 인자로 전달하여 
			//삭제할  글num에 해당 하는 글 데이터를 DELETE작업
			dao.deleteBoard(num);
			
			//DELETE삭제에 성공 하면  List.jsp로 이동 
// 			response.sendRedirect("List.jsp");		
%>
			<script type="text/javascript">
				window.alert("글하나가 삭제 되었습니다.");
				window.alert("글목록 페이지로 이동합니다");
				location.href = "List.jsp";
			</script>						
<%			
		}		
	}
%>



<html>
<head><title>JSPBoard</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script>
	function check() {
		if (document.form.pass.value == "") {
		alert("패스워드를 입력하세요.");
		form.pass.focus();
		return false;
		}
		document.form.submit();
	}
</script>
</head>
<body>
<center>
<br><br>
<table width=50% cellspacing=0 cellpadding=3>
 <tr>
  <td bgcolor=#dddddd height=21 align=center>
      사용자의 비밀번호를 입력해 주세요.</td>
 </tr>
</table>
<table width=70% cellspacing=0 cellpadding=2>

<form name=form method=post action="Delete.jsp" >
	<%--삭제할 글 num 꼭 전달~  --%>
	<input type="hidden" name="num" value="<%=num%>">
 <tr>
  <td align=center>
   <table align=center border=0 width=91%>
    <tr> 
     <td align=center>  
	  <input type=password name="pass" size=17 maxlength=15>
	 </td> 
    </tr>
    <tr>
     <td><hr size=1 color=#eeeeee></td>
    </tr>
    <tr>
     <td align=center>
	  <input type=button value="삭제완료" onClick="check()"> 
      <input type=reset value="다시쓰기"> 
      <input type=button value="뒤로" onClick="history.back()">
	 </td>
    </tr> 
   </table>
  </td>
 </tr>
</form> 
</table>
</center>
</body>

</html>
