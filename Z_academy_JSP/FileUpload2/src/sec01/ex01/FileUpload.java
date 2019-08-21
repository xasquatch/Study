package sec01.ex01;


import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/*
파일업로드를 처리하는 서블릿인 fileupload클래스 입니다.
라이브러리에서 제공하는 DiskFileItemFactory클래스를 이용해
저장위치와 업로드 가능한 최대 파일 크기를 설정합니다
그리고 servletFileUpload클래스를 이용해 파일 업로드창에서 업로드된 파일과
매개변수에 대한 정보를 가져와 파일을 업로드하고 매개변수값을 출력합니다.
*/
@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String encoding = "utf-8";
		
		//업로드할 파일경로와 연결된 file객체 생성
		File currentDirPath = new File("C:\\file_repo");
		
		//업로드할 파일 데이터를 임시로 저장할 객체 메모리 생성
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//파일업로드시 사용할 임시 메모리 크기 지정 (↓예시는  1MB)
		factory.setSizeThreshold(1024*1024*1);
		//임시 메모리에 파이 ㄹ업로드시 지정한 1메가 바이트 크기를 넘길경우
		//실제 업로드될 파일 경로를 지정함
		factory.setRepository(currentDirPath);
		//참고
		//DiskFileItemFactory클래스는 업로드 파일의 크기가 지정한 크기를 넘기 전까지는
		//업로드한 파일 데이터를 메모리에 저장하고 지정한 크기를 넘길 경우 임시 디렉터리에 파일로 저장
		
		//파일업로드할 메모리를 생성자 쪾으로 전달받아 저장한 파일업로드를 처리할 객체 생성
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			//업로드한 파일에 대한 요청정보를 가지고 있는 request객체를 parseRequest()메소드 호출시
			//인자로 전달하면 request객체에 저장되어 있는 업로드할 파일의 정보들을 파싱해서 DiskFileItem객체에 저장 후
			//DiskFileItem객체를 ArrayList에 추가합니다
			//그 후 ArrayList를 반환받음
			List items = upload.parseRequest(request);
			
			//ArrayList크기 만큼 (DiskFileItem객체의 갯수만큼) 반복
			for (int i = 0; i < items.size(); i++) {
				FileItem fileitem =	(FileItem)items.get(i);
				
				//DiskFileItem객체(업로드할 아이템)이 file아이템이 아닐경우
				if (fileitem.isFormField()) {
					System.out.println(fileitem.getFieldName() + " = " +fileitem.getString(encoding));
					
				}else{//DiskFileItem객체(업로드할 아이템)이 file아이템이 맞는경우
					System.out.println("파라미터명 : "+fileitem.getFieldName());
					System.out.println("파  일    명 : "+fileitem.getName());
					System.out.println("파 일 크 기 : "+fileitem.getSize()+"byte");
					
					//파일크기가 0보다 크다면 (업로드할 파일이 있다면
					if (fileitem.getSize()>0) {
						//업로드할 파일명을 얻어 파일명의 뒤에서  \\문자열이
						//들어있는지 인덱스 위치를 알려주는데
						//없으면 -1을 반환함
						
						int idx = fileitem.getName().lastIndexOf("\\");//뒤에서부터 문자가 들어있는 인덱스 위치를 알려준다.
						System.out.println(idx);
						if (idx == -1) {
							idx = fileitem.getName().lastIndexOf("/");
							System.out.println("안녕" + idx);
						}
						
						String fileName = fileitem.getName().substring(idx+1);
						
						
						File uploadFile = new File(currentDirPath + "\\" + fileName);
						
						//실제 파일 업로드
						fileitem.write(uploadFile);
					}
				}
				
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

	
	
}