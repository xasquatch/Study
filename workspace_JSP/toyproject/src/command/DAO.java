package command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class DAO {

	    private PreparedStatement pstmt = null;
	    private ResultSet rs = null;
	    private Connection con = null;
	    private DataSource ds = null; 
	//1. 싱글톤 패턴
	    private static DAO dao = null;
	    public static DAO getInstanceDAO() {
			if (dao == null) {
				dao = new DAO();
			}
	    	return dao;
		}
	    private DAO(){
			try {
				Context init = new InitialContext();
				ds = (DataSource)init.lookup("java:comp/env/jdbc/toyproject");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	    
	    public int checkID(String id) {
	    	
	        String SQL = "SELECT * FROM toyproject.user where id = ?";
	        try {
	        	con = ds.getConnection();
	            pstmt = con.prepareStatement(SQL);
	            pstmt.setString(1, id);
	            rs = pstmt.executeQuery();
	             
	            if (rs.next())
	                return 0;
	            else
	                return 1;
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	        	try {
		        	if (rs!=null) rs.close();
		        	if (pstmt!=null) pstmt.close();
		        	if (con!=null) con.close();
	        	}catch (Exception e2) {
	        		e2.printStackTrace();
				}
	        }
	        return -1;
	    }//signUpCheck
	    
	//5. 회원가입 등록
	
	 public int signUp(String id, String pwd, String name, String email, String callnum,
			 String addr1, String addr2, String addr3, String addr4){
	 
		 String sql = "INSERT INTO user(id,pwd,name,email,callnum,addr1,addr2,addr3,addr4 "
		 		+ "VALUES(?,?,?,?,?,?,?,?,?)";
		 try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.setString(5, callnum);
			pstmt.setString(6, addr1);
			pstmt.setString(7, addr2);
			pstmt.setString(8, addr3);
			pstmt.setString(9, addr4);
			pstmt.setTimestamp(10, new Timestamp(System.currentTimeMillis()));
			
			pstmt.executeUpdate();
			
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
				if (pstmt!=null) pstmt.close();
				if (con!=null) con.close();
				}catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		 return -1;
	 }
	 

	//6.고객 로그인 구현
	/*
	 * public UserDTO login(String id, String pwd) {
	 * 
	 * UserDTO dto = null; try{ String sql =
	 * "SELECT * FROM toyproject.user WHERE id = ? AND pwd = ?"; con =
	 * ds.getConnection(); pstmt = con.prepareStatement(sql); pstmt.setString(1,
	 * id); pstmt.setString(2, pwd); rs = pstmt.executeQuery(); if (rs.next()) { dto
	 * = new UserDTO(); dto.setnum(rs.getInt("num")); dto.setid(rs.getString("id"));
	 * dto.setpwd(rs.getString("pwd"));
	 * dto.setfirst_name(rs.getString("first_name"));
	 * dto.setlast_name(rs.getString("last_name"));
	 * dto.setcountry(rs.getString("country"));
	 * dto.setaddress(rs.getString("address"));
	 * dto.setcontact_num(rs.getString("contact_num"));
	 * dto.setbirth(rs.getDate("birth")); dto.setgender(rs.getInt("gender"));
	 * dto.setage(rs.getInt("age")); dto.setemail(rs.getString("email"));
	 * dto.setmileage(rs.getInt("mileage"));
	 * dto.setcredit_num(rs.getString("credit_num"));
	 * dto.setcredit_cvc(rs.getString("credit_cvc"));
	 * dto.setRating_r_num(rs.getInt("rating_r_num"));
	 * dto.setjoindate(rs.getTimestamp("joindate")); }else { return null; } }catch
	 * (Exception e){ e.printStackTrace(); }finally { try { if (rs!=null)
	 * rs.close(); if (pstmt!=null) pstmt.close(); if (con!=null) con.close();
	 * }catch (Exception e2) { e2.printStackTrace(); } } return dto; }
	 */
		
		
		public int modifyInfomation(String id, String pwd1, String first_name, String last_name, String country,
				String address, String contact_num, String email) {
			
			String SQL= "UPDATE toyproject.user"
					+ " SET pwd = ?, first_name = ?, last_name = ?, country = ?, address = ?, contact_num = ?, email = ?" 
					+ " WHERE id = ?";
			int result = 0;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(SQL);
				pstmt.setString(1, pwd1);
				pstmt.setString(2, first_name);
				pstmt.setString(3, last_name);
				pstmt.setString(4, country);
				pstmt.setString(5, address);
				pstmt.setString(6, contact_num);
				pstmt.setString(7, email);
				pstmt.setString(8, id);
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
		        	if (pstmt!=null) pstmt.close();
		        	if (con!=null) con.close();
	        	}catch (Exception e2) {
	        		e2.printStackTrace();
				}
			}
			
			
			return result;
		}
	    
	    
}
