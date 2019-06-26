package sec03.brd02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/*
 컨트롤러를 담당하는 BoardController클래스입니다.
 주요역할 : action변수의 값이  /articleForm.do이면 글쓰기창을
  웹브라우저에 표시하고,
 action변수의 값이  /addAticle.do이면 다음 과정으로 DB에 새글을 추가합니다.
 upload()메소드를 호출해 글쓰기창에서 전송된 글 관련정보를
 Map에 key/value 쌍으로 저장합니다.
  파일을 첨부한 경우 먼저 파일 이름을 Map에 저장한 후 첨부한 파일을 저장소에 업로드 합니다.
 upload()메소드를 호출한 후에는 반환한  Map에서 새글 정보를 가져 옵니다.
 그런다음 service클래스의 addArticle()메소드 인자로 새글 정보를 전달하면 
 새글이 등록됩니다. 
 */
@WebServlet("/board/*")
public class BoardController extends HttpServlet{
	
	//글에 첨부한 이미지 저장 위치를 철수가 아닌 상수로 선언 합니다.
	private static String ARTICLE_IMAGE_REPO = "C:\\board\\article_image";

	BoardService boardService; //service
	ArticleVO articleVO; //dto
	
	//서블릿 초기화시 BoardService객체를 생성 합니다.
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
		articleVO = new ArticleVO();
	}	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nextPage = "";
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//요청 주소값 얻기
		// /listArticles.do
		// /articleForm.do
		// /addArticle.do
		String action = req.getPathInfo();
		System.out.println(action);
		
		try {
			List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
			
			//요청주소가 null일떄..
			if(action == null){
				
				articlesList = boardService.listArticles();
				req.setAttribute("articlesList", articlesList);
				nextPage = "/board01/listArticles.jsp";
				
			 //요청주소가 /listArticles.do이면  DB에 저장된 전체글을 조회함.	
			}else if(action.equals("/listArticles.do")){
				//BoardService객체의 listArticles()메소드를 호출해 DB에 있는 전체글을 검색하여 
				//ArrayList로 반환 받음
				articlesList = boardService.listArticles();
				//조회된 글목록을 request영역에 바인딩!
				req.setAttribute("articlesList", articlesList);
				//조회된 글목록을 보여줄 뷰페이지주소 저장
				nextPage = "/board01/listArticles.jsp";
			
			//글을 쓸수 있는 화면으로 이동시켜줘~ 요청!
			}else if(action.equals("/articleForm.do")){
									
				//글쓰기 화면 뷰페이지의 주소를 변수에 저장
				nextPage = "/board02/articleForm.jsp";
			
			//DB에 새글을 추가 하라는 요청!
			}else if(action.equals("/addArticle.do")){
				
//upload()메소드를 호출해 글쓰기화면에서 전송된 글관련 정보를
//HashMap에 key/value 쌍으로 저장합니다.
//그런후.. 글입력시 추가적으로 업로드할 파일을 선택하여 글쓰기 요청을 했다면..
//업로드한 파일명, 입력한 글제목, 입력한 글내용을 key/value형태의 값들로 저장되어 있는
//HashMap객체를 리턴 받는다.
//그렇지 않을경우에는???? 업로드한 파일명을 제외한~?????????????
//입력한 글제목,입력한 글내용을 key/value형태의 값들로 저장되어 있는
//HashMap객체를 리턴 받는다.
			Map<String, String>	articleMap	= 
										upload(req,resp);
			
			//HashMap에 저장된 글정보(업로드할 파일명, 입력한 글제목, 글내용)를 
			//다시 가져옵니다.
			String title = articleMap.get("title");
			String content = articleMap.get("content");
			String imageFileName = articleMap.get("imageFileName");
			
			//DB에 추가하기 위해 사용자가 입력한 글정보 + 업로드할 파일명을
			//ArticleVO객체의 각변수 저장함
			articleVO.setParentNo(0);//추가할 새글의 부모글번호를 0으로 저장
			articleVO.setId("hong");//추가할 새글 작성자 ID를 hong으로 저장
			articleVO.setTitle(title);
			articleVO.setContent(content);
			articleVO.setImageFileName(imageFileName);
			
			//그런다음 service클래스의 addArticle()메소드 호출시
			//인자로 새글정보를 전달하면 새글이 등록됩니다.
			//요약 : 글쓰기 창에서 입력된 정보를  ArticleVO객체에 설정한후
			//     addArticle()메소드 호출시 전달 합니다.
			boardService.addArticle(articleVO);
				 
		//DB에 새글을 추가하고 컨트롤러에서 /board02/listArticles.jsp로이동하여
		//전체글을 다시 DB에서 검색해서 보여 주기 위해 다음과 같은 주소를 지정함
			nextPage = "/board/listArticles.do";
				
			}
			
			//디스패치 방식으로 뷰페이지로 포워딩 소스
			RequestDispatcher dispatch = req.getRequestDispatcher(nextPage);
			dispatch.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//doHandel메소드 끝
	
	//파일 업로드 처리를 위한 메소드 
	private Map<String, String> upload(HttpServletRequest request,
									   HttpServletResponse response){
		
		Map<String, String> articleMap = 
									new HashMap<String,String>();
		
		String encoding = "utf-8";
		
		//글쓰기를 할때 첨부한 이미지를 저장할 폴더 경로에 대한 파일 객체를 생성합니다.
		File currentDirPath = new File(ARTICLE_IMAGE_REPO);
		
		//업로드할 파일 데이터를 임시로 저장할 객체 메모리 생성
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//파일 업로드시~ 사용할 임시메모리 최대 크기 1메가 바이트로 지정
		factory.setSizeThreshold(1024*1024*1);
		
		//임시메모리에 파일 업로드시~ 지정한 1메가바이트 크기를 넘길경우
		//업로드될 파일 경로를? 지정함
		factory.setRepository(currentDirPath);
		
//참고
//DiskFileitemFactory클래스는 업로드 파일의 크기가 지정한 크기를 넘기 전까지는
//업로드한 파일 데이터를 임시 메모리에 저장하고 지정한 크기를 넘길 경우 폴더에 파일로 저장한다.

		//파일을 업로드할 메모리를 생성자 쪽으로 전달 받아!저장한!파일업로드 처리할 객체 생성
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
				//업로드할 파일에 대한 요청 정보를 가지고 있는 request객체를
				//parseRequest()메소드 호출시 인자로 전달하면..
				//request객체에 저장되어 있는 업로드할 파일의 정보들을 파싱해서
				//DiskFileItem객체에 저장후
				//DiskFileItem객체를 ArrayList에 추가합니다.
				//그후, ArrayList를 반환 받습니다.
				List items = upload.parseRequest(request);
				
				//ArrayList크기만큼
				//(DiskFileItem객체(업로드할 아이템 하나의 정보)의 갯수 만큼)반복
				for(int i=0; i<items.size(); i++){
					//ArrayList 가변 배열에서..
					//DiskFileItem객체(업로드할 아이템 하나의 정보를 말함)를 얻는다.
					FileItem fileItem = (FileItem)items.get(i);
					
					//DiskFileItem객체가 파일 아이템이 아닐경우
					if(fileItem.isFormField()){
						System.out.println(fileItem.getFieldName() + "=" 
										  + fileItem.getString(encoding));
						
						//articleFrom.jsp페이지에서 입력한
						//글제목과 글내용만 따로 HashMap에 (key=value)형식으로 저장함.
						//HashMasp에 저장된 데이터의 예 -> 
						//{title=입력한글제목, content=입력한글내용 }
						articleMap.put(fileItem.getFieldName(), 
									   fileItem.getString(encoding));
					}else{//DiskFileItem객체(업로드할 아이템 하나의 정보)가 
						  //파일 아이템  일 경우 업로드 진행!!
						System.out.println("파라미터명 : " + fileItem.getFieldName());
						System.out.println("파일명 : " + fileItem.getName());
						System.out.println("파일크기 :" + fileItem.getSize() + "bytes");
						
						//articleForm.jsp페이지에서 입력한 글제목, 글내용, 요청할 업로드 파일등..
						//모든 정보? HashMap에 key-value형식으로 저장합니다.
						//(imageFilename=업로드할파일명, title=입력한글제목, content=입력한 글내용)
						//형식으로 저장합니다.
						articleMap.put(fileItem.getFieldName(), fileItem.getName());
						
						//업로드할 파일이 존재 하는 경우 업로드할 파일의 파일이름으로 저장소에 업로드 합니다
						//-> 파일크기가 0보다 크다면(업로드할 파일이 있다면)
						if(fileItem.getSize() > 0){
							//업로드할 파일명을 얻어 파일명의 뒤에서 부터 \\문자열이 들어 있는지 
							//인덱스 위치를 알려주는데..
							//없으면 -1을 반환함
							//뒤에서 부터 문자가 들어있는 인덱스를 알려준다
							int idx = fileItem.getName().lastIndexOf("\\");
							
							if(idx == -1){
								idx = fileItem.getName().lastIndexOf("/");//-1얻기
							}
							//업로드할 파일 명 얻기
							String fileName = fileItem.getName().substring(idx+1);
							//업로드할 파일 경로 + 파일명에 대한 객체 생성
							File uploadFile = 
									new File(currentDirPath + "\\" + fileName);
							//실제 업로드
							fileItem.write(uploadFile);
						}// if 끝	
					} //if 끝
				}//for 끝
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return articleMap; //HashMap리턴
		
	}//upload 메소드 끝
	
}//BoardController클래스 끝








