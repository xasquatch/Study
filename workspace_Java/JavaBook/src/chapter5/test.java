package chapter5;

public class test {

	public static void main(String[] args) {
		int [] a = {100,200,300,400};
		
		int [] copy = new int[4];
			for(int i = 0; i < a.length; i++) {
				copy [i] = a[i];
				System.out.println(copy[i]);
			}
			
		
		
	}

}
