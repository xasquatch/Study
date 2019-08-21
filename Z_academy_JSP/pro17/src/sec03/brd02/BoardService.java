package sec03.brd02;

import java.util.List;

//BoardDAO ��ü�� �������� selectAllArticles()�޼ҵ带 ȣ����
//��ü ���� DB�κ��� �˻��ؼ� ���� ���� ������ ��.
public class BoardService {

	BoardDAO boardDAO;
	//������ ȣ��� BoardDAO��ü�� �����Ͽ� ����
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	//BoardController���� ȣ���� �޼ҵ�ν�
	//�۾��� â���� �Էµ� ������ ArticleVO��ü �������� �Ű������� ���� �޾�..
	//�ٽ� ~ BoardDAO��ü�� insertNewArticle()�޼ҵ带 ȣ���ϸ鼭
	//�߰��� ��������(ArticleVO��ü)�� ���ڷ� �����Ͽ�
	//DB��  INSERT�۾��� �ϰԵ�
	public void addArticle(ArticleVO article){//DB�� �� �߰��� ����ϴ� �޼ҵ�
		boardDAO.insertNewArticle(article);
	}
	
	public List<ArticleVO> listArticles(){
		//BoardDAO�� selectAllArticles()�޼ҵ带 ȣ���ؼ� ��ü���� DB�κ��� �˻��ؿ�
		List<ArticleVO> articleList = boardDAO.selectAllArticles(); 
		return articleList;
	}
	/*
	 ���⼭ ���! �����!
	 BoardDAO Ŭ������ �޼��� �̸��� ���� ���޼������ �����ϴ� SQL���� ���� �����˴ϴ�.
	 ���� ��� selectAllArticles()�޼ҵ�� ��ü �� ������ ��ȸ�ϴ� SQL���� �����ϹǷ� �޼��� �̸���
	 selectAll�� ��� ���ϴ�.
	 */	
}






