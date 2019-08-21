package Chapter8;

abstract class Vehicle {

	private int curX, curY;
	
	public void reportPosition() {
		System.out.println(curX+" "+curY);
	}
	
	public abstract void addFuel();
	
}

class ElectricCar extends Vehicle{

	public void addFuel() {
		System.out.println("급속 충전");
	}
	
}

class DieselSUV extends Vehicle {

	

	public void addFuel() {
		System.out.println("주유소에서 급유");
	}
	
}


public class VehicleTest{
	
	public static void main(String[] args) {

		Vehicle [] vehicles = { new DieselSUV(), new ElectricCar()};
		for (Vehicle v : vehicles) {
			v.addFuel();
			v.reportPosition();
		}
		
		
	}

}