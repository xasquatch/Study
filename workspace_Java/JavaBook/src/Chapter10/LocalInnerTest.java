package Chapter10;

public class LocalInnerTest {

	int iMember = 1;
	static int cMember = 2;
	
	void method() {
		int localVar = 3;
	
		class LocalInner{
			int innerLocalVar = 4;
			void innerMethod() {
				System.out.println("외부 인스턴스 멤버" + iMember);
				System.out.println("외브 클래스 멤버" + cMember);
				System.out.println("외부로컬변수"+localVar);
				System.out.println("내부 인스턴스변수" + innerLocalVar);
				iMember++;
				cMember++;
				innerLocalVar++;
				System.out.println();
				System.out.println("외부 인스턴스 멤버" + iMember);
				System.out.println("외브 클래스 멤버" + cMember);
				System.out.println("외부로컬변수"+localVar);
				System.out.println("내부 인스턴스변수" + innerLocalVar);
				
			}
		}
		LocalInner LInner = new LocalInner();
		LInner.innerMethod();
	}
	public static void main(String[] args) {
		LocalInnerTest lit = new LocalInnerTest();
		lit.method();
	
	}
}
