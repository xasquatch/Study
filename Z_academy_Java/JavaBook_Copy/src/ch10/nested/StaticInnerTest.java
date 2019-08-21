package ch10.nested;

import ch10.nested.StaticInnerTest.StaticInner;

public class StaticInnerTest {
	static class StaticInner{
		private int iMem = 10;
		private static int sMem = 0;
		
		private void innerMethod() {
			StaticInnerTest sit = new StaticInnerTest();
			System.out.printf("%d   %d  %n",iMem,sit.oMem);
		}
	}
	
	private int oMem = 1;
	
	private void outerMethod() {
		StaticInner si = new StaticInner();
		si.iMem = 100;
		si.sMem = 444;
		si.innerMethod();
	}
	
	public static void main(String[] args) {
		StaticInner si = new StaticInner();
		si.innerMethod();
		StaticInnerTest sit = new StaticInnerTest();
		sit.outerMethod();
		System.out.println(StaticInner.sMem);
		StaticInner si2 = new StaticInner();
		System.out.println(si2.iMem);
	}
}
