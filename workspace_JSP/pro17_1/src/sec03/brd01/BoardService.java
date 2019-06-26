package sec03.brd01;

import java.util.List;

//BoardDAO ��ü�� �������� selectAllArticles()�޼ҵ带 ȣ����
//��ü ���� DB�κ��� �˻��ؼ� ���� ���� ������ ��.
public class BoardService {

	BoardDAO boardDAO;
	//������ ȣ��� BoardDAO��ü�� �����Ͽ� ����
	public BoardService() {
		boardDAO = new BoardDAO();
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






