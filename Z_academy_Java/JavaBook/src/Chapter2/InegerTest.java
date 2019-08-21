package Chapter2;

public class InegerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		byte b1 = -128;
		
		System.out.println(b1);
//		byte b2 = 128;
		byte b2 = 127;
		
		System.out.println(b2);
	
		
		int i1 = 15;
		int i2 = 0b1111;
		int i3 = 017;
		int i4 = 0xf;
		
		System.out.println(i1 + ", " + i2 + ", " + i3 + ", " + i4);			
		
		int i5 = 1_000_000_000;
		System.out.println(i5);
		
//		long l1 = 10000000000;
		//the literal 10000000000 of type int is out of range
		long l2 = 1000000000L;
		System.out.println(l2);
		
	}

}
