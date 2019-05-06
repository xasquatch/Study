package ch08.generic.type;

class Toy{}
class Grocery{}

class NormalBox{
	private Object some;
	public Object getSome() {
		return some;
	}
	public void setSome(Object some) {
		this.some = some;
	}
}

public class NormalBoxTest {

	public static void main(String[] args) {
		NormalBox nbox1 = new NormalBox();
		nbox1.setSome(new Toy());
		Object some = nbox1.getSome();
		if (some instanceof Toy) {
			Toy toy = (Toy)some;
			System.out.println("TOY");
		}else if (some instanceof Grocery) {
			Grocery grocery = (Grocery)some;
			System.out.println("GROCERY");
		}else {
			System.out.println("알수없음");
		}
		
		
	}

}
