<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	//multi_pro.jsp페이지로부터 업로드한 파일의 가상경로(다운로드할 경로) 및 파일명 전달받기
	String path = request.getParameter("path");
	String name = request.getParameter("name");
	
	/*파일을 다운로드할 가상경로 주소 upload를 이용해 실제 다운로드할 파일의 경로를 얻는다 */
	String realPath = getServletContext().getRealPath("/"+path);

	//다운로드 파일을 서버에서 클라이언트의 브라우저로 내보내기 전에 헤더 정보 설정하기
	response.setContentType("Application/x-msdownload");//다운로드 문서형식으로 내보내겠다
	//참고 : 클라이언트의 웹브라우저에서는 이코드를 인식함.
	
	//웹브라우저에서 다운로드할 파일명 클릭시
	//1. Content-Disposition 속성에 attachment;을 지정하여 다운로드시 "파일 다운로드" 대화상자가 뜨도록
	//  헤더 속성의 값 설정
	//2. 다운로드 파일명이 한글이 있을 경우 파일명이 깨짐을 방지하기위해서 문자셋 인코딩 후 다운로드할 파일명을 response객체에 설정
	response.setHeader("Content-Disposition", "attachment; fileName=\""+ URLEncoder.encode(name,"UTF-8")+"\";");
	
	/******************************여기까지 껍데기 준비(여기까지만 컴파일하면 파일내용은 출력이 안됨)***********************************/
	
	File file = new File(realPath+"/"+ new String(name.getBytes("UTF-8"),"8859_1"));
	
	byte[] data = new byte[1024];
	
	if(file.isFile()){//파일형식이 맞다면
		try{
			//다운로드할 파일내용을 읽어들이기 위한 통로 준비
			//new FileInputStream(file);
			//파일 다운로드할 실제 파일객체가 가리키는 파일을 1바이트 단위로 읽어들이기 위한 스트림 통로 얻기
			//new BufferedInputStream(new FileInputStream(file));
			//파일 객체가 가리키는 파일데이터 전체를 1바이트씩 읽어들여서
			//별도의 내부의 공간에 모아두었다가
			//한꺼번에 파일 자체를 읽어들이기 위한 통로 생성
			BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));
			/*사용자에게 파일을 출력, 내보내기(다운로드)위한 통로 준비*/
			BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream());
			
			int read;
			
			while((read = input.read(data)) != -1){
				output.write(data, 0, read);
			}
			output.flush();
			output.close();
			input.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
%>