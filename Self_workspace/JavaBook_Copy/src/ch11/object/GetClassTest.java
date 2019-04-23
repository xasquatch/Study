package ch11.object;

public class GetClassTest {

	public void sayHello(){
		System.out.println("Hello");
	}
	public static void main(String[] args) throws Exception {
		GetClassTest gct = new GetClassTest();
		Class gctClass = gct.getClass();
		
		System.out.println("이름"+gctClass.getName());
		System.out.println("메서드 개수"+gctClass.getDeclaredMethods().length);
		
		Class gctClass2 = GetClassTest.class;
		gctClass.getDeclaredMethod("sayHello").invoke(gct);
	}

}
