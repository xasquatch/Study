package ch08.inter.relation;

class Phone{}
class HandPhone extends Phone implements Chargeable{

	@Override
	public void charge() {
	
		System.out.println("HandPhone 충전중");
	}
	
}

class Camera{}
class DigitalCamera extends Camera implements Chargeable{

	@Override
	public void charge() {
		System.out.println("BlackBox 충전중");
		
	}
	
}

interface Chargeable{
	void charge();
}

public class RelationTest {

	void badCase() {
		Object [] objs = {new HandPhone(), new DigitalCamera()};
		for (Object obj : objs) {
			if (obj instanceof HandPhone) {
				HandPhone phone = (HandPhone)obj;
				phone.charge();
			}else if (obj instanceof DigitalCamera) {
				DigitalCamera camera = (DigitalCamera) obj;
				camera.charge();
			}
		}
	}
	
	void goodCase() {
		Chargeable [] abjs = {new HandPhone(),new DigitalCamera()};
		for (Chargeable chargeable : abjs) {
			chargeable.charge();
		}
	}
	public static void main(String[] args) {
		RelationTest ict = new RelationTest();
		ict.badCase();
		ict.goodCase();
	}

}
