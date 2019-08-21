package ch10.nested;

public class LocalInnerTest {

	int iMem = 1;
	static int cMem = 2;
	
	void method() {
		int localVar = 3;
		
		class LocalInner{
			int innerLocalVar = 4;
			void innerMethod() {
				System.out.printf("외부 인스턴스 멤버 변수 %d%n",iMem);
				System.out.printf("외부 클래스 멤버 변수 %d%n",cMem);
				System.out.printf("외부 로컬 변수 %d%n",localVar);
				System.out.printf("내부 인스턴스 멤버 변수 %d%n",innerLocalVar);
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
