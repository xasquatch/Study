package Chapter3;

public class logical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a= 10;
		int b= 20;
		System.out.println((a+=10)>15|(b-=10)>15);
		System.out.println("a = "+a+",b="+b);
		
		a = 10;
		b = 20;
		System.out.println((a+=10)>15||(b-=10)>15);
		System.out.println("a = "+a+",b="+b);
		
	}

}
