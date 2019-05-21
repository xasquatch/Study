package mybean;

import java.sql.*;

import dbcp.DBConnectionMgr;

// 자바빈의 종류
// DAO클래스 : DB작업을 하는 클래스

public class MemberDao {

	private Connection con = null; // DB연결정보를 가지고 있는 접속객체를 저장할 변수
	private PreparedStatement pstmt; // SQL구문 실행 객체를 저장할 변수
	private ResultSet rs; // select한 결과 레코드를 임시로 저장할 ResultSet객체를 담을 변수
	private DBConnectionMgr pool; // DBCP커넥션풀 객체의 주소값을 담을 변수

	// 기본 생성자 만들기
	public MemberDao() {

		try {
			// DB와 미리 연결한 정보를 가지고 있는 객체(Connection)를 담고 있는 DBCP커넥션풀 객체 얻기
			// getInstance()메소드의 리턴값으로 DBCP커넥션풀(new DBConnectionMgr();)객체 얻기
			pool = DBConnectionMgr.getInstance();

		} catch (Exception err) {
			System.out.println("Connecion pool 얻기 실패 : " + err);

		} finally {
			pool.freeConnection(con, pstmt, rs);

		}
	}// 생성자
	
	public static MemberDao member = new MemberDao();
	public static MemberDao getInstance(){
		return member;
	}
	
	// DB에 회원 추가하는 메소드
	public void setMember(MemberDto dto) {

		String sql = "insert into member" + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			// DB연결
			con = pool.getConnection();

			// ?을 제외한 sql구문을 미리 저장하고 있는 prepareStatement객체 얻기
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, dto.getHname());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPassword1());
			pstmt.setString(4, dto.getPassword2());
			pstmt.setString(5, dto.getEmail());

			pstmt.setInt(6, dto.getBirthyear());
			pstmt.setInt(7, dto.getBirthmonth());
			pstmt.setInt(8, dto.getBirthdate());

			pstmt.setString(9, dto.getSex());
			pstmt.setString(10, dto.getEtcphone());

			pstmt.setInt(11, dto.getPostcode());
			pstmt.setString(12, dto.getAddress());
			pstmt.setString(13, dto.getAddress2());
			
			// insert 구문을 DB에 전달하여 실행
			pstmt.executeUpdate();

		} catch (Exception err) {
			System.out.println("setMember메소드에서 오류 : " + err);

		} finally {
			pool.freeConnection(con, pstmt);

		}

	}

	// DB 로그인 확인 메소드
	public int userCheck(String id, String passwd) {
		int check = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";

		try {
			// DB연결
			con = pool.getConnection();

			sql = "select * from member where id=?";

			// ?을 제외한 sql구문을 미리 저장하고 있는 prepareStatement객체 얻기
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) { // id 존재
				if (passwd.equals(rs.getString("password1")))
					check = 1;
				else
					check = 0;
			} else // id 존재 x
				check = -1;

		} catch (Exception err) {
			System.out.println("userCheck 메소드에서 오류 : " + err);

		} finally {
			pool.freeConnection(conn, pstmt, rs);

		}
		return check;
	}

	// id 이용해 현재 회원정보 불러오는 메소드
	public MemberDto getUserInfo(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberDto member = new MemberDto();
		
		try {
			String sql= "select * from member where id=?";

			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			
			if (rs.next()) // 회원정보를 DTO에 담는다.
			{
				// 정보 담기
				member.setId(rs.getString("id"));
				member.setPassword1(rs.getString("password1"));
				member.setHname(rs.getString("hname"));
				member.setSex(rs.getString("sex"));
				member.setBirthyear(rs.getInt("birthyear"));
				member.setBirthmonth(rs.getInt("birthmonth"));
				member.setBirthdate(rs.getInt("birthdate"));
				member.setEmail(rs.getString("email"));
				member.setEtcphone(rs.getString("etcphone"));
				member.setPostcode(rs.getInt("postcode"));
				member.setAddress(rs.getString("address"));
				member.setAddress2(rs.getString("address2"));
			}

		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return member;
	}

	// 회원정보 수정 메소드
	public void updateMember(MemberDto member) throws Exception{
        
        Connection conn = null;
        PreparedStatement pstmt = null;
 
        try {
 
            String sql= "update member set"
            			+ " hname=?,password1=?,password2=?,email=?,birthyear=?,birthmonth=?,birthdate=?,"
            			+ " sex=?,etcphone=?,postcode=?,address=?,address2=?"
            			+ " where id=?";
            
            conn = pool.getConnection();
            pstmt = conn.prepareStatement(sql);
 
            pstmt.setString(1, member.getHname());
            pstmt.setString(2, member.getPassword1());
            pstmt.setString(3, member.getPassword2());
            pstmt.setString(4, member.getEmail());
            pstmt.setInt(5, member.getBirthyear());
            pstmt.setInt(6, member.getBirthmonth());
            pstmt.setInt(7, member.getBirthdate());
            pstmt.setString(8, member.getSex());
            pstmt.setString(9, member.getEtcphone());
            pstmt.setInt(10, member.getPostcode());
            pstmt.setString(11, member.getAddress());
            pstmt.setString(12, member.getAddress2());
            pstmt.setString(13, member.getId());
            
            
            pstmt.executeUpdate();
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            try{
                if ( pstmt != null ){ pstmt.close(); pstmt=null; }
                if ( conn != null ){ conn.close(); conn=null;    }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
    }

	// 회원 삭제 메서드
	public int deleteMember(String id, String password) 
		throws Exception{
		
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
 
        String dbpasswd = ""; // DB상의 비밀번호를 담아둘 변수
        int x = -1;
 
        try {
            conn = pool.getConnection();
            String sql = "select password1 from member where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            
            rs = pstmt.executeQuery();
            if(rs.next()){
            	dbpasswd = rs.getString("password1");
            	if(dbpasswd.equals(password)){
            		pstmt = conn.prepareStatement("delete from member where id=?");
            		pstmt.setString(1, id);
            		pstmt.executeUpdate();
            		x=1; // 회원탈퇴 성공
            	}else
            		x=0; // 비번 틀림
            }
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            try{
                if ( pstmt != null ){ pstmt.close(); pstmt=null; }
                if ( conn != null ){ conn.close(); conn=null;    }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
		return x;
    } 

	
	// 아이디 중복체크
	public int JoinCheck(String id){ 
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		int check = 0;
		
		try {
			con = pool.getConnection();
			String sql = "select * from member where id=?";
			pre = con.prepareStatement(sql);
			pre.setString(1, id);
			rs = pre.executeQuery();
			if(rs.next()){
				check = 0;
			} else { 
				check = 1; 
			}
		} catch (Exception e) { e.printStackTrace(); }
		finally {
			if (rs != null) try {rs.close(); } catch(SQLException ex) {ex.printStackTrace(); }
			if (pre != null) try { pre.close(); } catch(SQLException ex) { ex.printStackTrace(); }
			if (con != null) try { con.close(); } catch(SQLException ex) { ex.printStackTrace(); }
		}
		return check;
		
	} 
	
	
	// 이름과 이메일 주소로 id 찾기
	public String findId(String name,String email) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String findId = null;
		
		try {
			String sql= "select id from member where hname=? and email=?";

			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				findId = rs.getString("id");
			
		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return findId;
	}
		
	
	// 아이디와 이메일 주소로 password 찾기
	public String findPw(String id,String email) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String findPw = null;
		
		try {
			String sql= "select password1 from member where id=? and email=?";

			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				findPw = rs.getString("password1");
			
		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return findPw;
	}
	
}// 클래스
