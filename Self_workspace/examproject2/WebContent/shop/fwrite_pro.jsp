<%@page import="board.FileBoardDAO"%>
<%@page import="board.FileBoardDTO"%>
<%@page import="java.sql.*"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// fwrite.jsp에서 넘어온 id 세션 값 가져오기
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
	

	/* MultipartRequest : 실제 파일 업로드 담당 클래스 */
	// 전달1) 2번 form에서 전달받은 request 다시 전달
	// 전달2) 업로드할 파일의 실제 서버 위치 주소 전달
	// 전달3) 업로드할 최대 파일 사이즈 전달
	// 전달4) 업로드할 파일 이름이 한글일 경우 문제가 되므로 처리할 수 있도록 인코딩 타입을 전달
	// 전달5) 똑같은 파일을 업로드할 경우 파일 이름이 중복되지 않도록 자동으로 파일 이름을 변환 시켜줌
	// D:\workspace_javascript4\.metadata\.plugins\org.eclipse.wst.server.core
	/* \tmp1\wtpwebapps\project_0424//upload */
	
	
	MultipartRequest multi = new MultipartRequest(request,
											realPath,
											maxSize,
											"UTF-8",
											new DefaultFileRenamePolicy()
											);
	
	FileBoardDTO fileBoardDTO = new FileBoardDTO();
	
	// 폼정보 => 자바빈 fileBoardDTO에 저장
	fileBoardDTO.setContent(multi.getParameter("content"));
	fileBoardDTO.setName(multi.getParameter("name"));
	fileBoardDTO.setPasswd(multi.getParameter("passwd"));
	fileBoardDTO.setSubject(multi.getParameter("subject"));
	fileBoardDTO.setFile(multi.getFilesystemName("file"));
	
	// 글 작성 날짜, 글쓴이 ip 값을 자바빈 fileBoardDTO에 저장
	fileBoardDTO.setDate(new Timestamp(System.currentTimeMillis()));
	fileBoardDTO.setIp(request.getRemoteAddr());
	
	// DB객체 생성
	FileBoardDAO fileBoardDAO = new FileBoardDAO();
	fileBoardDAO.insertfBoard(fileBoardDTO);
	
	// fboard.jsp로 이동
	response.sendRedirect("fboard.jsp");
	

%>