package ch03.logical;

public class ShortCircuit {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		System.out.println((a+=10)>15|(b-=10)>15);
		System.out.println("a= "+a+",b="+b);
		
		a = 10;
		b = 20;
		System.out.println((a+=10)>15||(b-=10)>15);
		System.out.println("a= "+a+",b="+b);
		
		
	}

}
