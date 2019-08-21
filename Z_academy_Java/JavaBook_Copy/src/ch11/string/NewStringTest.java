package ch11.string;

public class NewStringTest {

	public static void main(String[] args) {
		
		String s1 = "Hello";
		String s2 = "Hello";
		System.out.println("== 연산결과"+(s1==s2?"같음":"다름"));
		System.out.println("equals"+(s1.equals(s2)));
		
		String s3 = new String("Hello");
		String s4 = new String("Hello");
		System.out.println("== 연산결과"+(s3==s4?"같음":"다름"));
		System.out.println("equals"+(s3.equals(s4)));
		
	}
}
