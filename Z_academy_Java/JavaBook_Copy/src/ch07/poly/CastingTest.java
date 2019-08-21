package ch07.poly;

import ch07.extend.Person;
import ch07.extend.SpiderMan;

public class CastingTest {

	public void primitve() {
		byte b = 10;
		
		int i = b;
		
		byte b2 = (byte)i;
	}
	
	public void reference() {
		Person p = new SpiderMan();
//		p.fireWeb();
		SpiderMan sman = (SpiderMan)p;
		sman.fireWeb();
		SpiderMan s = new SpiderMan();
		s.fireWeb();
	}
	
}
