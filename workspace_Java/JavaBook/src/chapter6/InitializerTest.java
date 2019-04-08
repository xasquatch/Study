package chapter6;

public class InitializerTest {

	int iv;
	static int cv;
	
	static {
		System.out.println("static initializer");
		cv = 100;
	}
	{
		System.out.println("instance initializer");
		iv = 100;
	}
	public InitializerTest(){
		System.out.printf("constructor ic : %d, cv: %d%n", iv, cv);
		this.iv = 300;
	}	
	
	
	public static void main(String[] args) {
		System.out.println("main�޼����");
		InitializerTest it = new InitializerTest();
		System.out.printf("��ü 1 ���� �� - cv : %d iv : %d%n",InitializerTest.cv,it.iv);
		InitializerTest it2 = new InitializerTest(); 
		System.out.printf("��ü 2 ���� �� - cv : %d iv : %d%n",InitializerTest.cv,it2.iv);
	}

}
