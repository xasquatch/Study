package myboard;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DataSource ds = null;
	
	//DB 연결 메서드
	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		ds = (DataSource)ctx.lookup("java:comp/env/jdbc/jspbeginner");
		return ds.getConnection();
	}
	
	//자원 해제 메서드
	private void freeResource() {
		try {
			if(con != null) con.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		} catch(Exception e) {
			System.out.println("freeResource()메서드에서 에러 : " + e);
		}
	}
	
	//String타입으로 받아온 시간을 Timestamp타입으로 변환해주는 메서드
	public Timestamp stringToTimestamp(String date) {
		Calendar cal;
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			sd.parse(date);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		cal = sd.getCalendar();
		return new Timestamp(cal.getTime().getTime());
	}
	
	// 하나의 판매글 정보를 Dto에 담아 리턴하는 메서드
	public BoardDto getBoard(int no) {
		BoardDto dto = new BoardDto();
		
		try {
			con = getConnection();
			
			String sql = "SELECT * FROM h_board WHERE no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setMain_img(rs.getString("main_img"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setCategory(rs.getString("category"));
				dto.setMore_category(rs.getString("more_category"));
				dto.setBin_price(rs.getInt("bin_price"));
				dto.setBid_price(rs.getInt("bid_price"));
				dto.setStart_time(rs.getTimestamp("start_time"));
				dto.setEnd_time(rs.getTimestamp("end_time"));
				dto.setArea(rs.getString("area"));
				dto.setTrade(rs.getString("trade"));
				dto.setAddress(rs.getString("address"));
				dto.setAddress2(rs.getString("address2"));
				dto.setCoords(rs.getString("coords"));
				dto.setStatus(rs.getInt("status"));
				dto.setId(rs.getString("id"));
			}
		} catch(Exception e) {
			System.out.println("getBoard()메서드에서 에러 : " + e);
		} finally {
			freeResource();
		}
		
		return dto;
	}
	
	// 게시판에 띄워줄 판매글 목록을 ArrayList로 리턴하는 메서드
	public List<BoardDto> getBoardList(int beginPerPage, int numPerPage, String searchBox, Hashtable<String, String> options) {
		List<BoardDto> li = new ArrayList<BoardDto>();
		
		try {
			con = getConnection();
			
			//-----------------쿼리문 생성-------------------//
			searchBox = searchBox.equals("null") ? "" : searchBox;
			String sql = "SELECT * FROM h_board WHERE ";
			ArrayList<String> option = new ArrayList<String>();
			Enumeration<String> e = options.keys();
			while(e.hasMoreElements()) {
				String key = e.nextElement();
				
				switch(key) {
					case "area":
					case "category":
					case "more_category":
						sql += key + "=? AND ";
						option.add(key);
						break;
					case "format":
						sql += options.get(key) + "!=0 AND ";
						break;
					case "min_price":
						sql += "(bin_price!=0 AND bin_price >= " + options.get(key) + " OR bid_price!=0 AND bid_price >= " + options.get(key) + ") AND ";
						break;
					case "max_price":
						sql += "(bin_price!=0 AND bin_price <= " + options.get(key) + " OR bid_price!=0 AND bid_price <= " + options.get(key) + ") AND ";
						break;
				}
			}
			sql += "end_time > now() AND start_time < now() AND title like '%" + searchBox + "%' ORDER BY no DESC LIMIT ?,?";
			//-----------------쿼리문 생성-------------------//
			
			pstmt = con.prepareStatement(sql);
			for (int i = 0; i < option.size(); i++) {
				pstmt.setString(i + 1, options.get(option.get(i)));
			}
			pstmt.setInt(option.size() + 1, beginPerPage);
			pstmt.setInt(option.size() + 2, numPerPage);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDto dto = new BoardDto();
				
				dto.setNo(rs.getInt("no"));
				dto.setMain_img(rs.getString("main_img"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setCategory(rs.getString("category"));
				dto.setMore_category(rs.getString("more_category"));
				dto.setBin_price(rs.getInt("bin_price"));
				dto.setBid_price(rs.getInt("bid_price"));
				dto.setStart_time(rs.getTimestamp("start_time"));
				dto.setEnd_time(rs.getTimestamp("end_time"));
				dto.setArea(rs.getString("area"));
				dto.setTrade(rs.getString("trade"));
				dto.setAddress(rs.getString("address"));
				dto.setAddress2(rs.getString("address2"));
				dto.setCoords(rs.getString("coords"));
				dto.setStatus(rs.getInt("status"));
				dto.setId(rs.getString("id"));
				
				li.add(dto);
			}
		} catch(Exception e) {
			System.out.println("getBoardList()메서드에서 에러 : " + e);
		} finally {
			freeResource();
		}
		
		return li;
	}
	
	//getBoardList 오버로딩 최신순 몇개만 뽑아 메인페이지에 띄워주는 역할을 함
	public List<BoardDto> getBoardList(int beginPerPage, int numPerPage) {
		List<BoardDto> li = new ArrayList<BoardDto>();
		
		try {
			con = getConnection();
			
			String sql = "SELECT * FROM h_board WHERE end_time > now() AND start_time < now() ORDER BY no DESC LIMIT ?,?";

			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, beginPerPage);
			pstmt.setInt(2, numPerPage);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDto dto = new BoardDto();
				
				dto.setNo(rs.getInt("no"));
				dto.setMain_img(rs.getString("main_img"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setCategory(rs.getString("category"));
				dto.setMore_category(rs.getString("more_category"));
				dto.setBin_price(rs.getInt("bin_price"));
				dto.setBid_price(rs.getInt("bid_price"));
				dto.setStart_time(rs.getTimestamp("start_time"));
				dto.setEnd_time(rs.getTimestamp("end_time"));
				dto.setArea(rs.getString("area"));
				dto.setTrade(rs.getString("trade"));
				dto.setAddress(rs.getString("address"));
				dto.setAddress2(rs.getString("address2"));
				dto.setCoords(rs.getString("coords"));
				dto.setStatus(rs.getInt("status"));
				dto.setId(rs.getString("id"));
				
				li.add(dto);
			}
		} catch(Exception e) {
			System.out.println("getBoardList()메서드에서 에러 : " + e);
		} finally {
			freeResource();
		}
		
		return li;
	}
	
	//판매글들의 수를 리턴하는 매세드, 검색옵션들을 전달받아 정확한 개수를 리턴
	public int getBoardSize(String searchBox, Hashtable<String, String> options) {
		int size = 0;
		
		try {
			con = getConnection();
			
			//-----------------쿼리문 생성-------------------//
			searchBox = searchBox.equals("null") ? "" : searchBox;
			String sql = "SELECT COUNT(*) FROM h_board WHERE ";
			ArrayList<String> option = new ArrayList<String>();
			Enumeration<String> e = options.keys();
			while(e.hasMoreElements()) {
				String key = e.nextElement();
				
				switch(key) {
					case "area":
					case "category":
					case "more_category":
						sql += key + "=? AND ";
						option.add(key);
						break;
					case "format":
						sql += options.get(key) + "!=0 AND ";
						break;
					case "min_price":
						sql += "(bin_price!=0 AND bin_price >= " + options.get(key) + " OR bid_price!=0 AND bid_price >= " + options.get(key) + ") AND ";
						break;
					case "max_price":
						sql += "(bin_price!=0 AND bin_price <= " + options.get(key) + " OR bid_price!=0 AND bid_price <= " + options.get(key) + ") AND ";
						break;
				}
//				if(key.equals("area") || key.equals("category") || key.equals("more_category")) {
//					sql += key + "=? AND ";
//					option.add(key);
//				} else {
//					sql += options.get(key) + "!=0 AND ";
//				}
			}
			sql += "end_time > now() AND start_time < now() AND title like '%" + searchBox + "%'";
			//-----------------쿼리문 생성-------------------//
			
			pstmt = con.prepareStatement(sql);
			for (int i = 0; i < option.size(); i++) {
				pstmt.setString(i + 1, options.get(option.get(i)));
			}
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				size = rs.getInt(1);
			}
		} catch(Exception e) {
			System.out.println("getBoardSize()메서드에서 에러 : " + e);
		} finally {
			freeResource();
		}
		
		return size;
	}
	
	
	
	//새 판매글 추가 메서드
	public void insertBoard(BoardDto dto) {
		try {
			con = getConnection();
			
			String sql = "INSERT INTO h_board(main_img, title, content, category, more_category, bin_price, bid_price, start_time, end_time, area, trade, address, address2, coords, status, id) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMain_img());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getCategory());
			pstmt.setString(5, dto.getMore_category());
			pstmt.setInt(6, dto.getBin_price());
			pstmt.setInt(7, dto.getBid_price());
			pstmt.setTimestamp(8, dto.getStart_time());
			pstmt.setTimestamp(9, dto.getEnd_time());
			pstmt.setString(10, dto.getArea());
			pstmt.setString(11, dto.getTrade());
			pstmt.setString(12, dto.getAddress());
			pstmt.setString(13, dto.getAddress2());
			pstmt.setString(14, dto.getCoords());
			pstmt.setInt(15, 0); //0-selling, 1-sold
			pstmt.setString(16, dto.getId());
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("insertBoard()메서드에서 에러 : " + e);
		} finally {
			freeResource();
		}
	}
	
	//판매글 판매 종료 메서드, 판매글을  delete하지 않고 end_time을 현재시간으로 수정해 판매가 종료된 상품으로 만듦
	public void endBoard(int no) {
		try {
			con = getConnection();
			
			String sql = "UPDATE h_board SET end_time=? WHERE no=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(2, no);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("endBoard()메서드에서 에러 : " + e);
		} finally {
			freeResource();
		}
	}
	
	//판매글 수정 메서드
	public void updateBoard(BoardDto dto) {
		try {
			con = getConnection();
			
			String sql = "UPDATE h_board "
					+ "SET main_img=?, title=?, content=?, category=?, more_category=?, bin_price=?, "
					+ "end_time=?, area=?, trade=?, address=?, address2=?, coords=?, status=? WHERE no=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMain_img());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getCategory());
			pstmt.setString(5, dto.getMore_category());
			pstmt.setInt(6, dto.getBin_price());
			pstmt.setTimestamp(7, dto.getEnd_time());
			pstmt.setString(8, dto.getArea());
			pstmt.setString(9, dto.getTrade());
			pstmt.setString(10, dto.getAddress());
			pstmt.setString(11, dto.getAddress2());
			pstmt.setString(12, dto.getCoords());
			pstmt.setInt(13, dto.getStatus());
			pstmt.setInt(14, dto.getNo());
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("updateBoard()메서드에서 에러 : " + e);
		} finally {
			freeResource();
		}
	}
	
	public List<BoardDto> getMyList(int beginPerPage, int numPerPage ,String id) {
		List<BoardDto> li = new ArrayList<BoardDto>();
		
		try {
			con = getConnection();
			
			String sql = "SELECT * FROM h_board WHERE id=? ORDER BY no DESC LIMIT ?,?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, beginPerPage);
			pstmt.setInt(3, numPerPage);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDto dto = new BoardDto();
				
				dto.setNo(rs.getInt("no"));
				dto.setMain_img(rs.getString("main_img"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setCategory(rs.getString("category"));
				dto.setMore_category(rs.getString("more_category"));
				dto.setBin_price(rs.getInt("bin_price"));
				dto.setBid_price(rs.getInt("bid_price"));
				dto.setStart_time(rs.getTimestamp("start_time"));
				dto.setEnd_time(rs.getTimestamp("end_time"));
				dto.setArea(rs.getString("area"));
				dto.setTrade(rs.getString("trade"));
				dto.setAddress(rs.getString("address"));
				dto.setAddress2(rs.getString("address2"));
				dto.setCoords(rs.getString("coords"));
				dto.setStatus(rs.getInt("status"));
				dto.setId(rs.getString("id"));
				
				li.add(dto);
			}
		} catch(Exception e) {
			System.out.println("getBoardList()메서드에서 에러 : " + e);
		} finally {
			freeResource();
		}
		
		return li;
	}
	
	public int getMyListSize(String id) {
		int size = 0;
		
		try {
			con = getConnection();
			
			String sql = "SELECT COUNT(*) FROM h_board WHERE id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				size = rs.getInt(1);
			}
		} catch(Exception e) {
			System.out.println("getBoardSize()메서드에서 에러 : " + e);
		} finally {
			freeResource();
		}
		
		return size;
	}
	
	public void insertBuyer(int no, String id) {
		try {
			con = getConnection();
			
			String sql = "INSERT INTO h_buyer VALUES(?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("insertBuyer()메서드에서 에러 : " + e);
		} finally {
			freeResource();
		}
	}
	
	public BuyerDto getBuyer(int no) {
		BuyerDto dto = null;
		
		try {
			con = getConnection();
			
			String sql = "SELECT * FROM h_buyer WHERE no=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new BuyerDto();
				dto.setId(rs.getString("id"));
			}
		} catch(Exception e) {
			System.out.println("getBuyer()메서드에서 에러 : " + e);
		} finally {
			freeResource();
		}
		
		return dto;
	}
	
	public List<BoardDto> getBuyList(int beginPerPage, int numPerPage, String id) {
		List<BoardDto> li = new ArrayList<BoardDto>();
		
		try {
			con = getConnection();
			
			String sql = "SELECT * FROM h_board a JOIN h_buyer b "
					+ "ON a.no = b.no WHERE b.id=? ORDER BY a.no DESC LIMIT ?,?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, beginPerPage);
			pstmt.setInt(3, numPerPage);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDto dto = new BoardDto();
				
				dto.setNo(rs.getInt("a.no"));
				dto.setMain_img(rs.getString("main_img"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setCategory(rs.getString("category"));
				dto.setMore_category(rs.getString("more_category"));
				dto.setBin_price(rs.getInt("bin_price"));
				dto.setBid_price(rs.getInt("bid_price"));
				dto.setStart_time(rs.getTimestamp("start_time"));
				dto.setEnd_time(rs.getTimestamp("end_time"));
				dto.setArea(rs.getString("area"));
				dto.setTrade(rs.getString("trade"));
				dto.setAddress(rs.getString("address"));
				dto.setAddress2(rs.getString("address2"));
				dto.setCoords(rs.getString("coords"));
				dto.setStatus(rs.getInt("status"));
				dto.setId(rs.getString("a.id"));
				
				li.add(dto);
			}
		} catch(Exception e) {
			System.out.println("getBuyList()메서드에서 에러 : " + e);
		} finally {
			freeResource();
		}
		
		return li;
	}
	
	public int getBuyListSize(String id) {
		int size = 0;
		
		try {
			con = getConnection();
			
			String sql = "SELECT COUNT(*) FROM h_board a JOIN h_buyer b "
					+ "ON a.no = b.no WHERE b.id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				size = rs.getInt(1);
			}
		} catch(Exception e) {
			System.out.println("getBuyListSize()메서드에서 에러 : " + e);
		} finally {
			freeResource();
		}
		
		return size;
	}
}
