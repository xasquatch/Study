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

//DB작업 하는 클래스 
public class BoardDAO {

	DataSource dataFactory;
	Connection conn;
	PreparedStatement pstmt;
	
	//생성자 :  커넥션풀 얻기
	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext= (Context)ctx.lookup("java:/comp/env");
			//커넥션풀 얻기
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//생성자 끝
	
	//BoardService클래스에서 BoardDAO의 selectAllArticles()메소드를 호출하면
	//계층형 SQL문을 이용해 계층형 구조로 전체글을 조회한 후 반환하는 메소드 
	public List selectAllArticles(){
		
		List articlesList = new ArrayList();
		
		try {
			//커넥션풀에서 커넥션 얻기
			conn = dataFactory.getConnection();
			//계층형 구조로 전체 글을 조회하는 오라클의 계층형SQL문
			String query = "SELECT LEVEL,articleNo,parentNo,title,content,id,writeDate"
					     + " from t_board"
					     + " START WITH parentNo=0"
					     + " CONNECT BY PRIOR articleNo=parentNo"
					     + " ORDER SIBLINGS BY articleNo DESC";
			/*
				위 SELELCT구문 참고 설명
				
				1. 먼저 START WITH parentNO=0
				-> parentNO의 값이 0인 글이 최상위  계층이다라는 의미를 부여.
				-> parentNO가 0이면 그 글은 최상위 부모글이 되는 것임.
				
				2. CONNECT BY PRIOR artocleNO=parentNO
				-> 각 글이 어떤 부모글과 연결되는지를 나타냅니다.
				
				3. ORDER SIBLINGS BY articleNO DESC
				-> 계층 구조로 조회된 글을 articleNO 으로 내림차순 정렬 하여 검색
				
				4. SELECT문의 LEVEL은 계층형 SQL문 실행시,
				   CONNECT BY PRIOR artocleNO=parentNO로 글이 나열되면서 각 글의 깊이를 나타냅니다.
				     오라클에서 알아서 부모글에 대해서 깊이를 계산해서 LEVEL로 반환합니다.
				
				5. 따라서 계층형 SQL문을 실행하면 오라클이 전체 글에 대해서 내부적으로 모든 글의 articleNo에 대하여
				   다른 글들의 parentNo와 비교해서 같으면 그 글들을 parentNo의 글 아래 정렬한후,
				  articleNo를 기준으로 내림차순으로 정렬하여 검색하는 과정을 거침.
			*/
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int level = rs.getInt("level"); //각글의 깊이(계층)를 level변수에 저장
				int articleNO = rs.getInt("articleNo");//글번호는 숫자형이므로  getInt()로 가져옴
				int parentNO = rs.getInt("parentNo");//부모글번호
				String title = rs.getString("title");//글제목
				String content = rs.getString("content");//글내용
				String id = rs.getString("id");//글쓴사람의 ID
				Date writeDate = rs.getDate("writeDate"); //글쓴 날짜 
				
				//검색한 글정보를 ArticleVO객체의 각변수(속성)에 저장합니다.
				ArticleVO article = new ArticleVO();
				article.setLevel(level);
				article.setArticleNo(articleNO);
				article.setParentNo(parentNO);
				article.setTitle(title);
				article.setContent(content);
				article.setId(id);
				article.setWriteDate(writeDate);				
				//ArrayList에  ArticleVO객체 추가
				articlesList.add(article);
			}
			//자원해제
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//ArrayList반환
		return articlesList;
	}
	
	
	
}//BoardDAO클래스 끝






