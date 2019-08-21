package ch07.modifier;

class FinalMemberClass {

	final String name;

	public FinalMemberClass(String name) {
		this.name = name;
	}

		
	
}

public class BlankFinalTest {

	public static void main(String[] args) {
		FinalMemberClass fm1 = new FinalMemberClass("hong");
		FinalMemberClass fm2 = new FinalMemberClass("lim");
		
		System.out.printf("name:fm1-%s,fm2-%s\n",fm1.name,fm2.name);
		
//		fm1.name = "kim";
		
		
	}
}
