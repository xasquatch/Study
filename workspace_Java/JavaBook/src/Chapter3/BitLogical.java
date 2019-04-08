package Chapter3;

public class BitLogical {

	public static void main(String[] args) {

		int i1 = 3;
		System.out.printf("%32s%n",Integer.toBinaryString(i1));
		int i2 = 5;
		System.out.printf("%32s%n",Integer.toBinaryString(i2));
		
		System.out.printf("%32s%n",Integer.toBinaryString(i1 & i2));
		System.out.printf("%32s%n",Integer.toBinaryString(i1 | i2));
		System.out.printf("%32s%n",Integer.toBinaryString(i1  ^ i2));
		System.out.printf("%32s%n",Integer.toBinaryString(~i1));

	}

}
