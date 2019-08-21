package chap7.modifier.p1;

public class SamePackageChildClass extends Parent {

	public void useMember() {

		this.publicVar = 10;
		this.protectVar = 10;
		this.defaultVar = 10;

//		this.privVar = 10;

	}

}
