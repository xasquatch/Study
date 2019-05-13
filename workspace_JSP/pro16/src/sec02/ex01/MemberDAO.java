package sec02.ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	
	
	
	public MemberDAO() {
	
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//서블릿에서 전달된 아이디값을 SQL문의 조건식에 설정한 후 ID에 대한 회원정보를 조회해서
	//그 결과를 true또는 false로 반환함
	public boolean overlappedID(String id) {
		boolean result = false;
		try {
			//커넥션풀에서 커넥션 얻기
			con = dataFactory.getConnection();
			//오라클의 decode()함수를 이용하여 서블릿에서 전달된 ID에 해당하는 데이터를 검색하여
			//true또는 false를 반환
			//검색한 갯수가 1(검색한 레코드가 존재)이면  true를 반환
			//존재하지 않으면 false를 문자열로 반환하는 SQL구문 작성
			String query = "SELECT decode(count(*),1,'true','false') as result from t_member where id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);		
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			result = Boolean.parseBoolean(rs.getString("result"));
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}
