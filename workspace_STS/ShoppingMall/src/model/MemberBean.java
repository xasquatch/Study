package model;

public class MemberBean {

	private String memid, mempasswd1, mempasswd2, memname, memphone, memdate;

	public MemberBean() {
	}

	public MemberBean(String memid, String mempasswd1, String mempasswd2, String memname, String memphone,
			String memdate) {
		this.memid = memid;
		this.mempasswd1 = mempasswd1;
		this.mempasswd2 = mempasswd2;
		this.memname = memname;
		this.memphone = memphone;
		this.memdate = memdate;
	}

	public String getMemid() {
		return memid;
	}

	public void setMemid(String memid) {
		this.memid = memid;
	}

	public String getMempasswd1() {
		return mempasswd1;
	}

	public void setMempasswd1(String mempasswd1) {
		this.mempasswd1 = mempasswd1;
	}

	public String getMempasswd2() {
		return mempasswd2;
	}

	public void setMempasswd2(String mempasswd2) {
		this.mempasswd2 = mempasswd2;
	}

	public String getMemname() {
		return memname;
	}

	public void setMemname(String memname) {
		this.memname = memname;
	}

	public String getMemphone() {
		return memphone;
	}

	public void setMemphone(String memphone) {
		this.memphone = memphone;
	}

	public String getMemdate() {
		return memdate;
	}

	public void setMemdate(String memdate) {
		this.memdate = memdate;
	}

}