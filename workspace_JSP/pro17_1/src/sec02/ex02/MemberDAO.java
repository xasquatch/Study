package sec02.ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import oracle.net.aso.p;

public class MemberDAO {//MVC -> M의역할

	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;
	
	public MemberDAO() {//커넥션풀 (DataSource) 얻기
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			//커넥션풀을 <Resource>태그의 JNDI 이름으로 찾아 받아오기 
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
			
		} catch (Exception e) {
			System.out.println("커넥션풀 받기 실패 : " + e.getMessage());
			e.printStackTrace();
		}
	}

	public List listMembers() {//SQL문을 이용해 회원정보를 조회한 후 결과를 
							  //ArrayList로 반환하는 메소드
		
		List memberList = new ArrayList();
		
		try {
			//커넥션풀로부터 DB접속을 나타내는 객체 얻기
			conn = dataFactory.getConnection();
			//SQL구문 작성
			String query = "select * from t_member order by joinDate desc";
			//select문장을 실행할 PreparedStatement얻기
			pstmt = conn.prepareStatement(query);
			//select 실행후 그결과를 ResultSet임시저장공간에 저장하여 얻기
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				//ResultSet에서 검색한 정보를 레코드 단위로 얻기
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				//조회한 회원정보를 레코드별로 MemberVO객체의 변수에 각각 저장함.
				MemberVO memberVO = new MemberVO(id,pwd,name,email,joinDate);
				
				//memberList(ArrayList)에  MemberVO객체를 차례대로 반복문을 돌면서 저장
				memberList.add(memberVO);
			}
			//자원해제
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("listMembers()메소드에서 오류 :" + e.getMessage());
			e.printStackTrace();
		}	
		return memberList;//ArrayList리턴
	}

	//입력받은 회원정보를 DB에 추가 
	public void addMember(MemberVO memberVO) {
		
		try {
			//커넥션풀로부터 DB접속을 나타내는 객체 얻기
			conn = dataFactory.getConnection();
			//insert구문 만들기 위해 입력한 회원정보를 MemberVO객체로부터 얻기
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			//insert구문 만들기
			String query = "INSERT INTO t_member(id,pwd,name,email)"
						 + "VALUES(?,?,?,?)";
			//INSERT를 실행할 PreparedStatement객체 얻기
			pstmt = conn.prepareStatement(query);
			//?값 셋팅
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			//INSERT 실행
			pstmt.executeUpdate();
			//자원 해제
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	//회원 id를 이용해 회원정보 조회
	public MemberVO findMember(String _id) {

		MemberVO memInfo = null;
		
		try {
			//커넥션풀로부터 DB접속을 나타내는 객체 얻기
			conn = dataFactory.getConnection();
			//매개변수로 전달된 ID로 회원정보 조회 SQL구문 만들기
			String query = "select * from t_member where id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			String id = rs.getString("id");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			String email = rs.getString("email");
			Date joinDate = rs.getDate("joinDate");
			//검색한 수정할 회원 한명의 정보를 MembeVO객체에 생성자를 통해서 저장
			memInfo = new MemberVO(id, pwd, name, email, joinDate);
			//자원해제
			pstmt.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memInfo; //매개변수로 전달받은 ID로 조회한 회원정보 반환
	}//findMember 끝

	//매개변수로 전달된 MemberVO객체를 이용하여 DB의 회원정보 수정
	public void modMember(MemberVO memberVO) {
		
		//수정할 회원정보를  MemberVO객체의 getter메소드를 통해 얻기 
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		String name = memberVO.getName();
		String email = memberVO.getEmail();
		try {
			//커넥션풀로부터 DB접속을 나타내는 객체 얻기
			conn = dataFactory.getConnection();
			//매개변수로 전달된 MemberVO객체로 회원정보 수정 SQL구문 만들기
			String query = "update t_member set pwd=?, name=?, email=? where id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pwd);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			pstmt.executeUpdate(); //UPDATE전달 및 실행
			//자원해제
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//modMember메소드 끝

	public void delMember(String id) {
		try {
			//커넥션풀로부터 DB접속을 나타내는 객체 얻기
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement("delete from t_member where id=?");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}//DAO클래스 끝






