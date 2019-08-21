package ch08.abs.good;

abstract class Vehicle{
	private int curX, curY;
	
	public void reportPosition() {
		System.out.printf("���� ��ġ�� (%d, %d)�Դϴ�.%n",curX,curY);
	}
	
	public abstract void addFuel();
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
		System.out.println("--------------------");
		Vehicle ds = new DieselSUV();
		ds.addFuel();
		ds.reportPosition();
		System.out.println("--------------------");
		Vehicle et = new ElectricCar();
		et.addFuel();
		et.reportPosition();
	}

}
