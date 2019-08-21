package Chapter7;

public class CastingTest {

	public void primitive() {
		byte b = 10;
		int i =b;
		byte b2 = (byte)i;
		
	}
	
	public void reference() {
		Person p = new SpiderMan();
//		p.fireWeb();
		SpiderMan sman = (SpiderMan)p;
		sman.fireWeb();
		
	}
	
	
}
