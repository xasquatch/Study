package ch10.lambda;

@FunctionalInterface
interface FunctionalInterface4{
	String methodB(String msg);
}

public class VariableUseTest {
	private int instanceMember = 10;
	
	public void useFIMethod(FunctionalInterface4 fi) {
		System.out.println(fi.methodB("ȫ�浿"));
	}
	
	public void lambdaTestMethod() {
		int localVar = 20;
		
		useFIMethod((String msg)->{
				System.out.println("this:"+this);
				System.out.println("�ܺ�.this:"+VariableUseTest.this);
				System.out.println("���� ����:"+localVar+" : "+instanceMember);
				return "���ٽ� �̿� "+msg+", "+(instanceMember++);
			});
		
		useFIMethod(new FunctionalInterface4() {
			
			@Override
			public String methodB(String msg) {
				System.out.println("this:"+this);
				System.out.println("�ܺ�.this:"+VariableUseTest.this);
				System.out.println("���� ����:"+localVar+" : "+instanceMember);
				return "�͸��� ���� Ŭ���� �̿� "+msg+", "+(instanceMember++);
			}
		});
		
	}
	public static void main(String[] args) {
		VariableUseTest vi = new VariableUseTest();
		vi.lambdaTestMethod();

	}

}
