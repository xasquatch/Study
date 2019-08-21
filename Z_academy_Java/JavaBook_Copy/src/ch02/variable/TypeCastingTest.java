package ch02.variable;

public class TypeCastingTest {

	public static void main(String[] args) {
		
		int i1 = 1234;
		long l1 = i1;
		byte b1 = (byte)i1;
		System.out.println(i1);
		System.out.println(l1);
		System.out.println(b1);
		
		double d1=i1;
		byte b2 = (byte)d1;
		System.out.println(d1);
		System.out.println(b2);
		
		double d2 = 0.12345678901234567890;
		float f1 = (float)d2;
		System.out.println(d2);
		System.out.println(f1);
		
		byte b3 = 67;
		char c1 = (char)b3;
		float f2 = c1;
		System.out.println(c1);
		System.out.println(f2);
		
		
	}

}
