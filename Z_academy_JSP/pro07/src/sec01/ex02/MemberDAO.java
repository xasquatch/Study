package sec01.ex02;

import java.sql.*;
import java.sql.Date;
import java.util.*;

//오라클 DBMS의 데이터베이스와 연결하여 작업할 클래스
public class MemberDAO {

	// 1. import java.sql.* 와 오라클 DBMS의 데이터베이스와의 연결할 네 가지 정보 설정하기
	// 드라이버명 → oracle.jdbc.driver.OracleDriver.class
	// DB접속 주소 정보 → jdbc:oracle:thin:@ip주소:포트번호:SID정보
	// DB접속시 사용자 아이디 → scott(우리가 설정한)
	// DB접속시 사용자 비밀번호→ tiger(우리가 설정한)

	// OracleDriver.class실행파일(오라클 드라이버)을 통해
	// 오라클DB와 프로젝트에 있는 MemberDAO파일과 연결할 수 있다.
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "scott";
	private static final String pwd = "tiger";

	// 위 네가지 설정값을 이용해서 오라클 DB와 접속한 정보를 지니고 있는 Connection객체를 저장할 변수 선언
	private Connection con;

	// DB와 접속 후 우리가 만들 SQL문을 생성 후 실행할 실행 객체를 담을 변수 선언

//	수정1. 주석처리
//	private Statement stmt;
//	수정2. Statement인터페이스를 구현한 객체를 대신해서 PreparedStatement인터페이스를 사용하기 위해 변수 선언
	private PreparedStatement pstmt;
	
	private void connDB() {
		// 2.드라이버 로딩
		// OracleDriver.class 실행팡리(오라클드라이버) 로딩
		
		try {
			//*오라클 드라이버를 JVM메모리에 로딩
			//자바 파일과 오라클 DB와의 연동을 위해
			//forName("오라클드라이버 파일이 있는 주소 문자열명")를 이용하여
			//OracleDriver클래스에 대한 인스턴스를 동적으로 생성해서 JVM이 차지하고 있는 메모리 중
			//DriverManager클래스에 로드합니다.
			Class.forName(driver);
			//참고 : 자바 리플렉션 사용법 숙지
			
			// 3. DB와 Connection 맺기 (Connection객체 얻기)
			/*JVM에 로딩된 오라클 드라이버를 통하여 DB와 접속하여
			DB접속한 정보를 가지고 있는 T4CConnection객체 얻기
			Class.forName(driver);메소드를 이용하여 동적으로 생성된 new OracleDriver()인스턴스는
			DriverManager클래스에 등록이 되어있으므로 이 드라이버 인스턴스를 통하여
			자바파일과 오라클 DB와 접속을 의미하는 T4CConnection인스턴스를 얻어 con변수에 저장함
			*/
			con = DriverManager.getConnection(url, user, pwd);

			// 4. Statement(SQL문을 오라클DB에 전달하여 실행할 객체) 얻기

//			수정3. 주석처리
//			stmt = con.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// connDB()

	// DB의 회원 정보 검색을 담당하는 메소드
	public ArrayList listMembers() {

		ArrayList list = new ArrayList();

		try {
			// 네 가지 정보(오라클 드라이버, 오라클 DB접속 주소, 오라클 DB접속 ID, 오라클 DB접속 pwd)로 DB를 연결.
			connDB();
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
			return list;	//DB로 부터 검색한 레코드의 개수 만큼 MemberVO객체들이 저장되어 있는
							//ArrayList 배열공간 자체를 반환함.
	}

}
