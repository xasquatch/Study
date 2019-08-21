package ch02.variable;

public class CharTest {

	public static void main(String[] args) {

		char c1 = 'A';
		char c2 = '\u0041';
		System.out.println("문자출력 : "+c1+"\t"+c2+"\n");
		
		int i = c1 + 1;
		System.out.println(i);
		System.out.println((char)i);
		
	}

}
