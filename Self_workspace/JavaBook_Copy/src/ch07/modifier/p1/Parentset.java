package ch07.modifier.p1;

class Parent {

	public static int publicVars;
	protected static int protectVars;
	static int defaultVars;
	private static int privVars;//private

	
	public int publicVar;
	protected int protectVar;
	int defaultVar;
	private int privVar;

	public void useMember() {

		this.publicVar = 10;
		this.protectVar = 10;
		this.defaultVar = 10;
		this.privVar = 10;
	}
	public static void use() {

		System.out.println("fucxxxu");
	}
}

class NonePackageClass{
	
	public void name() {
		Parent p1 = new Parent();
		p1.publicVar = 10;
		p1.protectVar = 10;
		p1.defaultVar = 10;
		
	}
}

class SamePackageChildClass extends Parent{

	public void use1() {
		this.publicVar = 10;
		this.protectVar = 10;
		this.defaultVar = 10;
		
		
	}
	
	
}


public class Parentset {
	public static void main(String[] args) {
		Parent.publicVars = 10;
		Parent p1 = new Parent();
		p1.publicVar = 10;
		System.out.println(p1.publicVar+" "+Parent.publicVars);
		
	}
}
