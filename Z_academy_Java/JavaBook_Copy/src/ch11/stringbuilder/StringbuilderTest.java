package ch11.stringbuilder;

class Stringbuilder{

	public Stringbuilder() {
		StringBuilder b = new StringBuilder("Hello");
		System.out.println("버퍼크기"+b.capacity());
		System.out.println("문자열 길이"+b.length());
	}
	
}

class StringbuilderMethodTest{

	public StringbuilderMethodTest() {
		StringBuilder bd = new StringBuilder("사봉-용산-사가정-용마산");
		bd.append("-중곡");
		System.out.println(bd);
		bd.insert(3, "면목-");
		System.out.println(bd);
		bd.delete(5, 8);
		System.out.println(bd);
		bd.replace(0, 1, "상");
		System.out.println(bd);
		System.out.println();
		System.out.println(bd.indexOf("용"));
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
