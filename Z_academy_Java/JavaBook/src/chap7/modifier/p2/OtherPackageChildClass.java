package chap7.modifier.p2;

import chap7.modifier.p1.Parent;

public class OtherPackageChildClass extends Parent {

	public void useMember() {

		this.publicVar = 10;
		this.protectVar = 10;

//		this.defaultVar = 10;
//		this.privVar = 10;

	}

}
