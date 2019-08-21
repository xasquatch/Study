package ch03.monadic;

public class MonadicCasting {

	public static void main(String[] args) {

		byte b1 = 10;
		b1 += 1;
		System.out.println(b1);
		
		byte b2 = ++b1;
		System.out.println(b2);
		
		byte b3 = (byte)(b2+1);
		System.out.println(b3);
		
		
	}

}
