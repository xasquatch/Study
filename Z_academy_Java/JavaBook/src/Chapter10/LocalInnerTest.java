package Chapter10;

public class LocalInnerTest {

	int iMember = 1;
	static int cMember = 2;
	
	void method() {
		int localVar = 3;
	
		class LocalInner{
			int innerLocalVar = 4;
			void innerMethod() {
				System.out.println("�ܺ� �ν��Ͻ� ���" + iMember);
				System.out.println("�ܺ� Ŭ���� ���" + cMember);
				System.out.println("�ܺη��ú���"+localVar);
				System.out.println("���� �ν��Ͻ�����" + innerLocalVar);
				iMember++;
				cMember++;
				innerLocalVar++;
				System.out.println();
				System.out.println("�ܺ� �ν��Ͻ� ���" + iMember);
				System.out.println("�ܺ� Ŭ���� ���" + cMember);
				System.out.println("�ܺη��ú���"+localVar);
				System.out.println("���� �ν��Ͻ�����" + innerLocalVar);
				
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