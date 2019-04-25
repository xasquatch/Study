package mybean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbcp.DBConnectionMgr;

//DB와 연결하여 작업하는 역할을 하는 클래스
//
public class SawonDAO {
	// DB작업 관련 삼ㅊ..사 객체를 저장할 변수 선언
	private Connection con = null; // DB연결 및 DB접속 정보를 가지고 있는 객체
	private ResultSet rs = null; // SELECT 실행후 검색한 결과를 저장할 임시 저장소 역할 객체
	private PreparedStatement pstmt = null;
	private DBConnectionMgr pool;

	// 생성자를 통한 커넥션풀 객체 얻어오기
	public SawonDAO() {
		try {
			pool = DBConnectionMgr.getInstance();

		} catch (Exception e) {
			System.out.println("connectionpool error");
		}
	}

	/* DB로부터 모든 사원 레코드를 검색하는 메소드 */
	// index.jsp에서 요청한 검색기준 필드값과 검색어를 메소드의 매개변수로 전달받아
	// 검색어가 없으면 모든 사원레코드를 검색할 수 있게끔 하는 메소드
	public List getList(String key, String text) {
		// DB로부터 검색된 데이터를 저장할 용도의 ArrayList컬렉션 프레임웍을 생성
		ArrayList list = new ArrayList<>();

		// SELECT구문을 저장할 변수 선언
		String sql = "";

		try {
			con = pool.getConnection();

			// 검색어가 입력되어 있지 않다면?
			if (text == null || text.isEmpty()) {
				sql = "SELECT * FROM tblsawon";

				// 입력되었다면?
			} else {
				sql = "SELECT * FROM tblsawon WHERE " + key + " LIKE '%" + text + "%'";
			}
			// SELECT구문을 실행할 preparedStatement 실행 객체 얻기
			pstmt = con.prepareStatement(sql);

			// SELECT구문 실행 후 검색한 결과의 테이블 형식의 구조(resultset객체)로 저장
			rs = pstmt.executeQuery();

			// DB로부터 검색한 사원레코드들은 REsultSet객체에 테이블 형식의 구조로 저장되어 있음
			// Resultset객체에 검색한 사원레코드가 존재하는 동안 반복
			while (rs.next()) {

				int no = rs.getInt("no");
				String id = rs.getString("id");
				String name = rs.getString("name");
				String pass = rs.getString("pass");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				String extension = rs.getString("extension");
				String dept = rs.getString("dept");

				// dto객체 생성하여 resultset객체의 한줄 단위로 얻는 정보 저장
				SawonDTO dto = new SawonDTO(no, id, name, pass, age, addr, extension, dept);

				// 검색한 한 사원의 정보는 SawonDTO객체에 저장되어 있으므로
				// 한명의 사원정보씩 ArrayList가변길이 배열에 추가하여 저장
				list.add(dto);

			} // end - while문

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			pool.freeConnection(con, pstmt, rs);
		}

		return list;//getList()메소드를 호출한 장소로 리턴
	}// end - getList

}// end Class - SawonDAO
