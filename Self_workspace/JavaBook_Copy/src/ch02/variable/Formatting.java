package ch02.variable;

public class Formatting {

	public static void main(String[] args) {

		boolean b1 = true;
		int i1 = 65;
		double d1 = 3.141592;
		System.out.printf("b1:%b, i1:%d(%c), d1: %f%n",b1,i1,i1,d1);
		
		System.out.printf("[%4d], [%-4d], [%04d]%n",i1,i1,i1);
		
		System.out.printf("[%019.3f],[%12.8f]%n",d1,d1);
		
	}

}
