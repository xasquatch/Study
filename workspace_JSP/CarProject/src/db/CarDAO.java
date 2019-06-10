package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import oracle.net.aso.b;

public class CarDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//커넥션풀을 얻고 커넥션풀로부터 Connection객체를 얻는 메소드
	public void getCon(){
		try {
			//1.WAS서버와 연결된 웹프로젝트의 컨텍스트 정보를 가지고 있는 컨텍스트 객체 생성
			Context init = new InitialContext();
			//2.연결된 WAS서버에서 DataSource(커넥션풀) 검색해서 얻기
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/jspbeginner");
			//3.DataSource(커넥션풀)에서 DB연동객체(커넥션) 얻기
			con = ds.getConnection();
		} catch (Exception e) {
			System.out.println("커넥션 얻기 실패");
			e.printStackTrace();
		}
	}//getCon()메소드 끝
	
	
	/*DB로 부터 전체 차량을 검색 하는 메소드*/
	public Vector<CarListBean> getAllCarList() {		
		//DB로부터 검색한 하나의 차량정보는 -> CarListBean객체에 하나씪 저장 된다
		//여러 CarListBean객체들은 Vector에 추가되어 최종적으로 Vector에 저장되게 된다
		//Vector객체를 생성 하자
		Vector<CarListBean> v = new Vector<CarListBean>();		
		//DB로부터 검색한 하나의 차량정보는 -> CarListBean객체에 저장되기 떄문에..
		//CarListBean객체를 저장할 변수 선언
		CarListBean bean = null;	
		try {
			//커넥션풀로부터 Connection얻기
			getCon();
			
			//쿼리준비 : 전체차량 검색
			String sql = "select * from carlist";
			
			//쿼리 실행 객체 준비
			pstmt = con.prepareStatement(sql);
			
			//select실행후 결과를 리턴
			rs = pstmt.executeQuery();
			
			//반복문을 돌면서 Resultset객체에 저장되어 있는 검색된 레코드를 한줄단위로 CarListBean객체에저장
			while (rs.next()) {
				bean = new CarListBean();
				bean.setCarno(rs.getInt(1)); //차번호 담기
				bean.setCarname(rs.getString(2));//차이름 담기
				bean.setCarcompany(rs.getString(3));//차제조사 담기
				bean.setCarprice(rs.getInt(4));//차 가격 담기
				bean.setCarusepeople(rs.getInt(5));//차인승 정보 담기
				bean.setCarinfo(rs.getString(6));//차정보 담기
				bean.setCarimg(rs.getString(7));//차이미지명 담기
				bean.setCarcategory(rs.getString(8));//차종류(소형,중형,대형)중 하나 담기 
				//백터에 추가
				v.add(bean);
			}//while
			//자원반납
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("getAllCarList() 메소드 내부에서 오류 :" + e.getMessage());
		}
		return v; //백터 반환
	}//getAllCarList()	

	/*카테고리별(소형,중형,대형) 자동차 정보를 DB로 부터 검색 하는 메소드 */
	public Vector<CarListBean> getCategoryCarList(String carcategory) {
		//DB로부터 검색한 하나의 차량정보는 -> CarListBean객체에 하나씪 저장 된다
		//여러 CarListBean객체들은 Vector에 추가되어 최종적으로 Vector에 저장되게 된다
		//Vector객체를 생성 하자
		Vector<CarListBean> v = new Vector<CarListBean>();		
		//DB로부터 검색한 하나의 차량정보는 -> CarListBean객체에 저장되기 떄문에..
		//CarListBean객체를 저장할 변수 선언
		CarListBean bean = null;	
		try {
			//커넥션풀로부터 Connection얻기
			getCon();
			
			//쿼리준비 : 전체차량 검색
			String sql = "select * from carlist where carcategory=?";
			
			//쿼리 실행 객체 준비
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, carcategory);
			
			//select실행후 결과를 리턴
			rs = pstmt.executeQuery();
			
			//반복문을 돌면서 Resultset객체에 저장되어 있는 검색된 레코드를 한줄단위로 CarListBean객체에저장
			while (rs.next()) {
				bean = new CarListBean();
				bean.setCarno(rs.getInt(1)); //차번호 담기
				bean.setCarname(rs.getString(2));//차이름 담기
				bean.setCarcompany(rs.getString(3));//차제조사 담기
				bean.setCarprice(rs.getInt(4));//차 가격 담기
				bean.setCarusepeople(rs.getInt(5));//차인승 정보 담기
				bean.setCarinfo(rs.getString(6));//차정보 담기
				bean.setCarimg(rs.getString(7));//차이미지명 담기
				bean.setCarcategory(rs.getString(8));//차종류(소형,중형,대형)중 하나 담기 
				//백터에 추가
				v.add(bean);
			}//while
			//자원반납
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("getCategoryCarList() 메소드 내부에서 오류 :" + e.getMessage());
		}
		return v; //백터 반환
	}//getCategoryCarList메소드 끝
	
	//CarInfoController.java로부터 carno를 전달 받아
	//carno에 해당하는 자동차 하나의 정보를 검색 해서 반환 하는 메소드 
	public CarListBean getOneCar(int carno) {
	
		//DB로부터 검색한 하나의 차량정보는 -> CarListBean객체에 저장되기 떄문에..
		//CarListBean객체를 저장할 변수 선언
		CarListBean bean = null;	
		try {
			//커넥션풀로부터 Connection얻기
			getCon();
			
			//쿼리준비 : 전체차량 검색
			String sql = "select * from carlist where carno=?";
			
			//쿼리 실행 객체 준비
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, carno);
			
			//select실행후 결과를 리턴
			rs = pstmt.executeQuery();
			
			//Resultset객체에 저장되어 있는 검색된 레코드를 한줄단위로 CarListBean객체에저장
			if (rs.next()) {
				bean = new CarListBean();
				bean.setCarno(rs.getInt(1)); //차번호 담기
				bean.setCarname(rs.getString(2));//차이름 담기
				bean.setCarcompany(rs.getString(3));//차제조사 담기
				bean.setCarprice(rs.getInt(4));//차 가격 담기
				bean.setCarusepeople(rs.getInt(5));//차인승 정보 담기
				bean.setCarinfo(rs.getString(6));//차정보 담기
				bean.setCarimg(rs.getString(7));//차이미지명 담기
				bean.setCarcategory(rs.getString(8));//차종류(소형,중형,대형)중 하나 담기 
			}//if
			//자원반납
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("getOneCar() 메소드 내부에서 오류 :" + e.getMessage());
		}
		return bean; //CarListBean객체 반환
	}//getOneCar메소드 끝


	public void insertCarOrder(CarOrderBean bean) {
		getCon();
		try {
			String sql = "INSERT INTO carorder(carno, carqty, carreserveday, carbegindate, carins, carwifi, carnave, carbabyseat, memberphone, memberpass)"
					+ " VALUES(?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bean.getCarno());
			pstmt.setInt(2, bean.getCarqty());
			pstmt.setInt(3, bean.getCarreserveday());
			pstmt.setString(4, bean.getCarbegindate());
			pstmt.setInt(5, bean.getCarins());
			pstmt.setInt(6, bean.getCarwifi());
			pstmt.setInt(7, bean.getCarnave());
			pstmt.setInt(8, bean.getCarbabyseat());
			pstmt.setString(9, bean.getMemberphone());
			pstmt.setString(10, bean.getMemberpass());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			allClose();
		}
	}

	public void allClose(){
		try {
			con.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}//CarDAO클래스 끝






