package ch11.string;


class UseIndex {

	public UseIndex() {
		String ssn = "000518-3111111";
		char gender = ssn.charAt(7);
		if (gender == '1' || gender == '3') {
			System.out.println("남");
		} else if (gender == '2' || gender == '4') {
			System.out.println("여");
		} else {
			System.out.println("불명");
		}

	}

}

class EqualsTest{

	public EqualsTest() {
		String str = "Hello";
		System.out.println("hello".equals(str));
		System.out.println("hello".equalsIgnoreCase(str));
	}
	
}

class MaskingTest{

	public MaskingTest() {
		String hp = "010-1234-5678";
		String last4 = hp.substring(9,hp.length());
		System.out.printf("추출문자열\t%s%n",last4);
		String Masked = hp.replace(last4, "****");
		System.out.println(Masked);
	}
	
}

public class UseIndex$EqualsTest$MaskingTest {

	public static void main(String[] args) {
		UseIndex s1 = new UseIndex();
		System.out.println();
		EqualsTest s2 = new EqualsTest();
		System.out.println();
		MaskingTest s3 = new MaskingTest();
	}

}
