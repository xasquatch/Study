package sec03.brd01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//DB�۾� �ϴ� Ŭ���� 
public class BoardDAO {

	DataSource dataFactory;
	Connection conn;
	PreparedStatement pstmt;
	
	//������ :  Ŀ�ؼ�Ǯ ���
	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext= (Context)ctx.lookup("java:/comp/env");
			//Ŀ�ؼ�Ǯ ���
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//������ ��
	
	//BoardServiceŬ�������� BoardDAO�� selectAllArticles()�޼ҵ带 ȣ���ϸ�
	//������ SQL���� �̿��� ������ ������ ��ü���� ��ȸ�� �� ��ȯ�ϴ� �޼ҵ� 
	public List selectAllArticles(){
		
		List articlesList = new ArrayList();
		
		try {
			//Ŀ�ؼ�Ǯ���� Ŀ�ؼ� ���
			conn = dataFactory.getConnection();
			//������ ������ ��ü ���� ��ȸ�ϴ� ����Ŭ�� ������SQL��
			String query = "SELECT LEVEL,articleNo,parentNo,title,content,id,writeDate"
					     + " from t_board"
					     + " START WITH parentNo=0"
					     + " CONNECT BY PRIOR articleNo=parentNo"
					     + " ORDER SIBLINGS BY articleNo DESC";
			/*
				�� SELELCT���� ���� ����
				
				1. ���� START WITH parentNO=0
				-> parentNO�� ���� 0�� ���� �ֻ���  �����̴ٶ�� �ǹ̸� �ο�.
				-> parentNO�� 0�̸� �� ���� �ֻ��� �θ���� �Ǵ� ����.
				
				2. CONNECT BY PRIOR artocleNO=parentNO
				-> �� ���� � �θ�۰� ����Ǵ����� ��Ÿ���ϴ�.
				
				3. ORDER SIBLINGS BY articleNO DESC
				-> ���� ������ ��ȸ�� ���� articleNO ���� �������� ���� �Ͽ� �˻�
				
				4. SELECT���� LEVEL�� ������ SQL�� �����,
				   CONNECT BY PRIOR artocleNO=parentNO�� ���� �����Ǹ鼭 �� ���� ���̸� ��Ÿ���ϴ�.
				     ����Ŭ���� �˾Ƽ� �θ�ۿ� ���ؼ� ���̸� ����ؼ� LEVEL�� ��ȯ�մϴ�.
				
				5. ���� ������ SQL���� �����ϸ� ����Ŭ�� ��ü �ۿ� ���ؼ� ���������� ��� ���� articleNo�� ���Ͽ�
				   �ٸ� �۵��� parentNo�� ���ؼ� ������ �� �۵��� parentNo�� �� �Ʒ� ��������,
				  articleNo�� �������� ������������ �����Ͽ� �˻��ϴ� ������ ��ħ.
			*/
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int level = rs.getInt("level"); //������ ����(����)�� level������ ����
				int articleNO = rs.getInt("articleNo");//�۹�ȣ�� �������̹Ƿ�  getInt()�� ������
				int parentNO = rs.getInt("parentNo");//�θ�۹�ȣ
				String title = rs.getString("title");//������
				String content = rs.getString("content");//�۳���
				String id = rs.getString("id");//�۾������ ID
				Date writeDate = rs.getDate("writeDate"); //�۾� ��¥ 
				
				//�˻��� �������� ArticleVO��ü�� ������(�Ӽ�)�� �����մϴ�.
				ArticleVO article = new ArticleVO();
				article.setLevel(level);
				article.setArticleNo(articleNO);
				article.setParentNo(parentNO);
				article.setTitle(title);
				article.setContent(content);
				article.setId(id);
				article.setWriteDate(writeDate);				
				//ArrayList��  ArticleVO��ü �߰�
				articlesList.add(article);
			}
			//�ڿ�����
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//ArrayList��ȯ
		return articlesList;
	}
	
	
	
}//BoardDAOŬ���� ��






