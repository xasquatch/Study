package mybean;
// 자바빈의 종류는 DTO, DAO클래스로 나뉜다

// DTO클래스 : 여러 데이터를 하나로 묶어서 처리할 수 있음
//			 DB에 레코드를 저장할 때 DTO클래스 단위로 저장할 수 있다.

public class MemberDto {

	private String hname;
	private String id;
	private String password1;  
	private String password2;   
	private String email; 
	private int birthyear;
	private int birthmonth;
	private int birthdate; 
	private String sex;
	private String etcphone;
	private int postcode;
	private String address;
	private String address2;
	
	// getter, setter 메소드
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBirthyear() {
		return birthyear;
	}
	public void setBirthyear(int birthyear) {
		this.birthyear = birthyear;
	}
	public int getBirthmonth() {
		return birthmonth;
	}
	public void setBirthmonth(int birthmonth) {
		this.birthmonth = birthmonth;
	}
	public int getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(int birthdate) {
		this.birthdate = birthdate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEtcphone() {
		return etcphone;
	}
	public void setEtcphone(String etcphone) {
		this.etcphone = etcphone;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
}
