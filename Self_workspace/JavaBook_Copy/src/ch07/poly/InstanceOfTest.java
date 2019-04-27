package ch07.poly;

import ch07.extend.Person;
import ch07.extend.SpiderMan;

public class InstanceOfTest {

	public void badCasting() {
		Person ps = new Person();
		SpiderMan sman = (SpiderMan)ps;
		sman.fireWeb();
	}
	
	public void goodCasting() {
		Person ps = new Person();
		
		if (ps instanceof SpiderMan) {
			SpiderMan sman = (SpiderMan) ps;
			sman.fireWeb();
		}else {
			System.out.println("∫Œ¿˚«’");
		}
		
	}
	
	public static void main(String[] args) {
		InstanceOfTest i = new InstanceOfTest();
		
//		i.badCasting();
		i.goodCasting();

	}

}
