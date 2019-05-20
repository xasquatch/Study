package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class FileBoardDAO {

	// DB���� �޼ҵ�
	private Connection getConnection() throws Exception{
		Connection con = null;
		
		// 1.WAS������ ����� �� ������Ʈ�� ��� ������ ������ �ִ� ���ؽ�Ʈ ��ü ����
		Context init = new InitialContext();
		
		// 2.����� WAS�������� DataSource(Ŀ�ؼ�Ǯ)�˻��ؼ� ��������
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/bjb_db");
		
		// DataSource(Ŀ�ؼ�Ǯ)���� DB������ü(Ŀ�ؼ�)��������
		con = ds.getConnection(); // DB����
		
		return con;
	}
	
	// ���� �Խ��� �� �߰�
	public void insertfBoard(FileBoardDTO fileBoardDTO){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="";
		int num=0;
		
		try {
			con = getConnection();
			
			sql = "select max(num) from fboard";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				num = rs.getInt(1)+1;
			else
				num = 1;
			sql = "insert into fboard "
				  + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, fileBoardDTO.getName());
			pstmt.setString(3, fileBoardDTO.getPasswd());
			pstmt.setString(4, fileBoardDTO.getSubject());
			pstmt.setString(5, fileBoardDTO.getContent());
			pstmt.setString(6, fileBoardDTO.getFile());
			pstmt.setInt(7, num);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);
			pstmt.setTimestamp(11, fileBoardDTO.getDate());
			pstmt.setString(12, fileBoardDTO.getIp());
			
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
	
	
	// ���� �Խ��� ��ü �� ���� ���ϴ� �޼ҵ�
	public int getBoardCount(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int count = 0;
		try {
			con = getConnection();
			sql = "select count(*) from fboard";
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
	
	// ���� �Խ��� �� ��� �������� �۾�
	public List<FileBoardDTO> getBoardList(int startRow,int pageSize){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		List<FileBoardDTO> boardList = new ArrayList<FileBoardDTO>();
		
		try {
			con = getConnection();
			sql = "select * from fboard order by re_ref desc, re_seq asc limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				FileBoardDTO dto = new FileBoardDTO();
				dto.setContent(rs.getString("content"));
				dto.setDate(rs.getTimestamp("date"));
				dto.setFile(rs.getString("file"));
				dto.setIp(rs.getString("ip"));
				dto.setName(rs.getString("name"));
				dto.setNum(rs.getInt("num"));
				dto.setPasswd(rs.getString("passwd"));
				
				dto.setRe_lev(rs.getInt("re_lev"));
				dto.setRe_ref(rs.getInt("re_ref"));
				dto.setRe_seq(rs.getInt("re_seq"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setSubject(rs.getString("subject"));
				
				boardList.add(dto);
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
	
	////////////////////////////////////
	public List<BoardBean> getBoardList(int startRow, int pageSize, String search) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		List<BoardBean> boardList = new ArrayList<BoardBean>();

		try {
			con = getConnection();
			sql = "select * from fboard where subject like ? order by re_ref desc,re_seq asc limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, pageSize);
			rs = pstmt.executeQuery();

			while (rs.next()) {
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
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return boardList;
	}

	// �� �󼼺��� ��ȸ �� ���� �޼���
	public void updateReadCount(int num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			con = getConnection();
			sql = "update fboard set readcount=readcount+1 where num=?";
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
	
	// �� �ϳ��� �˻��ؼ� ����������
	public FileBoardDTO getBoard(int num) {
		
		//�Ű����� ���ڷ� ���޹��� �۹�ȣ�� ���ؼ� DB�� select�� �ϳ��� �������� ������ DTO��ü ����
		FileBoardDTO dto  = new FileBoardDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			//DB����
			con = getConnection();
			//�Ű����� ���ڷ� ���޹��� �۹�ȣ�� �ش��ϴ� �ϳ��� ���� �˻��ϴ� SQL���� �����
			sql = "select * from fboard where num=?";
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
			dto.setFile(rs.getString("file"));
			
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
	
	
	// ���� �Խ��� �� ����
	public int deletefBoard(int num, String passwd){
		int check = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			con = getConnection();
			sql = "select passwd from fboard where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				// ��й�ȣ�� ������
				if(passwd.equals(rs.getString("passwd"))){
					check = 1;
					sql = "delete from fboard where num=?";
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
		
	
	// ������ �� ����(FileBoardDTO)��ü�� ���޹޾� DB�� �ִ� �н������ ��ġ �� �� ����
	public int updatefBoard(FileBoardDTO fdto){
		int check = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			con = getConnection();
			sql = "select passwd from fboard where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, fdto.getNum());
			rs = pstmt.executeQuery();
			if(rs.next()){
				// ��й�ȣ�� ������
				if(fdto.getPasswd().equals(rs.getString("passwd"))){
					check = 1;
					sql = "update fboard set name=?,subject=?,content=?,file=? where num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, fdto.getName());
					pstmt.setString(2, fdto.getSubject());
					pstmt.setString(3, fdto.getContent());
					pstmt.setString(4, fdto.getFile());
					pstmt.setInt(5, fdto.getNum());
					
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
	public void reInsertfBoard(FileBoardDTO fdto){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int num = 0;
		
		try {
			con = getConnection();
			// ���� �� �� num�� ���� ū �۹�ȣ ��������
			sql = "select max(num) from fboard";
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
			sql = "update fboard set re_seq=re_seq+1 where re_ref=? and re_seq>?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, fdto.getRe_ref()); // �θ�� �׷��ȣ
			pstmt.setInt(2, fdto.getRe_seq()); // �θ���� �� �Է� ����
			pstmt.executeUpdate();
			
			
			// �亯�� �ޱ�
			sql = "insert into fboard values(?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, fdto.getName());
			pstmt.setString(3, fdto.getPasswd());
			pstmt.setString(4, fdto.getSubject());
			pstmt.setString(5, fdto.getContent());
			pstmt.setString(6, fdto.getFile());
			pstmt.setInt(7, fdto.getRe_ref());
			pstmt.setInt(8, fdto.getRe_lev()+1);
			pstmt.setInt(9, fdto.getRe_seq()+1);
			pstmt.setInt(10, 0); // readcount ��ȸ �� 
			pstmt.setTimestamp(11, fdto.getDate());
			pstmt.setString(12, fdto.getIp());
			
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
			sql = "select count(*) from fboard where subject like ?";
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
	
}// Ŭ���� ��
