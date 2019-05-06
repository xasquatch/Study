package ch08.enume;

enum Greeting{
	GOOD_MORNIG, GOOD_AFTERNOON, GOOD_EVENING;
	
	String message;
	
	public Greeting nextGreeting() {
		if (this.equals(GOOD_EVENING)) {
			return GOOD_MORNIG;
		}else if (this.equals(GOOD_AFTERNOON)) {
			return GOOD_EVENING;
		}else {
			return GOOD_AFTERNOON;
		}
	}
}

public class CustomMethodTest {

	public static void main(String[] args) {
		Greeting current = Greeting.GOOD_AFTERNOON;
		current.message = "Hello";
		Greeting next = current.nextGreeting();
		next.message = "HI";
		
		System.out.printf("���� : %s, �޽���%s%n",current,current.message);
		System.out.printf("���� : %s, �޽���%s%n",next,next.message);
		System.out.println(Greeting.GOOD_MORNIG.name());
	}

}
