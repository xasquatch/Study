package Chapter3;

public class ModadicCasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		byte b1 =10;
		b1+= 1;
		System.out.println(b1);
		
		byte b2 = ++b1;
		System.out.println(b2);

		byte b3 = (byte)(b2+1);
		System.out.println(b3);
		
		
		int n = 100;
		String result = (n%2==0)?"Â¦¼ö":"È¦¼ö";
		System.out.println(result);
		
	}

}