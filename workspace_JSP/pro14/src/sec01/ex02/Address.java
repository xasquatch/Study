package sec01.ex02;

public class Address {
	//회원의 거주도시이름과 우편번호를 저장하기 위해 속성 선언
	private String city, zipcode;

	public Address(){}
	public Address(String city, String zipcode) {
		this.city = city;
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
