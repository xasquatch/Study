package mymember;

import java.sql.*;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DataSource ds = null;
	
	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		ds = (DataSource)ctx.lookup("java:comp/env/jdbc/jspbeginner");
		return ds.getConnection();
	}
	
	private void freeResource() {
		try {
			if(con != null) con.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		} catch(Exception e) {
			System.out.println("freeResource()메서드에서 에러 : " + e);
		}
	}
	
	public boolean checkUser(String id) {
		boolean check = false;
		
		try {
			con = getConnection();
			
			String sql = "SELECT id, pass FROM h_member WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) check = true;
			else check = false;
		} catch(Exception e) {
			System.out.println("checkUser()메서드에서 에러 : " + e);
		} finally {
			freeResource();
		}
		
		return check;
	}
	
	public boolean checkUser(String id, String pass) {
		boolean check = false;
		
		try {
			con = getConnection();
			
			String sql = "SELECT id, pass FROM h_member WHERE id=? AND pass=? AND active=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			pstmt.setInt(3, 1);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) check = true;
			else check = false;
		} catch(Exception e) {
			System.out.println("checkUser()메서드에서 에러 : " + e);
		} finally {
			freeResource();
		}
		
		return check;
	}
	
	//이메일 인증 메서드
	public int sendEmail(String to, String authNum) {
		String from = "hbaymail@naver.com";
		String subject = "Hbay 이메일 인증";
		String content = "[" + authNum + "]";
		
		Properties p = new Properties(); // 정보를 담을 객체

		p.put("mail.smtp.host", "smtp.naver.com"); // 네이버 SMTP

		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		// SMTP 서버에 접속하기 위한 정보들

		try {
			Authenticator auth = new SMTPAuthenticator();
			Session ses = Session.getInstance(p, auth);

			ses.setDebug(true);

			MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
			msg.setSubject(subject); // 제목

			Address fromAddr = new InternetAddress(from);
			msg.setFrom(fromAddr); // 보내는 사람

			Address toAddr = new InternetAddress(to);
			msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람

			msg.setContent(content, "text/html;charset=UTF-8"); // 내용과 인코딩

			Transport.send(msg); // 전송
			
			return 1;
		} catch (Exception e) {
			System.out.println("sendEmail()메서드에서 에러 : " + e);
			return 0;
		}
	}
	
	public String randomNum() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 6; i++) {
			int n = (int)(Math.random() * 10);
			sb.append(n);
		}
		return sb.toString();
	}
	
	//회원가입폼 DB저장 메서드
	public void insertMember(MemberDto dto) {
		try {
			con = getConnection();
			
			String sql = "INSERT INTO h_member "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPass());
			pstmt.setString(3, dto.getMem_name());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getBirth());
			pstmt.setInt(6, dto.getPostcode());
			pstmt.setString(7, dto.getAddress());
			pstmt.setString(8, dto.getAddress2());
			pstmt.setString(9, dto.getEmail());
			pstmt.setInt(10, 1);
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("insertMember()메서드에서 에러 : " + e);
		} finally {
			freeResource();
		}
	}
	
	//비밀번호 변경 메서드
	public void updatePass(String id, String pass) {
		try {
			con = getConnection();
			
			String sql = "UPDATE h_member SET pass = ? WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, id);
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("updatePass()메서드에서 에러 : " + e);
		} finally {
			freeResource();
		}
	}
	
	//회원정보 수정/탈퇴 메서드
	public void closeAccount(String id, MemberDto dto) {
		try {
			con = getConnection();
			
			String sql = "UPDATE h_member SET postcode=?, address=?, address2=?, email=?, active=? WHERE id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getPostcode());
			pstmt.setString(2, dto.getAddress());
			pstmt.setString(3, dto.getAddress2());
			pstmt.setString(4, dto.getEmail());
			pstmt.setInt(5, 0);
			pstmt.setString(6, id);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("closeAccount()메서드에서 에러 : " + e);
		} finally {
			freeResource();
		}
	}
	
	public MemberDto getMember(String id) {
		MemberDto dto = new MemberDto();
		
		try {
			con = getConnection();
			
			String sql = "SELECT * FROM h_member WHERE id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setId(id);
				dto.setPass(rs.getString("pass"));
				dto.setMem_name(rs.getString("mem_name"));
				dto.setGender(rs.getString("gender"));
				dto.setBirth(rs.getString("birth"));
				dto.setPostcode(rs.getInt("postcode"));
				dto.setAddress(rs.getString("address"));
				dto.setAddress2(rs.getString("address2"));
				dto.setEmail(rs.getString("email"));
			}
		} catch(Exception e) {
			System.out.println("getMember()메서드에서 에러 : " + e);
		} finally {
			freeResource();
		}
		
		return dto;
	}
	
	public void updateMember(MemberDto dto) {
		try {
			con = getConnection();
			
			String sql = "UPDATE h_member"
					+ " SET mem_name=?, gender=?, birth=?, postcode=?, address=?, address2=?, email=? WHERE id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMem_name());
			pstmt.setString(2, dto.getGender());
			pstmt.setString(3, dto.getBirth());
			pstmt.setInt(4, dto.getPostcode());
			pstmt.setString(5, dto.getAddress());
			pstmt.setString(6, dto.getAddress2());
			pstmt.setString(7, dto.getEmail());
			pstmt.setString(8, dto.getId());
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("updateMember()메서드에서 에러 : " + e);
		} finally {
			freeResource();
		}
	}
}
