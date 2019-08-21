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
//				System.out.printf("�ܺ� �ν��Ͻ� ��� ���� %d%n",iMem);
				System.out.printf("�ܺ� Ŭ���� ��� ���� %d%n",cMem);
				System.out.printf("�ܺ� ���� ���� %d%n",localVar);
				
				cMem++;
//				localVar++;
				
			}
		});

	}

}
