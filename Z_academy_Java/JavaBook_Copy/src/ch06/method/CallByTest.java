package ch06.method;

public class CallByTest {
	int memberVar = 10;
	
	static void change1(int var) {
		var += 10;
		System.out.println(var);
		
	}
	
	static void change2(CallByTest a) {
		a.memberVar +=100;
		System.out.println(a.memberVar);
	}
	
	public static void main(String[] args) {
		CallByTest t = new CallByTest();
		t.memberVar = 5;
		System.out.println("»£√‚¿¸"+t.memberVar);
		
		change1(t.memberVar);
		System.out.println(t.memberVar);
		
		change2(t);
		System.out.println(t.memberVar);
		
		
	}
}
