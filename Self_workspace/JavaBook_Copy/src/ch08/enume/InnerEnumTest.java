package ch08.enume;

public class InnerEnumTest {

	enum MyEnum{
		DATE, BIRTH_DATE
	}
	
	public static void main(String[] args) {
		System.out.println(MyEnum.DATE);
		OuterClass oc = new OuterClass();
		oc.useInnerEnum();
		InnerEnumTest iet = new InnerEnumTest();
		InnerClass ic = iet.new InnerClass();
		ic.InnerEnum();
	}

	class InnerClass{
		public void InnerEnum() {
			System.out.println(InnerEnumTest.MyEnum.BIRTH_DATE);
		}
	}
	
}

class OuterClass{
	public void useInnerEnum() {
		System.out.println(InnerEnumTest.MyEnum.BIRTH_DATE);
	}
}