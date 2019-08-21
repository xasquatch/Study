package ch05.basic;

public class BoundsTest {

	public static void main(String[] args) {

		char [] charArray = new char [3];
		for (int i = 0; i < charArray.length; i++) {
			charArray[i] = (char)(i+'A');
			System.out.println(charArray[i]);
		}
		for (int i = 0; i < 4; i++) {
			System.out.println(i+" "+charArray[i]);
		}
	}

}
