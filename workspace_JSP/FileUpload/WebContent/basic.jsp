<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//cos.jar파일 내부에 있는 multipartrequest클래스 : 파일 업로드 담당하는 클래스
	ServletContext ctx = getServletContext();
	//현재 실행 중인 웹프로젝트에 대한 정보를 지니고 있는 객체의 getrealpath()메소드 호출
	String realpath = ctx.getRealPath("/Upload");
	
// 	out.println(realpath);
	
	//▼최대 업로드 크기 지정
	int max = 1024*1024*5;
	
	MultipartRequest multi = new MultipartRequest(request,realpath,max,"UTF-8",new DefaultFileRenamePolicy());
	String user = multi.getParameter("user");
	String title = multi.getParameter("title");
	
	out.println(user+" , "+title);
	out.println("<HR>");
	
	//multipartrequest객체의 getfilenames()메소드를 호출하면
	//basic.html에서 요청당시 입력태그인 <input>태그의 name속성값을
	//꺼내서 Enumeration반복객체에 담아
	//Enumeration반복객체 자체를 리턴받는다.
	Enumeration e = multi.getFileNames();
	
	while(e.hasMoreElements()){
		String name = (String)e.nextElement();
		out.println("클라이언트가 업로드한 파일의 원본이름 :"+multi.getOriginalFileName(name)+"<BR>");
		out.println("서버에 실제로 업로드된 파일의 이름 : "+multi.getFilesystemName(name)+"<BR>");
		out.println("업로드된 파일의 유형 : "+multi.getContentType(name)+"<BR>");
		
		//서버에 업로드된 파일의 정보를 얻기 위해 실제 파일에 접근하기위한 file객체 얻기
		File f = multi.getFile(name);
		out.println("파일의 크기 : " + f.length());
	}
	
	
	
	
%>