package ch08.abs.bad;

class DieselSUV {

	private int curX, curY;
	
	public void reportPosition() {
		System.out.printf("���� ��ġ�� (%d, %d)�Դϴ�.%n",curX,curY);
	}
	
	public void addFuel() {
		System.out.printf("�����ҿ��� ����");

	}
}

class ElectricCar{
	private int curX,curY;
	
	public void reportPosition() {
		System.out.printf("���� ��ġ�� (%d, %d)�Դϴ�.%n",curX,curY);
	}
	
	public void addFuel() {
		System.out.printf("�޼� ����");

	}
}
public class CarTest {
	public static void main(String[] args) {
		
		
	}
}