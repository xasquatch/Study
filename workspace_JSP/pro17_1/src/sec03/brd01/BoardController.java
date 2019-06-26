package sec03.brd01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//이클래스는  /board/listArticles.do로 요청시.. 화면에 검색한 글목록을 출력하는 역할을 함
@WebServlet("/board/*")
public class BoardController extends HttpServlet{

	BoardService boardService; //service
	ArticleVO articleVO; //dto
	
	//서블릿 초기화시 BoardService객체를 생성 합니다.
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
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
		String action = req.getPathInfo();
		
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
			}
			
			//디스패치 방식으로 뷰페이지로 포워딩 소스
			RequestDispatcher dispatch = req.getRequestDispatcher(nextPage);
			dispatch.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}








