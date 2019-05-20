package mybean;

import java.sql.*;

import dbcp.DBConnectionMgr;

// �ڹٺ��� ����
// DAOŬ���� : DB�۾��� �ϴ� Ŭ����

public class MemberDao {

	private Connection con = null; // DB���������� ������ �ִ� ���Ӱ�ü�� ������ ����
	private PreparedStatement pstmt; // SQL���� ���� ��ü�� ������ ����
	private ResultSet rs; // select�� ��� ���ڵ带 �ӽ÷� ������ ResultSet��ü�� ���� ����
	private DBConnectionMgr pool; // DBCPĿ�ؼ�Ǯ ��ü�� �ּҰ��� ���� ����

	// �⺻ ������ �����
	public MemberDao() {

		try {
			// DB�� �̸� ������ ������ ������ �ִ� ��ü(Connection)�� ��� �ִ� DBCPĿ�ؼ�Ǯ ��ü ���
			// getInstance()�޼ҵ��� ���ϰ����� DBCPĿ�ؼ�Ǯ(new DBConnectionMgr();)��ü ���
			pool = DBConnectionMgr.getInstance();

		} catch (Exception err) {
			System.out.println("Connecion pool ��� ���� : " + err);

		} finally {
			pool.freeConnection(con, pstmt, rs);

		}
	}// ������
	
	public static MemberDao member = new MemberDao();
	public static MemberDao getInstance(){
		return member;
	}
	
	// DB�� ȸ�� �߰��ϴ� �޼ҵ�
	public void setMember(MemberDto dto) {

		String sql = "insert into member" + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			// DB����
			con = pool.getConnection();

			// ?�� ������ sql������ �̸� �����ϰ� �ִ� prepareStatement��ü ���
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
			
			// insert ������ DB�� �����Ͽ� ����
			pstmt.executeUpdate();

		} catch (Exception err) {
			System.out.println("setMember�޼ҵ忡�� ���� : " + err);

		} finally {
			pool.freeConnection(con, pstmt);

		}

	}

	// DB �α��� Ȯ�� �޼ҵ�
	public int userCheck(String id, String passwd) {
		int check = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";

		try {
			// DB����
			con = pool.getConnection();

			sql = "select * from member where id=?";

			// ?�� ������ sql������ �̸� �����ϰ� �ִ� prepareStatement��ü ���
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) { // id ����
				if (passwd.equals(rs.getString("password1")))
					check = 1;
				else
					check = 0;
			} else // id ���� x
				check = -1;

		} catch (Exception err) {
			System.out.println("userCheck �޼ҵ忡�� ���� : " + err);

		} finally {
			pool.freeConnection(conn, pstmt, rs);

		}
		return check;
	}

	// id �̿��� ���� ȸ������ �ҷ����� �޼ҵ�
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
			
			
			if (rs.next()) // ȸ�������� DTO�� ��´�.
			{
				// ���� ���
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

	// ȸ������ ���� �޼ҵ�
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

	// ȸ�� ���� �޼���
	public int deleteMember(String id, String password) 
		throws Exception{
		
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
 
        String dbpasswd = ""; // DB���� ��й�ȣ�� ��Ƶ� ����
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
            		x=1; // ȸ��Ż�� ����
            	}else
            		x=0; // ��� Ʋ��
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

	
	// ���̵� �ߺ�üũ
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
	
	
	// �̸��� �̸��� �ּҷ� id ã��
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
		
	
	// ���̵�� �̸��� �ּҷ� password ã��
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
	
}// Ŭ����
