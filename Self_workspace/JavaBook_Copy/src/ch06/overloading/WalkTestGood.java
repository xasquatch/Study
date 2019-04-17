package ch06.overloading;

public class WalkTestGood {

	void walk() {
		walk(100,"cm");
	}
	void walk(int a) {
		walk(a,"cm");
	}
	void walk(int a,String unit) {
		switch (unit) {
		case "cm":
			break;
		case "inch":
			a *=2.54;
			break;
		default:
			System.out.println("unknown");
			a = 0;
			
		}
		System.out.println(a+"!!!!!!!!!!!!!!!!");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WalkTestGood wg = new WalkTestGood();
		wg.walk();
		wg.walk(100);
		wg.walk(100,"cm");
	}

}
