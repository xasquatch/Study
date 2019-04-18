package ch10.nested;

public class DuplicatedNameTest {
	private int num = 100;
	private static int num2 = 111;
	class InnerClass{
		private int num = 200;
		
		public void method() {
			System.out.println(num);
			System.out.println(this.num);
			System.out.println(DuplicatedNameTest.this.num);
			DuplicatedNameTest du = new DuplicatedNameTest();
			du.num2 = 222;
			du.num = 333;
			num = 9999;
			System.out.printf("%d thisnum\n",this.num);
			System.out.printf("%d dunum\n",du.num);
			System.out.println(DuplicatedNameTest.this.num);
			System.out.println(DuplicatedNameTest.num2);
		}
	}
	
	
	public static void main(String[] args) {
		DuplicatedNameTest dnt = new DuplicatedNameTest();
		InnerClass ic = dnt.new InnerClass();
		System.out.printf("메인메서드 출력 %d",ic.num);
		ic.method();
		System.out.printf("메인메서드 출력 %d",ic.num);
	}
}
