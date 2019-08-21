package chapter6;

public class VariableTypes {

	int instanceVariable;
	static int classVariable;
	
	public static void main(String[] args) {
		int localVariable = 10;
		for( int i = 0; i<100; i++) {
			System.out.println(i);
		}
		System.out.println(localVariable);
//		System.out.println(instanceVariable);
		System.out.println(classVariable);
	}

}
