<%@page import="com.bean.board.BoardDAOImpl"%>
<%@page import="com.bean.board.BoardDTO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String pass = request.getParameter("pass");
	
	BoardDAOImpl dao = new BoardDAOImpl();
	
	BoardDTO dto = new BoardDTO();
	
		dto.setName(name);
		dto.setEmail(email);
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setPass(pass);
		

	BoardDTO tempdto = dao.getBoardInfo(num);  
	
	String storedpass = tempdto.getPass();
	
	String paramPass = dto.getPass();
	
	if(!paramPass.equals(storedpass)){
		
		
%>
		<script>
			window.alert("입력하신 비밀번호가 올바르지 않습니다.")
			history.back();
		
		</script>
<%
	}else{
		
		//UPDATE DB작업 하기 위해
		dao.updateBoard(dto);
		response.sendRedirect("List.jsp");
	}
	
	
	
	
	
	
	
	
	
	
	
	
%>