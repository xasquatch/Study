package ch10.nested;

public class InstanceInnerTest {
	class Inner{
		int innerMem = 10;
		static final int finalstaticMem = 20;
		
		private void innerMethod() {
			System.out.println(outerMem+" "+innerMem);
		}
	}
	
	private int outerMem = 1;
	
	private void outerMethod() {
		
		Inner in = new Inner();
		in.innerMem = 100;
		in.innerMethod();

	}
	
	public static void main(String[] args) {
		InstanceInnerTest ins = new InstanceInnerTest();
		Inner inner = ins.new Inner();
		inner.innerMethod();
		ins.outerMethod();
		System.out.println(inner.innerMem);
		ins.outerMem = 111;
		System.out.println(ins.outerMem);
		InstanceInnerTest ins2 = new InstanceInnerTest();
		System.out.println(ins2.outerMem);
		
	}
}
