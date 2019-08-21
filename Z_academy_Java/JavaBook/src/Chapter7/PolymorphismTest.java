package Chapter7;

public class PolymorphismTest {

	public static void main(String[] args) {
		SpiderMan sman = new SpiderMan();
		Person person = sman;
		Object obj = sman;

		System.out.printf("sman==person? %b%n", sman == person);
		System.out.printf("sman==obj? %b%n", sman == obj);
	}

}
