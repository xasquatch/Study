<%@page import="com.bean.board.BoardDaoImpl"%>
<%@page import="com.bean.board.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글처리
	request.setCharacterEncoding("UTF-8");

	//요청값 얻기 
	//Update.jsp에서 수정한 글 정보를 request영역에서 꺼내오기 
	int num = Integer.parseInt(request.getParameter("num"));   
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String pass = request.getParameter("pass"); //<--사용자가 입력한 pass
	
	//요청값을  BoardDto객체의 각변수에 저장
	BoardDto dto = new BoardDto();
	dto.setContent(content);
	dto.setEmail(email);
	dto.setName(name);
	dto.setSubject(subject);
	dto.setPass(pass);
	dto.setNum(num);
	
	//수정할 글번호를 통해 수정할 글정보를 DB로부터 검색해옵니다.
	BoardDaoImpl dao = new BoardDaoImpl();
	BoardDto tmpDto = dao.getBoardInfo(num);
	
	//검색한 하나의 글정보중...DB에 저장된 패스워드값 얻기
	String storedPass = tmpDto.getPass();
	
	//Update.jsp에서 수정시 입력한 패스워드값 얻기
	String paramPass = dto.getPass();
	
	//Update.jsp에서 수정시 입력한 패스워드와 DB에 저장되어 있는 패스워드가 다를떄!
	if(!paramPass.equals(storedPass)){ 
%>
	<script type="text/javascript">
		window.alert("입력하신 비밀번호가 올바르지 않습니다.");
		history.back();//이전페이지로 되돌아 가기
	</script>
<%
	}else{//Update.jsp에서 수정시 입력한 패스워드와 DB에 저장되어 있는 패스워드가 동일할떄!
		
		//UPDATE DB작업을 하기 위해 BoardDaoImpl객체의 updateBoard()메소드 호출시
		//BoardDto객체를 전달 ~ 
		dao.updateBoard(dto);		
		
		//List.jsp페이지로 이동
		response.sendRedirect("List.jsp");
	}	
%>







