package ch10.nested;

public class LocalInnerTest {

	int iMem = 1;
	static int cMem = 2;
	
	void method() {
		int localVar = 3;
		
		class LocalInner{
			int innerLocalVar = 4;
			void innerMethod() {
				System.out.printf("�ܺ� �ν��Ͻ� ��� ���� %d%n",iMem);
				System.out.printf("�ܺ� Ŭ���� ��� ���� %d%n",cMem);
				System.out.printf("�ܺ� ���� ���� %d%n",localVar);
				System.out.printf("���� �ν��Ͻ� ��� ���� %d%n",innerLocalVar);
				iMem++;
				cMem++;
//				localVar++;
				innerLocalVar++;
			}
		}
		LocalInner ln = new LocalInner();
		ln.innerMethod();
	}
	
	public static void main(String[] args) {
		LocalInnerTest lit = new LocalInnerTest();
		lit.method();
		
	}
}
