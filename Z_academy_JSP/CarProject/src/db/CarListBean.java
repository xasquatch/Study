package db;

//VO , DTO 역할을 하는 클래스 
public class CarListBean {
	//차한대의 정보를 저장할 각변수
	private int carno; //차번호
	private String carname;//차이름
	private String carcompany;//차제조사
	private int carprice;//차한대당 렌트가격
	private int carusepeople; //차인승
	private String carinfo; //차 소개 정보
	private String carimg; //차이미지명
	private String carcategory; //차종류(대형,소형,중형)
	
	//getter,setter메소드
	public int getCarno() {
		return carno;
	}
	public void setCarno(int carno) {
		this.carno = carno;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public String getCarcompany() {
		return carcompany;
	}
	public void setCarcompany(String carcompany) {
		this.carcompany = carcompany;
	}
	public int getCarprice() {
		return carprice;
	}
	public void setCarprice(int carprice) {
		this.carprice = carprice;
	}
	public int getCarusepeople() {
		return carusepeople;
	}
	public void setCarusepeople(int carusepeople) {
		this.carusepeople = carusepeople;
	}
	public String getCarinfo() {
		return carinfo;
	}
	public void setCarinfo(String carinfo) {
		this.carinfo = carinfo;
	}
	public String getCarimg() {
		return carimg;
	}
	public void setCarimg(String carimg) {
		this.carimg = carimg;
	}
	public String getCarcategory() {
		return carcategory;
	}
	public void setCarcategory(String carcategory) {
		this.carcategory = carcategory;
	}
	

	
	
	
}
