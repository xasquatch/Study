package myboard;

import java.sql.Timestamp;

public class BoardDto {
	private int no;
	private String main_img;
	private String title;
	private String content;
	private String category;
	private String more_category;
	private int bin_price;
	private int bid_price;
	private Timestamp start_time;
	private Timestamp end_time;
	private String area;
	private String trade;
	private String address;
	private String address2;
	private String coords;
	private int status;
	private  String id;
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getMain_img() {
		return main_img;
	}
	public void setMain_img(String main_img) {
		this.main_img = main_img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMore_category() {
		return more_category;
	}
	public void setMore_category(String more_category) {
		this.more_category = more_category;
	}
	public int getBin_price() {
		return bin_price;
	}
	public void setBin_price(int bin_price) {
		this.bin_price = bin_price;
	}
	public int getBid_price() {
		return bid_price;
	}
	public void setBid_price(int bid_price) {
		this.bid_price = bid_price;
	}
	public Timestamp getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}
	public String getTrade() {
		return trade;
	}
	public void setTrade(String trade) {
		this.trade = trade;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getStart_time() {
		return start_time;
	}
	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}
	public String getCoords() {
		return coords;
	}
	public void setCoords(String coords) {
		this.coords = coords;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
