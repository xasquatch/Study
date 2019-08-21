package ch02.variable;

public class IntegerTest {

	public static void main(String[] args) {
		byte b1 = -128;
		byte b2 = 127;
		System.out.println(b1+" "+b2);
		
		int i1 = 15;
		int i2 = 0b1111;
		int i3 = 017;
		int i4 = 0xf;

		System.out.println(i1+" "+i2+" "+i3+" "+i4);
		
		int i5 = 1_000_000_000;
		System.out.println(i5);
		
		long l2 = 1000000000L;
		System.out.println(l2);
		
	}

}
