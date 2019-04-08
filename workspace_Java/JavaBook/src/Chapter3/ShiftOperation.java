package Chapter3;

public class ShiftOperation {

	public static void main(String[] args) {
		
		int a = 0b1000;
		System.out.printf("%32, %d%n", Integer.toBinaryString(a),a);
		int b = a << 2;
		System.out.printf("%32, %d%n", Integer.toBinaryString(b),b);
		int d = a >> 2;
		System.out.printf("%32, %d%n", Integer.toBinaryString(d),d);
		int e = a >>> 2;
		System.out.printf("%32, %d%n", Integer.toBinaryString(e),e);

		
	}

}
