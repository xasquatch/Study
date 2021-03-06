package sec04.ex03;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//오라클 DBMS의 데이터베이스와 연결하여 작업할 클래스
public class MemberDAO {

	private Connection con;
	private PreparedStatement pstmt;
	// 커넥션풀을 저장할 변수 추가
	private DataSource dataFactory;

	// 생성자 추가
	public MemberDAO() {
		try {
			// 톰캣이 실행되면 context.xml의 <Resource>태그를 읽어와서
			// 메모리에 프로젝트별로 Context객체들을 생성합니다.
			// 이 때 InitialContext객체가 하는 역할은 톰캣 실행시 context.xml에서 생성된
			// Context객체들에 접근을 하는 역할을 합니다.
			Context ctx = new InitialContext();

			// JNDI방법으로 접근하기 위해 기본경로("java:/comp/env")를 지정합니다.
			// lookup("java:/comp/env")는 환경설정에 관련된 컨텍스트 객체에 접근하기 위한 기본 주소 입니다.
			Context envContext = (Context) ctx.lookup("java:/comp/env");

			// 그런 후 다시 톰캣 context.xml에 설정된 <Resource name = "jdbc/oracle">태그의
			// name속성값 "jdbc/oracle"을 이용해 톰캣이 미리 연결한 DataSource객체(커넥션을 역할을 하는 개체)
			// 를 받아옵니다.
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DB의 회원 정보 검색을 담당하는 메소드
	public ArrayList listMembers() {

		//DB로부터 회원정보를 검색하여 검색한 한줄 한줄의 데이터들을 각각의 MemberVO객체틀에 저장함.
		//각각의 MemberVO객체들을 ArrayList라는 가변길이 배열공간에 추가하여 저장함.
		//ArrayList배열에 저장하기 위해 객체 생성
		ArrayList list = new ArrayList();

		try {
			// 커넥션풀에서 미리 DB와 연결을 맺은 Connection객체를 빌려온다.
			// 요약 : DataSource(커넥션풀)을 이용해 데이터베이스에 연결합니다.
			con = dataFactory.getConnection();

			// 5.Query문 작성
			String query = "select * from t_member";

//			수정4. prepareStatement()메소드에 SQL문을 전달해 
//					?를 제외한 SQL문을 담은 OraclePreparedStatementWrapper실행객체얻기

			pstmt = con.prepareStatement(query);

//			수정5. 주석처리
			// 6.Query문 오라클DB에 전송하기
//			ResultSet rs = stmt.executeQuery(query);

//			수정6. 수정5를 아래와 같이 변경
//			위 select구문 실행 후 검색한 결과를 OracleResultSetImpl객체로 받아오기
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				// 7.SELECT문일 경우 검색한 결과값을 저장할 공간이 필요한데
				// 그 임시 저장할 공간이 ResultSet객체인 것이다.
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");

				// 위변수에 저장된 컬럼값을 다시 MemberVO객체를 생성해 그 객체 내부에 있는 각 변수에 저장
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);

				// 설정된 MemberVo객체를 다시 ArrayList배열에 추가하여 저장함.
				list.add(vo);

			} // while반복문의 끝

			// 8.자원해제
			rs.close();
//			수정7. stmt를 pstmt로 변경
//			stmt.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return list; // DB로 부터 검색한 레코드의 개수 만큼 MemberVO객체들이 저장되어 있는
						// ArrayList 배열공간 자체를 반환함.
	}

	// memberForm.html에서 입력한 회원가입 내용을 서블릿으로부터 전달받아 DB에 추가하는 메소드
	public void addMember(MemberVO vo) {// insert
		try {
			//DataSource커넥션풀을 이용해 데이터베이스와 접속한다.
			con = dataFactory.getConnection();
			//DB의 테이블에 insert할 입력한 회원정보를 MemberVO객체로부터 얻기
			String id = vo.getId();
			String pwd = vo.getPwd();
			String name = vo.getName();
			String email = vo.getEmail();
			//insert구문을 문자열로 만듭니다.
			String query = "INSERT INTO t_member(id,pwd,name,email)values(?,?,?,?)";
			//?를 제외한 insert전체문장을 저장한 PreparedStatement객체를 얻는다.
			pstmt = con.prepareStatement(query);
			//PreparedStatement객체에 나머지 ????값들을 위의 우리가 입력한 값으로 셋팅함.
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			//PreparedStatement객체를 이용하여 DB에 insert실행
			pstmt.executeUpdate(); //수정, 삭제, 추가

			
			
			//객체자원해제
			pstmt.close();
			con.close(); //Connection객체를 커넥션풀에 반납
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//addMember메소드 끝


	public void delMember(String id) {
		try {
			//DataSource커넥션풀을 이용해 데이터베이스와 접속한다.
			con = dataFactory.getConnection();
			//delete문을 문자열로 만듭니다.
			String query = "DELETE FROM t_member WHERE id = ?";
			//?를 제외한 delete문장을 저장한 PreparedStatement <---DELETE실행 객체에 담아
			pstmt = con.prepareStatement(query);
			//PreparedStatement객체에 나머지 ????값들을 위의 우리가 입력한 값으로 셋팅함.
			pstmt.setString(1, id);
			
			//DELETE문장을 DB에 전달하여 실행
			pstmt.executeUpdate(); //수정, 삭제, 추가

			
			
			//객체자원해제
			pstmt.close();
			con.close(); //Connection객체를 커넥션풀에 반납
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
