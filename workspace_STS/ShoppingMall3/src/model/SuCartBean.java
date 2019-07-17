package model;

//카트에 담을 수작업공구정보를 저장하는 자바빈 클래스  DTO
public class SuCartBean {

	private int suno, suprice, suqty;
	private String suname, suimg;

	// get,set메소드 추가
	public int getSuno() {
		return suno;
	}

	public void setSuno(int suno) {
		this.suno = suno;
	}

	public int getSuprice() {
		return suprice;
	}

	public void setSuprice(int suprice) {
		this.suprice = suprice;
	}

	public int getSuqty() {
		return suqty;
	}

	public void setSuqty(int suqty) {
		this.suqty = suqty;
	}

	public String getSuname() {
		return suname;
	}

	public void setSuname(String suname) {
		this.suname = suname;
	}

	public String getSuimg() {
		return suimg;
	}

	public void setSuimg(String suimg) {
		this.suimg = suimg;
	}

}
