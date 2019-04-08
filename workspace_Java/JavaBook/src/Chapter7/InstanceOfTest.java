package Chapter7;

public class InstanceOfTest {

	public void badCasting() {
		Person person = new Person();
		SpiderMan sman = (SpiderMan) person;
		sman.fireWeb();
	}

	public void goodCasting() {
		Person person = new Person();
		if (person instanceof SpiderMan) {
			SpiderMan sman = (SpiderMan) person;
			sman.fireWeb();
		} else {
			System.out.println("SpiderMan에 적합하지 않은 객체");
		}
	}

	public static void main(String[] args) {
		InstanceOfTest iot = new InstanceOfTest();
//		iot.badCasting();
		iot.goodCasting();
	}

}
