package sec01.ex01;

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
	private static final String driver = "oracle.jdbc.driver.OracleDriver.class";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "scott";
	private static final String pwd = "tiger";

	// 위 네가지 설정값을 이용해서 오라클 DB와 접속한 정보를 지니고 있는 Connection객체를 저장할 변수 선언
	private Connection con;

	// DB와 접속 후 우리가 만들 SQL문을 생성 후 실행할 실행 객체를 담을 변수 선언
	private Statement stmt;

	private void connDB() {
		// 2.드라이버 로딩
		// OracleDriver.class 실행팡리(오라클드라이버) 로딩
		try {
			Class.forName(driver);

			// 3. DB와 Connection 맺기 (Connection객체 얻기)

			con = DriverManager.getConnection(url, user, pwd);

			// 4. Statement(SQL문을 오라클DB에 전달하여 실행할 객체) 얻기
			stmt = con.createStatement();

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

			// 6.Query문 오라클DB에 전송하기

			ResultSet rs = stmt.executeQuery(query);

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
			stmt.close();
			con.close();

		} catch (Exception e) {

			e.printStackTrace();

		}
			return list;	//DB로 부터 검색한 레코드의 개수 만큼 MemberVO객체들이 저장되어 있는
							//ArrayList 배열공간 자체를 반환함.
	}

}
