package db;

//�ΰ��� ���̺�(carlist,carorder)�� JOIN�� �˻��Ͽ� ���� ������ ������ �������ִ� Ŭ���� 
public class CarConfirmBean {

	/*carlist���̺��� ���������� �˻��Ͽ� ������ �� ������ ���� */
	private String carname;
	private String carimg;
	private int carprice;
	
	/*carorder���̺��� ���������� �˻��Ͽ� ������ �� ������ ����*/
	private int orderid;
	private String carbegindate;
	private int carreserveday;
	private int carqty, carins, carwifi, carnave, carbabyseat;
	
	//getter, setter�޼ҵ� 
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public String getCarimg() {
		return carimg;
	}
	public void setCarimg(String carimg) {
		this.carimg = carimg;
	}
	public int getCarprice() {
		return carprice;
	}
	public void setCarprice(int carprice) {
		this.carprice = carprice;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getCarbegindate() {
		return carbegindate;
	}
	public void setCarbegindate(String carbegindate) {
		this.carbegindate = carbegindate;
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
	

	
	
	
	
	
	
	
	
}





