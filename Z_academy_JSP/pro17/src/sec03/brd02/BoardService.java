package sec03.brd02;

import java.util.List;

//BoardDAO 객체를 생성한후 selectAllArticles()메소드를 호출해
//전체 글을 DB로부터 검색해서 가져 오는 역할을 함.
public class BoardService {

	BoardDAO boardDAO;
	//생성자 호출시 BoardDAO객체를 생성하여 저장
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	//BoardController에서 호출한 메소드로써
	//글쓰기 창에서 입력된 정보를 ArticleVO객체 설정한후 매개변수로 전달 받아..
	//다시 ~ BoardDAO객체의 insertNewArticle()메소드를 호출하면서
	//추가할 새글정보(ArticleVO객체)를 인자로 전달하여
	//DB에  INSERT작업을 하게됨
	public void addArticle(ArticleVO article){//DB에 글 추가를 명령하는 메소드
		boardDAO.insertNewArticle(article);
	}
	
	public List<ArticleVO> listArticles(){
		//BoardDAO의 selectAllArticles()메소드를 호출해서 전체글을 DB로부터 검색해옴
		List<ArticleVO> articleList = boardDAO.selectAllArticles(); 
		return articleList;
	}
	/*
	 여기서 잠깐! 쉬어가기!
	 BoardDAO 클래스의 메서드 이름은 보통 각메서드들이 실행하는 SQL문에 의해 결정됩니다.
	 예를 들어 selectAllArticles()메소드는 전체 글 정보를 조회하는 SQL문을 실행하므로 메서드 이름에
	 selectAll이 들어 갑니다.
	 */	
}






