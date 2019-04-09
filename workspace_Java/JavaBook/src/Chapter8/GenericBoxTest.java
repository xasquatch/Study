package Chapter8;

class Toy2 {}

class Grocery2 {}

class GenericBox<T>{
	private T some;
	public T getSome() {
		return some;
	}
	public void setSome(T som) {
		this.some = some;
	}
}

public class GenericBoxTest {

	public static void main(String[] args) {
		GenericBox<Toy2> gBox1 = new GenericBox<>();
		gBox1.setSome(new Toy2());
		Toy2 toy = gBox1.getSome();
		GenericBox<Grocery2> gBox2 = new GenericBox<>();
		gBox2.setSome(new Grocery2());
		Grocery2 grocery = gBox2.getSome();
		
	}

}
