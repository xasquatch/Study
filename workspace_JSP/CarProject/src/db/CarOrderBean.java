package db;

//����(��Ʈ)������ ���� �����͵��� ��� �δ� DTOŬ���� 
public class CarOrderBean {

	private int orderid;//�ڵ��� ��Ʈ �ֹ� id ����
	//��Ʈ�� ���� ����ȣ ���� : ����ȣ�� �̿��Ͽ� �ΰ��� ���̺��� �����Ͽ� �˻� �ϱ� ����.
	private int carno;//��Ʈ�� ���� ����ȣ ����
	private int carreserveday;//��Ʈ�� ���� �뿩 �Ⱓ ����
	private int carqty;//��Ʈ�� ���� �뿩 ���� ����
	private String carbegindate;//�뿩��¥ 
	private int carins;//��Ʈ�� �������� ���� ����
	private int carwifi;//��Ʈ�� WIFI���� ���� ����
	private int carnave;//��Ʈ�� �׺���̼� ���� ���� ����
	private int carbabyseat;//��Ʈ�� ���̺��Ʈ ���� ���� ����
	//��ȸ������ ��Ʈ�� ����� ����ȣ , �ֹ� �н����� ����
	private String memberphone, memberpass;
	
	//get,set�޼ҵ� 
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getCarno() {
		return carno;
	}
	public void setCarno(int carno) {
		this.carno = carno;
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
	public String getCarbegindate() {
		return carbegindate;
	}
	public void setCarbegindate(String carbegindate) {
		this.carbegindate = carbegindate;
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
	public String getMemberphone() {
		return memberphone;
	}
	public void setMemberphone(String memberphone) {
		this.memberphone = memberphone;
	}
	public String getMemberpass() {
		return memberpass;
	}
	public void setMemberpass(String memberpass) {
		this.memberpass = memberpass;
	}
	

	
	
	
}





