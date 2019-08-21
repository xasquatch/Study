package ch08.abs.middle;

class Vehicle{
	private int curX, curY;
	
	public void reportPosition() {
		System.out.printf("���� ��ġ�� (%d, %d)�Դϴ�.%n",curX,curY);
	}
	
	public void addFuel() {
		System.out.printf("���� �ʿ�");

	}

}

class DieselSUV extends Vehicle{

	@Override
	public void addFuel() {
		System.out.println("�����ҿ��� ����");
	}
	
}

class ElectricCar extends Vehicle{

	@Override
	public void addFuel() {
		System.out.println("�޼�����");
	}
	
}

public class VehicleTest {

	public static void main(String[] args) {
		Vehicle[] vh = {new DieselSUV(),new ElectricCar()};
		for (Vehicle v : vh) {
			v.addFuel();
			v.reportPosition();
		}
		
	}

}
