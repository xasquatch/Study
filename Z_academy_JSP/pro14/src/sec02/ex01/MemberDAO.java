package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class MemberDAO {

	//DB관련 작업에 필요한 삼총사? 객체를 저장할 변수 선언	★★★★☆(삼총사:Connection,PreparedStatement,ResultSet)
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//커넥션풀 (DataSource)객체를 저장할 변수 선언 ★★★★☆
	private DataSource ds;
	
	//커넥션풀객체를 얻을 생성자


	public MemberDAO() {
		
		try {
		//톰캣이 실행되면 context.xml의 <Resource>설정을 읽어와서
		//메모리에 프로젝트 별로 Context객체들을 생성합니다.
		//이 때 InitialContext객체가 하는 역할은 톰캣 실행시 context.xml에 의해서 생성된
		//Context객체들에 접근을 하는 역할을 합니다.
			Context ctx = new InitialContext();
			
			//JNDI방법으로 접근하기 위해 기본경로(java:/comp/env)를 지정합니다.
			//lookup("java:/comp/env")는 그 중 환경설정에 관련된 컨텍스트 객체에 접근하기 위한 기본주소입니다.
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			
			//그런 후 다시 톰캣 context.xml에 설정한 Resource name = "jdbc/oracle"> 태그의
			//name속성값 jdbc/oracle 문자열을 이용하여 톰캣이 미리 DB에 연결설정해놓은
			//DataSource(커넥션풀)객체를 받아옵니다.
			/*커넥션풀 얻기*/
			ds = (DataSource)envContext.lookup("jdbc/oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//end - MemberDAO 생성자 종료



	//DB에 회원정보를 추가하는 메소드
	public void addMember(MemberBean bean){
		try {
			//DataSource(커넥션풀)를 이용해 데이터베이스 접속객체얻기
			Connection con = ds.getConnection();
			
			//매개변수로 전달받은 우리가 입력한 MemberBean객체의 getter메소드를 호출하여
			//각변수에 저장된 값을 얻는다.
			
			String id = bean.getId();
			String pwd = bean.getPwd();
			String name = bean.getName();
			String email = bean.getEmail();
			
			String query = "INSERT INTO t_member(id,pwd,name,email) values(?,?,?,?)";
			
			//?를 제외한 INSERT문장을 임시로 OraclePrepardStatementWrapper실행객체에 담아
			//OraclePrepardStatementWrapper실행객체 자체를 리턴받습니다.
			pstmt = con.prepareStatement(query);
			
			//OraclePrepardStatementWrapper실행객체에 나머지 ?,?,?,?값을 위의 각 변수의 값으로 세팅
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			//OraclePrepardStatementWrapper실행객체를 이용하여 DB에 insert실행
			pstmt.executeUpdate();

			//OraclePrepardStatementWrapper실행객체 사용 후 자원해제
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//end - addMember()
	
	
	public List listMember(){//DB에 저장되어 있는 모든 회원정보를 조회(검색)하는 메소드
		
		//DB에 모든 회원정보를 검색하여 저장할 가변길이 백열공간
		List list = new ArrayList();
		
		try {
			//커넥션풀에서 커넥션객체 얻기(DB접속)
			con = ds.getConnection();
			//회원정보를 최근 가입일순으로 내림차순 정렬하여 검색할 SQL문 만들기
			String query = "SELECT * FROM t_member ORDER BY joindate DESC";
			
			//?를 제외한 SQL구문을 담은 OraclePrepardStatementWrapper실행객체 얻기(위는 ? 없음)
			pstmt = con.prepareStatement(query);
			
			//위의 query변수에 저장된 select문장을 DB에 전송하여 검색한 그 결과를 MemberDAO.java페이지로 전달받기 위해
			//검색결과를 테이블 구조로 저장할 임시 저장소 역할을 하는 객체가 필요
			//그 객체가 OracleResultSetImpl 객체
			//OracleResultSetImpl객체에 검색결과를 테이블 구조 형식으로 똑같이 저장하여
			//OracleResultSetImpl객체 자체를 리턴 받는다.
			rs = pstmt.executeQuery();//검색메소드
			
			//OracleResultSetImpl객체의 구조는 테이블 구조로써
			//커서가 테이블 구조의 컬럼명이 있는 줄을 가리키고 있다.
			//rs.next()메소드를 호출하면서 커서위치가 한줄 아래로 내려오면서
			//그 다음줄에 레코드가 존재하는지 여부를 판단
			//next()메소드는 그 다음 줄의 코드가 존재하면 true값을 반환
			
			while (rs.next()) {
				//오라클 DB의 t_member테이블에 검색한 레코드의 각 컬럼값을
				//OracleResultSetImpl객체에서 꺼내와 변수에 저장
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				//검색한 회원정보를 MemberBean객체의 변수에 각각 저장한 후
				MemberBean vo = new MemberBean(id,pwd,name,email);
				vo.setJoindate(joinDate);
				
				list.add(vo);
			}
			//자원해제
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
