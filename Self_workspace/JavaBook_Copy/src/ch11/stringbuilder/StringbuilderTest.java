package ch11.stringbuilder;

class Stringbuilder{

	public Stringbuilder() {
		StringBuilder b = new StringBuilder("Hello");
		System.out.println("����ũ��"+b.capacity());
		System.out.println("���ڿ� ����"+b.length());
	}
	
}

class StringbuilderMethodTest{

	public StringbuilderMethodTest() {
		StringBuilder bd = new StringBuilder("���-���-�簡��-�븶��");
		bd.append("-�߰�");
		System.out.println(bd);
		bd.insert(3, "���-");
		System.out.println(bd);
		bd.delete(5, 8);
		System.out.println(bd);
		bd.replace(0, 1, "��");
		System.out.println(bd);
		System.out.println();
		System.out.println(bd.indexOf("��"));
		System.out.println(bd.reverse());
		
	}
	
}

public class StringbuilderTest {

	public static void main(String[] args) {
		Stringbuilder test1 = new Stringbuilder();
		System.out.println();
		StringbuilderMethodTest test2 = new StringbuilderMethodTest();
		System.out.println();
		
		
	}

}
