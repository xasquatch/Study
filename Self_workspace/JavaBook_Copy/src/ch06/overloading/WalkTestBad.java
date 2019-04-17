package ch06.overloading;

public class WalkTestBad {

	void walk() {
		System.out.println("100cm");
	}
	
	void walk(int a) {
		System.out.println(a);
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
			break;
		}
		System.out.println(a+"!!!!!!!!!!!!!!!!");
	}
	public static void main(String[] args) {
		WalkTestBad wb = new WalkTestBad();
		wb.walk();
		wb.walk(12);
		wb.walk(15,"inch");
	}

}
