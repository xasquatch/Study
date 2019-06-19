package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import oracle.net.aso.b;
import oracle.net.aso.p;

public class CarDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//而ㅻ�μ������ �산� 而ㅻ�μ����濡�遺��� Connection媛�泥대�� �삳�� 硫�����
	public void getCon(){
		try {
			//1.WAS��踰��� �곌껐�� �뱁��濡����몄�� 而⑦���ㅽ�� ��蹂대�� 媛�吏�怨� ���� 而⑦���ㅽ�� 媛�泥� ����
			Context init = new InitialContext();
			//2.�곌껐�� WAS��踰����� DataSource(而ㅻ�μ����) 寃����댁�� �산린
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/jspbeginner");
			//3.DataSource(而ㅻ�μ����)���� DB�곕��媛�泥�(而ㅻ�μ��) �산린
			con = ds.getConnection();
		} catch (Exception e) {
			System.out.println("而ㅻ�μ�� �산린 �ㅽ��");
			e.printStackTrace();
		}
	}//getCon()硫����� ��
	
	
	/*DB濡� 遺��� ��泥� 李⑤���� 寃��� ���� 硫�����*/
	public Vector<CarListBean> getAllCarList() {		
		//DB濡�遺��� 寃����� ������ 李⑤����蹂대�� -> CarListBean媛�泥댁�� ������ ���� ����
		//�щ�� CarListBean媛�泥대�ㅼ�� Vector�� 異�媛����� 理�醫����쇰� Vector�� ���λ��寃� ����
		//Vector媛�泥대�� ���� ����
		Vector<CarListBean> v = new Vector<CarListBean>();		
		//DB濡�遺��� 寃����� ������ 李⑤����蹂대�� -> CarListBean媛�泥댁�� ���λ��湲� ��臾몄��..
		//CarListBean媛�泥대�� ���ν�� 蹂��� ����
		CarListBean bean = null;	
		try {
			//而ㅻ�μ����濡�遺��� Connection�산린
			getCon();
			
			//荑쇰━以�鍮� : ��泥댁감�� 寃���
			String sql = "select * from carlist";
			
			//荑쇰━ �ㅽ�� 媛�泥� 以�鍮�
			pstmt = con.prepareStatement(sql);
			
			//select�ㅽ���� 寃곌낵瑜� 由ы��
			rs = pstmt.executeQuery();
			
			//諛�蹂듬Ц�� ��硫댁�� Resultset媛�泥댁�� ���λ���� ���� 寃����� ��肄���瑜� ��以��⑥��濡� CarListBean媛�泥댁������
			while (rs.next()) {
				bean = new CarListBean();
				bean.setCarno(rs.getInt(1)); //李⑤��� �닿린
				bean.setCarname(rs.getString(2));//李⑥�대� �닿린
				bean.setCarcompany(rs.getString(3));//李⑥��議곗�� �닿린
				bean.setCarprice(rs.getInt(4));//李� 媛�寃� �닿린
				bean.setCarusepeople(rs.getInt(5));//李⑥�몄�� ��蹂� �닿린
				bean.setCarinfo(rs.getString(6));//李⑥��蹂� �닿린
				bean.setCarimg(rs.getString(7));//李⑥�대�몄�紐� �닿린
				bean.setCarcategory(rs.getString(8));//李⑥�瑜�(����,以���,����)以� ���� �닿린 
				//諛깊�곗�� 異�媛�
				v.add(bean);
			}//while
			//����諛���
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("getAllCarList() 硫����� �대����� �ㅻ� :" + e.getMessage());
		}
		return v; //諛깊�� 諛���
	}//getAllCarList()	

	/*移댄��怨�由щ�(����,以���,����) ����李� ��蹂대�� DB濡� 遺��� 寃��� ���� 硫����� */
	public Vector<CarListBean> getCategoryCarList(String carcategory) {
		//DB濡�遺��� 寃����� ������ 李⑤����蹂대�� -> CarListBean媛�泥댁�� ������ ���� ����
		//�щ�� CarListBean媛�泥대�ㅼ�� Vector�� 異�媛����� 理�醫����쇰� Vector�� ���λ��寃� ����
		//Vector媛�泥대�� ���� ����
		Vector<CarListBean> v = new Vector<CarListBean>();		
		//DB濡�遺��� 寃����� ������ 李⑤����蹂대�� -> CarListBean媛�泥댁�� ���λ��湲� ��臾몄��..
		//CarListBean媛�泥대�� ���ν�� 蹂��� ����
		CarListBean bean = null;	
		try {
			//而ㅻ�μ����濡�遺��� Connection�산린
			getCon();
			
			//荑쇰━以�鍮� : ��泥댁감�� 寃���
			String sql = "select * from carlist where carcategory=?";
			
			//荑쇰━ �ㅽ�� 媛�泥� 以�鍮�
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, carcategory);
			
			//select�ㅽ���� 寃곌낵瑜� 由ы��
			rs = pstmt.executeQuery();
			
			//諛�蹂듬Ц�� ��硫댁�� Resultset媛�泥댁�� ���λ���� ���� 寃����� ��肄���瑜� ��以��⑥��濡� CarListBean媛�泥댁������
			while (rs.next()) {
				bean = new CarListBean();
				bean.setCarno(rs.getInt(1)); //李⑤��� �닿린
				bean.setCarname(rs.getString(2));//李⑥�대� �닿린
				bean.setCarcompany(rs.getString(3));//李⑥��議곗�� �닿린
				bean.setCarprice(rs.getInt(4));//李� 媛�寃� �닿린
				bean.setCarusepeople(rs.getInt(5));//李⑥�몄�� ��蹂� �닿린
				bean.setCarinfo(rs.getString(6));//李⑥��蹂� �닿린
				bean.setCarimg(rs.getString(7));//李⑥�대�몄�紐� �닿린
				bean.setCarcategory(rs.getString(8));//李⑥�瑜�(����,以���,����)以� ���� �닿린 
				//諛깊�곗�� 異�媛�
				v.add(bean);
			}//while
			//����諛���
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("getCategoryCarList() 硫����� �대����� �ㅻ� :" + e.getMessage());
		}
		return v; //諛깊�� 諛���
	}//getCategoryCarList硫����� ��
	
	//CarInfoController.java濡�遺��� carno瑜� ���� 諛���
	//carno�� �대�뱁���� ����李� ������ ��蹂대�� 寃��� �댁�� 諛��� ���� 硫����� 
	public CarListBean getOneCar(int carno) {
	
		//DB濡�遺��� 寃����� ������ 李⑤����蹂대�� -> CarListBean媛�泥댁�� ���λ��湲� ��臾몄��..
		//CarListBean媛�泥대�� ���ν�� 蹂��� ����
		CarListBean bean = null;	
		try {
			//而ㅻ�μ����濡�遺��� Connection�산린
			getCon();
			
			//荑쇰━以�鍮� : ��泥댁감�� 寃���
			String sql = "select * from carlist where carno=?";
			
			//荑쇰━ �ㅽ�� 媛�泥� 以�鍮�
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, carno);
			
			//select�ㅽ���� 寃곌낵瑜� 由ы��
			rs = pstmt.executeQuery();
			
			//Resultset媛�泥댁�� ���λ���� ���� 寃����� ��肄���瑜� ��以��⑥��濡� CarListBean媛�泥댁������
			if (rs.next()) {
				bean = new CarListBean();
				bean.setCarno(rs.getInt(1)); //李⑤��� �닿린
				bean.setCarname(rs.getString(2));//李⑥�대� �닿린
				bean.setCarcompany(rs.getString(3));//李⑥��議곗�� �닿린
				bean.setCarprice(rs.getInt(4));//李� 媛�寃� �닿린
				bean.setCarusepeople(rs.getInt(5));//李⑥�몄�� ��蹂� �닿린
				bean.setCarinfo(rs.getString(6));//李⑥��蹂� �닿린
				bean.setCarimg(rs.getString(7));//李⑥�대�몄�紐� �닿린
				bean.setCarcategory(rs.getString(8));//李⑥�瑜�(����,以���,����)以� ���� �닿린 
			}//if
			//����諛���
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("getOneCar() 硫����� �대����� �ㅻ� :" + e.getMessage());
		}
		return bean; //CarListBean媛�泥� 諛���
	}//getOneCar硫����� ��
	
	//예약정보를 DB에 추가하는 메소드 
	public void insertCarOrder(CarOrderBean bean){
		try {
			//DB연결
			getCon();		
			//insert문 준비
			String sql = "insert into carorder(carno,carqty,carreserveday,"
					+ "carbegindate,carins,carwifi,carnave,carbabyseat,memberphone,"
					+ "memberpass) values(?,?,?,?,?,?,?,?,?,?)";			
			//insert문을 실행할 PreparedStatment객체 얻기
			pstmt = con.prepareStatement(sql);
			//?자리에 값을 대입
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
			//insert 실행
			pstmt.executeUpdate();
			//자원해제
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//예약한 주문 정보를 DB로 부터 검색하는 메소드 
	public Vector<CarConfirmBean> getAllCarOrder(String memberphone, 
												 String memberpass) {		
		Vector<CarConfirmBean> v = new Vector<CarConfirmBean>();
		
		//DB에서 검색한 예약 정보를 저장할  CarConfirmBean객체를 담을 변수 선언
		CarConfirmBean bean = null;		
		try {
			//DB연결
			getCon();
			//SELECT 문장 만들기
			//-> 렌트 예약 날짜가 현재 날짜보다 크고,
			//   렌트 예약시 작성한 비회원 전화번호와 비밀번호에 해당하는 렌트 예약정보를 검색하는데..
			//   carorder테이블과 carlist테이블을 natural 조인 하여 검색.
			
			//참고! String 타입을 Date타입으로 변경
			String sql = "select * from carorder natural join carlist where "
					   + "now() < str_to_date(carbegindate, '%Y-%m-%d') and "
					   + "memberphone=? and memberpass=?";
			
			//참고!
			//SELECT 문에 *와 같이 별도의 컬럼 순서를 지정하지 않으면..
			//natural join의 기준이 되는 테이블의 컬럼들이 다른 컬럼보다 먼저 출력된다.
			//이때 natural join은 JOIN에 사용된 같은 이름의 컬럼을 중복출력하지않고  하나로 처리 한다.
			
			//?에 해당하는 값을 제외한 SELECT문장을 저장한 PreparedStatement객체 얻기
			pstmt = con.prepareStatement(sql);
			//?에 해당하는 값 을 매개변수로 전달받는 우리가 입력한 전화번호 와 비밀번호 값으로 셋팅
			pstmt.setString(1, memberphone);
			pstmt.setString(2, memberpass);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				bean = new CarConfirmBean(); //DTO객체 생성
				bean.setOrderid(rs.getInt(2));//예약한정보중.. 예약 id
				bean.setCarqty(rs.getInt(3)); //예약한 정보중.. 대여수량
				bean.setCarreserveday(rs.getInt(4));//예약한 정보중.. 대여기간
				bean.setCarbegindate(rs.getString(5));//예약한 정보중..예약 날짜
				bean.setCarins(rs.getInt(6));//예약한 정보중.. 보험적용 여부 저장
				bean.setCarwifi(rs.getInt(7));
				bean.setCarnave(rs.getInt(8));
				bean.setCarbabyseat(rs.getInt(9));
				bean.setCarname(rs.getString(12));//자동차명 
				bean.setCarprice(rs.getInt(14));
				bean.setCarimg(rs.getString(17));//자동차 이미지명
				
				v.add(bean);//백터에 추가 
			}
			//자원해제
			pstmt.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			System.out.println("getAllCarOrder메소드 내부 오류:" + e);
		}		
		return v; //백터 반환
		
	}//getAllCarOrder 메소드 끝

	//하나의 주문아이디를 전달받아.. 하나의 주문정보를 검색하여 반환하는 메소드
	public CarConfirmBean getOneOrder(int orderid) {
	
		CarConfirmBean cbean = null;
		
		try {
			//DB접속객체 얻기
			getCon();
			String sql = "select * from carorder where orderid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, orderid);
			//검색후 검색한 결과를 ResultSet에 담아 리턴
			rs = pstmt.executeQuery();
			rs.next();
			cbean = new CarConfirmBean();
			cbean.setOrderid(orderid); //예약 id
			cbean.setCarbegindate(rs.getString(5));//대여예약날짜
			cbean.setCarreserveday(rs.getInt(4));//대여기간
			cbean.setCarins(rs.getInt(6));//보험적용여부값
			cbean.setCarwifi(rs.getInt(7));//WIFI적용여부값
			cbean.setCarnave(rs.getInt(8));//네비게이션 적용 여부값
			cbean.setCarbabyseat(rs.getInt(9));//베이비시트 적용 여부값	
			//자원해제
			pstmt.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cbean;
	}//getOneOrder메소드 끝

	//예약 정보를 DB에 수정 하는 메소드 
	public void carOrderUpdate(CarOrderBean bean) {
		try {
		getCon();//DB연결
		
		//매개변수로 전달받은  예약아이디와,입력한 비밀번호에 해당하는 예약정보레코드 수정!
		String sql = "update carorder set carbegindate=?, carreserveday=?, carqty=?,"
				   + " carins=?, carwifi=?, carbabyseat=? "
				   + " where orderid=? and memberpass=?";
		//?에 해당하는 설정값을 제외한 나머지 UPDATE문장을 담은  PreparedStatement실행객체 얻기
		pstmt = con.prepareStatement(sql);
		//?에 해당하는 값을 매개변수로 전달받은 CarOrderBean객체의 변수값들로 셋팅
		pstmt.setString(1, bean.getCarbegindate());
		pstmt.setInt(2, bean.getCarreserveday());
		pstmt.setInt(3, bean.getCarqty());
		pstmt.setInt(4, bean.getCarins());
		pstmt.setInt(5, bean.getCarwifi());
		pstmt.setInt(6, bean.getCarbabyseat());
		pstmt.setInt(7, bean.getOrderid());
		pstmt.setString(8, bean.getMemberpass());
		//UPDATE실행
		pstmt.executeUpdate();		
		//자원해제
		pstmt.close();
		con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//매개변수로 전달 받는 예약 아이디와, 삭제시 입력했던 비밀번호에 해당하는 예약정보를 삭제하는 메소드 
	//DB에 저장된 예약정보 삭제에 성공하면 1을 리턴, 실패하면 0을 리턴
	public int carOrderDelete(int orderid, String memberpass) {
		int result = 0;
		try {
			//Connection얻기(DB접속)
			getCon();
			//매개변수로 전달받는 예약 아이디와 비밀번호에 해당하는 예약정보 삭제 DELETE구문
			String sql = "delete from carorder where orderid=? and memberpass=?";
			pstmt = con.prepareStatement(sql);
			//?자리에 대응되는 값을 PreparedStatement객체에 셋팅
			pstmt.setInt(1, orderid);
			pstmt.setString(2, memberpass);
			//DELETE실행후 그결과를 리턴 받아오기
			result = pstmt.executeUpdate();
			//자원해제
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}//CarDAO클래스 끝






