<%@page import="java.sql.Timestamp"%>
<%@page import="board.FileBoardDTO"%>
<%@page import="board.FileBoardDAO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>fupdate_pro.jsp</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String pageNum = request.getParameter("pageNum");
	String num = request.getParameter("num");
	
	String id = (String) session.getAttribute("id");
	
	if (id == null){
		response.sendRedirect("login.jsp");
	}
	
	// 현재 실행 중인 웹 프로젝트에 대한 정보를 지니고 있는 객체 얻기
	ServletContext ctx = getServletContext();
	
	// 현재 실행 중인 웹 프로젝트에 대한 정보 객체의 getRealPath()메소드를 이용하여
	// 가상경로를 실제 경로로 바꿔주기
	String realPath = ctx.getRealPath("/upload");
	
	int maxSize = 1024*1024*5; //5MB
	
	MultipartRequest multi = new MultipartRequest(request,
											realPath,
											maxSize,
											"UTF-8",
											new DefaultFileRenamePolicy()
											);
	
	FileBoardDTO fdto = new FileBoardDTO();
	
	// 폼정보 => 자바빈 fdto에 저장
	fdto.setNum(Integer.parseInt(multi.getParameter("num")));
	fdto.setContent(multi.getParameter("content"));
	fdto.setName(multi.getParameter("name"));
	fdto.setPasswd(multi.getParameter("passwd"));
	fdto.setSubject(multi.getParameter("subject"));
	fdto.setFile(multi.getFilesystemName("file"));
	
	// DB객체 생성
	FileBoardDAO fileBoardDAO = new FileBoardDAO();
	int check = fileBoardDAO.updatefBoard(fdto);
	
	if(check==1){
%>	
	<script type="text/javascript">
		alert("수정되었습니다~!");
		location.href="fboard.jsp?pageNum=<%=pageNum%>";
	</script>
<% 		
	}else{
%>
	<script type="text/javascript">
		alert("비밀번호를 확인해주세요~");
		history.back();
	</script>
<%		
	}
%>

</body>
</html>