package ch08.generic.type;

class NumberBox<T extends Number>{
	public void addSomes(T...ts) {
		double d = 0;
		for (T t : ts) {
			d += t.doubleValue();
		}
		System.out.println("SUM= "+d);
	}
}

public class ExtendsTest {

	public static void main(String[] args) {
		NumberBox<Number> numbox = new NumberBox();
		numbox.addSomes(1.5, 5, 4L);
		
		NumberBox<Integer> intBox = new NumberBox();
		numbox.addSomes(1,2,3);
		
//		NumberBox<String> strBox = new NumberBox();
		
		
		
	}

}
