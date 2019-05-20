package board;

import java.lang.reflect.GenericArrayType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import board.BoardBean;;


public class BoardDAO {

	private Connection getConnection() throws Exception{
		Connection con = null;
		
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/bjb_db");
		con = ds.getConnection();
		return con;
	}
	
	// �Խ��� �� �߰�
	public void insertBoard(BoardBean bBean){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="";
		int num=0; // �� ��ȣ ����
		
		try {
			con = getConnection();
			
			sql = "select max(num) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				num = rs.getInt(1)+1;  // ���� ���� ��� �ִ밪 + 1
			}
			else{
				num = 1; // ���� ���� ���
			}
			sql = "insert into board(num,name,passwd,subject,content,file,"
				  + "re_ref,re_lev,re_seq,readcount,date,ip)"
				  + " values(?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, bBean.getName());
			pstmt.setString(3, bBean.getPasswd());
			pstmt.setString(4, bBean.getSubject());
			pstmt.setString(5, bBean.getContent());
			pstmt.setString(6, bBean.getFile());
			pstmt.setInt(7, num);
			pstmt.setInt(8, bBean.getRe_lev());  // ��������
			pstmt.setInt(9, bBean.getRe_seq());
			pstmt.setInt(10, 0); // ��ȸ��
			pstmt.setTimestamp(11, bBean.getDate());
			pstmt.setString(12, bBean.getIp());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	// �Խ��ǿ� ����� ��ü �� ���� ���ϴ� �޼ҵ�
	public int getBoardCount(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int count = 0;
		try {
			con = getConnection();
			sql = "select count(*) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
				count = rs.getInt(1);
			
		} catch(Exception e){
			e.printStackTrace();
			
		} finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return count;
	}
	
	// �Խ��� �� ��� �������� �۾�
	public List<BoardBean> getBoardList(int startRow,int pageSize){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		List<BoardBean> boardList = new ArrayList<BoardBean>();
		
		try {
			con = getConnection();
			sql = "select * from board order by re_ref desc, re_seq asc limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				BoardBean bBean = new BoardBean();
				bBean.setContent(rs.getString("content"));
				bBean.setDate(rs.getTimestamp("date"));
				bBean.setFile(rs.getString("file"));
				bBean.setIp(rs.getString("ip"));
				bBean.setName(rs.getString("name"));
				bBean.setNum(rs.getInt("num"));
				bBean.setPasswd(rs.getString("passwd"));
				
				bBean.setRe_lev(rs.getInt("re_lev"));
				bBean.setRe_ref(rs.getInt("re_ref"));
				bBean.setRe_seq(rs.getInt("re_seq"));
				bBean.setReadcount(rs.getInt("readcount"));
				bBean.setSubject(rs.getString("subject"));
				
				boardList.add(bBean);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return boardList;
	}
	
	
	///////////////////////////////
	public List<BoardBean> getBoardList(int startRow,int pageSize,String search){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		List<BoardBean> boardList = new ArrayList<BoardBean>();
		
		try {
			con = getConnection();
			sql = "select * from board where subject like ? order by re_ref desc,re_seq asc limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, pageSize);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				BoardBean bBean = new BoardBean();
				bBean.setContent(rs.getString("content"));
				bBean.setDate(rs.getTimestamp("date"));
				bBean.setFile(rs.getString("file"));
				bBean.setIp(rs.getString("ip"));
				bBean.setName(rs.getString("name"));
				bBean.setNum(rs.getInt("num"));
				bBean.setPasswd(rs.getString("passwd"));
				
				bBean.setRe_lev(rs.getInt("re_lev"));
				bBean.setRe_ref(rs.getInt("re_ref"));
				bBean.setRe_seq(rs.getInt("re_seq"));
				bBean.setReadcount(rs.getInt("readcount"));
				bBean.setSubject(rs.getString("subject"));
				
				boardList.add(bBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return boardList;
	}
	
	/////////////////////////////////
	// �� �󼼺��� ��ȸ�� ���� �޼���
	public void updateReadCount(int num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			con = getConnection();
			sql = "update board set readcount=readcount+1 where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}
	
	// �Խ��� �� ����
	public int deleteBoard(int num, String passwd){
		int check = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			con = getConnection();
			sql = "select passwd from board where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				// ��й�ȣ�� ������
				if(passwd.equals(rs.getString("passwd"))){
					check = 1;
					sql = "delete from board where num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, num);
					pstmt.executeUpdate();
				}else // ��й�ȣ�� Ʋ�� ���
					check=0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return check;
		
	}
	
	// ������ �� ����(BoardBean)��ü�� ���޹޾� DB�� �ִ� �н������ ��ġ �� �� ����
	public int updateBoard(BoardBean bBean){
		int check = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			con = getConnection();
			sql = "select passwd from board where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bBean.getNum());
			rs = pstmt.executeQuery();
			if(rs.next()){
				// ��й�ȣ�� ������
				if(bBean.getPasswd().equals(rs.getString("passwd"))){
					check = 1;
					sql = "update board set name=?,subject=?,content=? where num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, bBean.getName());
					pstmt.setString(2, bBean.getSubject());
					pstmt.setString(3, bBean.getContent());
					pstmt.setInt(4, bBean.getNum());
					
					pstmt.executeUpdate();
				}else // ��й�ȣ�� Ʋ�� ���
					check=0;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return check;
	}
	
	
	// �亯�ޱ� �޼ҵ�
	// �θ���� re_ref(�׷�),re_seq,re_lev��  + �亯�� ����
	public void reInsertBoard(BoardBean bBean){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int num = 0;
		
		try {
			con = getConnection();
			// ���� �� �� num�� ���� ū �۹�ȣ ��������
			sql = "select max(num) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){ // �� ��ȣ�� ������
				num = rs.getInt(1)+1; // �亯�� ��ȣ = ���� �۹�ȣ+1
			}
			else{ // �� ��ȣ�� ������
				num = 1;
			}
			// re_seq ��� ���� ���ġ
			// �θ�� �׷�� ���� �׷��̸鼭 �θ���� seq�� ���� ū �亯�۵��� seq�� 1 ����
			sql = "update board set re_seq=re_seq+1 where re_ref=? and re_seq>?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bBean.getRe_ref()); // �θ�� �׷��ȣ
			pstmt.setInt(2, bBean.getRe_seq()); // �θ���� �� �Է� ����
			pstmt.executeUpdate();
			
			
			// �亯�� �ޱ�
			sql = "insert into board values(?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, bBean.getName());
			pstmt.setString(3, bBean.getPasswd());
			pstmt.setString(4, bBean.getSubject());
			pstmt.setString(5, bBean.getContent());
			pstmt.setString(6, bBean.getFile());
			pstmt.setInt(7, bBean.getRe_ref());
			pstmt.setInt(8, bBean.getRe_lev()+1);
			pstmt.setInt(9, bBean.getRe_seq()+1);
			pstmt.setInt(10, 0); // readcount ��ȸ �� 
			pstmt.setTimestamp(11, bBean.getDate());
			pstmt.setString(12, bBean.getIp());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	
	// �� �ϳ��� �˻��ؼ� ����������
	public BoardBean getBoard(int num) {
		
		//�Ű����� ���ڷ� ���޹��� �۹�ȣ�� ���ؼ� DB�� select�� �ϳ��� �������� ������ DTO��ü ����
		BoardBean dto  = new BoardBean();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			//DB����
			con = getConnection();
			//�Ű����� ���ڷ� ���޹��� �۹�ȣ�� �ش��ϴ� �ϳ��� ���� �˻��ϴ� SQL���� �����
			sql = "select * from board where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			// �˻��� ������ ������ �ִ� rs���� �̾Ƴ��� DTO����´�.
			dto.setNum(rs.getInt("num"));
			dto.setName(rs.getString("name"));
			dto.setSubject(rs.getString("subject"));
			dto.setContent(rs.getString("content"));
			dto.setReadcount(rs.getInt("readcount"));
			dto.setRe_ref(rs.getInt("re_ref"));
			dto.setRe_lev(rs.getInt("re_lev"));
			dto.setRe_seq(rs.getInt("re_seq"));
			dto.setDate(rs.getTimestamp("date"));
			
		
		} catch (Exception e) {
			System.out.println("getBoard()�޼ҵ� ���ο��� ����  : " + e);
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			//�ڿ����� 
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return dto; //DTO��ü ����
	}

	
	// �˻�� �ش��ϴ� �� ������ DB�κ��� ������ �� ���� ����
	public int getCount(String search){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int count = 0;
		
		try {
			con = getConnection();
			// ���� �� �� num�� ���� ū �۹�ȣ ��������
			sql = "select count(*) from board where subject like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			rs = pstmt.executeQuery();
			
			if(rs.next()) // �� ��ȣ�� ������
				count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return count;
	}
	
	
	
	
	
}
