package Chapter7;

class FinalMemberClass {
	final String name;

	public FinalMemberClass(String name) {
		this.name = name;

	}

}

public class BlankFinalTest {

	public static void main(String[] args) {

		FinalMemberClass fmc1 = new FinalMemberClass("hong");
		FinalMemberClass fmc2 = new FinalMemberClass("lim");

		System.out.printf("name : fmc1 = %s, fmc2 = %s%n", fmc1.name, fmc2.name);

	}

}
