package model;

import java.sql.Date;

//DTO
public class SuBean { // 하나의 수작업공구 정보를 저장 또는 공유할 목적

	private int suno, suprice;
	private String suname, suinfo, suimg, sutemp, sucate;
	private Date sudate;

	// getter,setter메소드
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

	public String getSucate() {
		return sucate;
	}

	public void setSucate(String sucate) {
		this.sucate = sucate;
	}

	public Date getSudate() {
		return sudate;
	}

	public void setSudate(Date sudate) {
		this.sudate = sudate;
	}

}
