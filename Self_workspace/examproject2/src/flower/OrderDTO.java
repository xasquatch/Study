package flower;

import java.sql.Timestamp;

public class OrderDTO {
	
	private int orderno;
	private int flowerno;
	private Timestamp orderdate;
	private String flowername;
	private String flowerimg;
	private int flowerqty;
	private int flowerprice;
	private String flowercategory;
	private String memberid;
	private String membername;
	private String memberphone;
	private int memberpostcode;
	private String memberaddress;
	private String memberaddress2;
	
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public int getFlowerno() {
		return flowerno;
	}
	public void setFlowerno(int flowerno) {
		this.flowerno = flowerno;
	}
	public Timestamp getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}
	public String getFlowername() {
		return flowername;
	}
	public void setFlowername(String flowername) {
		this.flowername = flowername;
	}
	public String getFlowerimg() {
		return flowerimg;
	}
	public void setFlowerimg(String flowerimg) {
		this.flowerimg = flowerimg;
	}
	public int getFlowerqty() {
		return flowerqty;
	}
	public void setFlowerqty(int flowerqty) {
		this.flowerqty = flowerqty;
	}
	public int getFlowerprice() {
		return flowerprice;
	}
	public void setFlowerprice(int flowerprice) {
		this.flowerprice = flowerprice;
	}
	public String getFlowercategory() {
		return flowercategory;
	}
	public void setFlowercategory(String flowercategory) {
		this.flowercategory = flowercategory;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getMemberphone() {
		return memberphone;
	}
	public void setMemberphone(String memberphone) {
		this.memberphone = memberphone;
	}
	public int getMemberpostcode() {
		return memberpostcode;
	}
	public void setMemberpostcode(int memberpostcode) {
		this.memberpostcode = memberpostcode;
	}
	public String getMemberaddress() {
		return memberaddress;
	}
	public void setMemberaddress(String memberaddress) {
		this.memberaddress = memberaddress;
	}
	public String getMemberaddress2() {
		return memberaddress2;
	}
	public void setMemberaddress2(String memberaddress2) {
		this.memberaddress2 = memberaddress2;
	}
	
	
}
