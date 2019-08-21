package ch11.object;

public class GetClassTest {

	public void sayHello(){
		System.out.println("Hello");
	}
	public static void main(String[] args) throws Exception {
		GetClassTest gct = new GetClassTest();
		Class gctClass = gct.getClass();
		
		System.out.println("�̸�"+gctClass.getName());
		System.out.println("�޼��� ����"+gctClass.getDeclaredMethods().length);
		
		Class gctClass2 = GetClassTest.class;
		gctClass.getDeclaredMethod("sayHello").invoke(gct);
	}

}
