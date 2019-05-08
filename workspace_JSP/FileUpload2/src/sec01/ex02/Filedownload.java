package sec01.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//파일 다운로드 기능을 담당할 클래스
//파일 다운로드 기능은 자바 문법중 IO를 이용해 구현함
@WebServlet("/download.do")
public class Filedownload extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String file_repo = "C:\\file_repo";
		
		//전송된 다운로드할 파일 이름얻기
		String filename = request.getParameter("filename");
		String downFile = file_repo + "\\" + filename;
		
		OutputStream output = response.getOutputStream();
		File f = new File(downFile);
		
/*******************************************************************************
 * [웹브라우저 캐시에 대해 설명하기 위한 내용]
 * 웹개발을 하다보면 게시글 등의 데이터를 DB에 등록했는데도 브라우저에 새로고침시 해당 데이터에 대한 내용이 반영되지 않는 경우가 있음
 * 혹은 데이터뿐만 아니라 javascript, HTML, CSS등의 정적 자원을 서버에서 수정했는데도
 * 새로고침 시 적용되지 않는 경우도 많습니다.
 * 많은 원인이  있을 수 있으나 이는 "웹브라우저 캐시"가 원인일 수 있습니다.
 * 
 * [웹브라우저의 캐시 공간이란]
 * 브라우저에는 캐시가 있는데, 이것은 서버와 불필요한 통신을 하지 않기 위해 마련된 공간입니다.
 * 최초 서버로부터 요청한 자원들(javascript, HTML, CSS 이미지 등)을 내려받고
 * 같은 자원을 새로고침을 통해서 다시 요청하는 경우
 * 브라우저는 실제로 서버로 HTTP요청을 하지 않고 브라우저 자신의 캐시에 저장해 두었던 자원을 사용하게 됩니다.
 * 
 * 예를 들어 test.jsp를 최초로 요청한 경우 서버로부터 응답된 자원들을 브라우저 캐시에 저장하고
 * {F5}나 주소표시줄의 주소를 입력해 다시 test.jsp를 요청한 경우
 * 이러한 브라우저 캐시기능이 성능 상 이점을 가져다 줄 수 있지만
 * 게시판이나, 네이버의 실시간 검색어처럼 실시간으로 변하는 부분까지 브라우저 캐시를 사용한다면
 * 사용자는 변화하는 결과를 둘 수 없고 같은 화면만 계속해서 보게 될 것입니다.
 * 
 * [응답헤더를 통한 캐시제어 설명]★★★★★★★★
 * HTTP응답 메세지의 몇가지 헤더 속성을 통해서 브라우저가 현재 페이지 내용을 캐시를 사용하지 않도록 할 수 있다.
 * response객체의 해당 속성들에 값을 설정해 웹브라우저가 캐시를 사용하지 않고
 * 매번 새로운 요청을 통해 결과를 얻어오도록 할 수 있습니다.
 *******************************************************************************/
		
		//http 1.1버전에서 지원하는 헤더로 no-cache로 설정하면 브라우저는 응답받은 결과를 캐싱하지 않습니다.
		//또한 뒤로가기 등을 통해서 페이지 이동하는 경우 페이지를 캐싱 할 수 있으므로 no-store값 또한 추가해 주어야한다.
		response.setHeader("Cache-control", "no-cache");
		response.addHeader("Cache-control", "no-cache");
		
		//웹브라우저에 다운로드할 파일명 클릭 시
		//1. "content-Diposition", "attachment"를 지정하면 다운로드시 무조건 "파일 다운로드"
		//2. 다운로드할 파일명이 꺠지는 현상을 방지하기 위해 content-dispositon속성에 다운로드할 파일명 등록
		response.setHeader("content-Diposition", "attachment; filename=\"" +URLEncoder.encode(filename,"UTF-8")+"\";");
		
		//다운로드할 파일을 바이트단위로 읽어들일 버퍼공간 통로 생성
		FileInputStream in = new FileInputStream(f);
		
		//다운로드할 파일에서 데이터를 대략 8kb씩 읽어들여와 저장할 용도의 byte단위 배열 생성
		
		byte[] buffer = new byte[1024*8];
		
		//파일다운로드를 요청한 클라이언트에게
		//다운로드할 파일을 바이트 단위로 읽어들인 버퍼공간의 데이터를 내보내기 위한 출력스트림 통로 생성
		 
		while(true){
			int count = in.read(buffer);//다운로드할 파일의 내용을 약 8kb단위로 읽어와 변수에 저장
			
			if(count == -1){//읽어 들인 값이 더이상 없으면 (-1일 경우)
				break;
			}
			//다운로드할 파일로부터 읽어들인 값이 있으면
			//읽어 들인 8kb전체를 출력스트림통로를 통해 내보내기
			output.write(buffer, 0, count);
		}
		in.close();
		output.close();
		
		
		
		
		
		
		
	}
}
