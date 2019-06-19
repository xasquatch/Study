package db;

//예약(렌트)정보에 대한 데이터들을 담아 두는 DTO클래스 
public class CarOrderBean {

	private int orderid;//자동차 렌트 주문 id 저장
	//렌트할 차량 차번호 저장 : 차번호를 이용하여 두개의 테이블을 조인하여 검색 하기 위함.
	private int carno;//렌트할 차량 차번호 저장
	private int carreserveday;//렌트할 차량 대여 기간 저장
	private int carqty;//렌트할 차량 대여 수량 저장
	private String carbegindate;//대여날짜 
	private int carins;//렌트시 보험적용 여부 저장
	private int carwifi;//렌트시 WIFI적용 여부 저장
	private int carnave;//렌트시 네비게이션 적용 여부 저장
	private int carbabyseat;//렌트시 베이비시트 적용 여부 저장
	//비회원으로 렌트한 사람의 폰번호 , 주문 패스워드 저장
	private String memberphone, memberpass;
	
	//get,set메소드 
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getCarno() {
		return carno;
	}
	public void setCarno(int carno) {
		this.carno = carno;
	}
	public int getCarreserveday() {
		return carreserveday;
	}
	public void setCarreserveday(int carreserveday) {
		this.carreserveday = carreserveday;
	}
	public int getCarqty() {
		return carqty;
	}
	public void setCarqty(int carqty) {
		this.carqty = carqty;
	}
	public String getCarbegindate() {
		return carbegindate;
	}
	public void setCarbegindate(String carbegindate) {
		this.carbegindate = carbegindate;
	}
	public int getCarins() {
		return carins;
	}
	public void setCarins(int carins) {
		this.carins = carins;
	}
	public int getCarwifi() {
		return carwifi;
	}
	public void setCarwifi(int carwifi) {
		this.carwifi = carwifi;
	}
	public int getCarnave() {
		return carnave;
	}
	public void setCarnave(int carnave) {
		this.carnave = carnave;
	}
	public int getCarbabyseat() {
		return carbabyseat;
	}
	public void setCarbabyseat(int carbabyseat) {
		this.carbabyseat = carbabyseat;
	}
	public String getMemberphone() {
		return memberphone;
	}
	public void setMemberphone(String memberphone) {
		this.memberphone = memberphone;
	}
	public String getMemberpass() {
		return memberpass;
	}
	public void setMemberpass(String memberpass) {
		this.memberpass = memberpass;
	}
	

	
	
	
}





