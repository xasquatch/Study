package ch08.abs.middle;

class Vehicle{
	private int curX, curY;
	
	public void reportPosition() {
		System.out.printf("현재 위치는 (%d, %d)입니다.%n",curX,curY);
	}
	
	public void addFuel() {
		System.out.printf("연료 필요");

	}

}

class DieselSUV extends Vehicle{

	@Override
	public void addFuel() {
		System.out.println("주유소에서 급유");
	}
	
}

class ElectricCar extends Vehicle{

	@Override
	public void addFuel() {
		System.out.println("급속충전");
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
