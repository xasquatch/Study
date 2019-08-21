package Chapter4;

public class NestedForTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i = 0; i < 10; i++) {
			for(int j = 0; j<10 && j<=i; i++) {
			System.out.print("*");
		}
			System.out.println();
	}
}
}