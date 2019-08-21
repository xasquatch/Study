package ch10.nested;

interface SomeInterface{
	void printInfo();
}

public class AnonymousInnerTest {
	int iMem = 1;
	static int cMem = 2;
	
	void method(SomeInterface si) {
		si.printInfo();
	}
	public static void main(String[] args) {

		AnonymousInnerTest lit = new AnonymousInnerTest();
		int localVar = 3;
		System.out.println(lit.iMem);
		lit.method(new SomeInterface() {
			
			@Override
			public void printInfo() {
//				System.out.printf("외부 인스턴스 멤버 변수 %d%n",iMem);
				System.out.printf("외부 클래스 멤버 변수 %d%n",cMem);
				System.out.printf("외부 로컬 변수 %d%n",localVar);
				
				cMem++;
//				localVar++;
				
			}
		});

	}

}
