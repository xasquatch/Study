package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {//MVC -> M의역할

	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;
	
	public MemberDAO() {//커넥션풀 (DataSource) 얻기
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			//커넥션풀을 <Resource>태그의 JNDI 이름으로 찾아 받아오기 
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
			
		} catch (Exception e) {
			System.out.println("커넥션풀 받기 실패 : " + e.getMessage());
			e.printStackTrace();
		}
	}

	public List listMembers() {//SQL문을 이용해 회원정보를 조회한 후 결과를 
							  //ArrayList로 반환하는 메소드
		
		List memberList = new ArrayList();
		
		try {
			//커넥션풀로부터 DB접속을 나타내는 객체 얻기
			conn = dataFactory.getConnection();
			//SQL구문 작성
			String query = "select * from t_member order by joinDate desc";
			//select문장을 실행할 PreparedStatement얻기
			pstmt = conn.prepareStatement(query);
			//select 실행후 그결과를 ResultSet임시저장공간에 저장하여 얻기
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				//ResultSet에서 검색한 정보를 레코드 단위로 얻기
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				//조회한 회원정보를 레코드별로 MemberVO객체의 변수에 각각 저장함.
				MemberVO memberVO = new MemberVO(id,pwd,name,email,joinDate);
				
				//memberList(ArrayList)에  MemberVO객체를 차례대로 반복문을 돌면서 저장
				memberList.add(memberVO);
			}
			//자원해제
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("listMembers()메소드에서 오류 :" + e.getMessage());
			e.printStackTrace();
		}	
		return memberList;//ArrayList리턴
	}

}






