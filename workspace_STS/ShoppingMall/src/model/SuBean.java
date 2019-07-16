package model;

import java.sql.Date;

public class SuBean { //하나의 수작업공구 정보를 저장 또는 공유할 목적
	
	private int suno, suprice;
	private String suname, suinfo, suimg, sutemp, sucategory;
	private Date sudate;
	
	public SuBean() {}
	public SuBean(int suno, int suprice, String suname, String suinfo, String suimg, String sutemp, String sucategory,
			Date sudate) {
		super();
		this.suno = suno;
		this.suprice = suprice;
		this.suname = suname;
		this.suinfo = suinfo;
		this.suimg = suimg;
		this.sutemp = sutemp;
		this.sucategory = sucategory;
		this.sudate = sudate;
	}
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
	public String getSuname() {
		return suname;
	}
	public void setSuname(String suname) {
		this.suname = suname;
	}
	public String getSuinfo() {
		return suinfo;
	}
	public void setSuinfo(String suinfo) {
		this.suinfo = suinfo;
	}
	public String getSuimg() {
		return suimg;
	}
	public void setSuimg(String suimg) {
		this.suimg = suimg;
	}
	public String getSutemp() {
		return sutemp;
	}
	public void setSutemp(String sutemp) {
		this.sutemp = sutemp;
	}
	public String getSucategory() {
		return sucategory;
	}
	public void setSucategory(String sucategory) {
		this.sucategory = sucategory;
	}
	public Date getSudate() {
		return sudate;
	}
	public void setSudate(Date sudate) {
		this.sudate = sudate;
	}
	
	
}
