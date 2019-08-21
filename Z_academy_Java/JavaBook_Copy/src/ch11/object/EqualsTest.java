package ch11.object;

class Phone{
	
	String number = "전화번호";
	
	public Phone(String number) {
		this.number = number;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Phone) {
			Phone casted = (Phone) obj;
			return number.equals(casted.number);
		}
		return false;
	}
	
	
}
public class EqualsTest {
	private static void testString() {
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		System.out.println("String : "+(s1==s2)+":"+s1.equals(s2));
	}
	
	private static void testPhone() {
		Phone p1 = new Phone("01000000000");
		Phone p2 = new Phone("01000000000");
		System.out.println("Phone : "+(p1==p2)+":"+p1.equals(p2));
	}
	public static void main(String[] args) {
		Phone p1 = new Phone("01000000000");
		String s1 = new String("Hello");
		System.out.println(s1.equals(p1));
		testString();
		testPhone();
	}
}
