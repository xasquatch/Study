package chap7.modifier.p2;

import chap7.modifier.p1.Parent;

public class OtherPackageSomeClass extends Parent {

	public void method() {
		Parent p = new Parent();
		p.publicVar = 10;
//		p.protectVar = 10;
//		p.defaultVar = 10;
//		p.privVar = 10;

	}

}
