package ch11.string;

public class NewStringTest {

	public static void main(String[] args) {
		
		String s1 = "Hello";
		String s2 = "Hello";
		System.out.println("== ������"+(s1==s2?"����":"�ٸ�"));
		System.out.println("equals"+(s1.equals(s2)));
		
		String s3 = new String("Hello");
		String s4 = new String("Hello");
		System.out.println("== ������"+(s3==s4?"����":"�ٸ�"));
		System.out.println("equals"+(s3.equals(s4)));
		
	}
}
