package ch07.poly;
class UserInfo{
	String name = "Çã";
}

class MemberInfo extends UserInfo{
	String grade = "Á¤";
}

class Super{
	String x = "super";
	public void method() {
		System.out.println("super");
	}
}

class Sub extends Super{
	String x = "sub";
	
	public void method() {
		System.out.println("sub");
	}
}
public class PrintObject {


	public static void main(String[] args) {
		//SUPER SUB TEST
		Sub subc = new Sub();
		System.out.println(subc.x);
		subc.method();
		System.out.println("============================");
		Super supc = subc;
		System.out.println(supc.x);
		supc.method();
		System.out.println("============================");
		Object member = new MemberInfo();
		System.out.println(member);

		a.name();
		a a = new a();
		a.name();
		a.name1();
	}

}

class a{
	
	public static void name() {
		System.out.println("start");
	}

	public void name1() {
		System.out.println("start1");
		
	}
}