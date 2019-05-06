package ch08.generic.type;

class Toy2{}

class Grocery2{}

class GenericBox<T>{
	private T some;
	public T getSome() {
		return some;
	}
	public void setSome(T some) {
		this.some = some;
	}
	
}

public class GenericBoxTest {

	public static void main(String[] args) {
		GenericBox <Toy2> gbox1 = new GenericBox<Toy2>();
		gbox1.setSome(new Toy2());
		Toy2 toy = gbox1.getSome();
		GenericBox<Grocery2> gbox2 = new GenericBox<Grocery2>();
		gbox2.setSome(new Grocery2());
		Grocery2 grocery = gbox2.getSome();
		GenericBox<Object> gbox3 = new GenericBox();
		gbox3.setSome(new Grocery2());
		gbox3.setSome(new Toy2());
	}

}
