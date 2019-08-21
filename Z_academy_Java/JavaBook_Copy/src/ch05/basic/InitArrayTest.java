package ch05.basic;

public class InitArrayTest {

	public static void main(String[] args) {

		String [] strs1 = new String[3];
		strs1[0] = "Hello";	
		strs1[1] = "Java";	
		strs1[2] = "World";	

		String [] strs2 = {"Hello","Java","World"};
		
		if (args.length == 0) {
			args = new String[] {"Hello","Java","World"};
		}
		
		int [] sr = new int[]{1,2,3,4,5,6,7,0,0};
		
		for (int i : sr) {
			System.out.println(i);
		}
		
		
		for (int i = 0; i < strs1.length; i++) {
			System.out.println(strs1[i]+" "+strs2[i]+" "+args[i]);
		}

	}
}
