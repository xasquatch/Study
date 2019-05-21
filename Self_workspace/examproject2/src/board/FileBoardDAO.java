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

	// DB연결 메소드
	private Connection getConnection() throws Exception{
		Connection con = null;
		
		// 1.WAS서버와 연결된 웹 프로젝트의 모든 정보를 가지고 있는 컨텍스트 객체 생성
		Context init = new InitialContext();
		
		// 2.연결된 WAS서버에서 DataSource(커넥션풀)검색해서 가져오기
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/bjb_db");
		
		// DataSource(커넥션풀)에서 DB연동객체(커넥션)가져오기
		con = ds.getConnection(); // DB연결
		
		return con;
	}
	
	// 파일 게시판 글 추가
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
	
	
	// 파일 게시판 전체 글 개수 구하는 메소드
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
	
	// 파일 게시판 글 목록 가져오기 작업
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

	// 글 상세보기 조회 수 증가 메서드
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
	
	// 글 하나를 검색해서 가져오는일
	public FileBoardDTO getBoard(int num) {
		
		//매개변수 인자로 전달받은 글번호를 통해서 DB에 select한 하나의 글정보를 저장할 DTO객체 생성
		FileBoardDTO dto  = new FileBoardDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			//DB연결
			con = getConnection();
			//매개변수 인자로 전달받은 글번호에 해당하는 하나의 글을 검색하는 SQL구문 만들기
			sql = "select * from fboard where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			// 검색한 정보를 가지고 있는 rs에서 뽑아내서 DTO에담는다.
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
			System.out.println("getBoard()메소드 내부에서 오류  : " + e);
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			//자원해제 
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
		return dto; //DTO객체 리턴
	}
	
	
	// 파일 게시판 글 삭제
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
				// 비밀번호가 맞으면
				if(passwd.equals(rs.getString("passwd"))){
					check = 1;
					sql = "delete from fboard where num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, num);
					pstmt.executeUpdate();
				}else // 비밀번호가 틀릴 경우
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
		
	
	// 수정할 글 정보(FileBoardDTO)객체를 전달받아 DB에 있는 패스워드와 일치 시 글 수정
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
				// 비밀번호가 맞으면
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
				}else // 비밀번호가 틀릴 경우
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

	// 답변달기 메소드
	// 부모글의 re_ref(그룹),re_seq,re_lev값  + 답변글 내용
	public void reInsertfBoard(FileBoardDTO fdto){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int num = 0;
		
		try {
			con = getConnection();
			// 기존 글 중 num이 가장 큰 글번호 가져오기
			sql = "select max(num) from fboard";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){ // 글 번호가 있으면
				num = rs.getInt(1)+1; // 답변글 번호 = 원래 글번호+1
			}
			else{ // 글 번호가 없으면
				num = 1;
			}
			// re_seq 답글 순서 재배치
			// 부모글 그룹과 같은 그룹이면서 부모글의 seq값 보다 큰 답변글들을 seq값 1 증가
			sql = "update fboard set re_seq=re_seq+1 where re_ref=? and re_seq>?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, fdto.getRe_ref()); // 부모글 그룹번호
			pstmt.setInt(2, fdto.getRe_seq()); // 부모글의 글 입력 순서
			pstmt.executeUpdate();
			
			
			// 답변글 달기
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
			pstmt.setInt(10, 0); // readcount 조회 수 
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
	
	// 검색어에 해당하는 글 개수를 DB로부터 가져와 글 개수 리턴
	public int getCount(String search){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int count = 0;
		
		try {
			con = getConnection();
			// 기존 글 중 num이 가장 큰 글번호 가져오기
			sql = "select count(*) from fboard where subject like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			rs = pstmt.executeQuery();
			
			if(rs.next()) // 글 번호가 있으면
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
	
}// 클래스 끝
