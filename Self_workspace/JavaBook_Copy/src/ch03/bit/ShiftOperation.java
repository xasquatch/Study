package ch03.bit;

public class ShiftOperation {

	public static void main(String[] args) {
		
		int a = 0b1000;
		System.out.printf("%32s, %d%n",Integer.toBinaryString(a),a);
		int b = a << 2;
		System.out.printf("%32s, %d%n",Integer.toBinaryString(b),b);
		int d = a >> 2;
		System.out.printf("%32s, %d%n",Integer.toBinaryString(d),d);
		int e = a >>> 2;
		System.out.printf("%32s, %d%n",Integer.toBinaryString(e),e);
		
		a= -100;
		System.out.println(Integer.toBinaryString(a));
		
		int f = a>>2;
		System.out.printf("%32s, %d%n",Integer.toBinaryString(f),f);
		
		int g = a >>>2;
		System.out.printf("%32s, %d%n",Integer.toBinaryString(g),g);
		
		
		
		
		
	}

}
