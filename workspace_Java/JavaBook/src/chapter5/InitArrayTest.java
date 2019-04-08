package chapter5;

public class InitArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String [] strs1 = new String [3];
		strs1[0] = "Hello";
		strs1[1] = "Java";
		strs1[2] = "World";

		String [] strs2= {"Hello","Java","World"};
		
		if(args.length == 0) {
			args = new String[] {"Hello","Java","World"};
		}
		
		for(int i = 0; i < strs1.length; i++) {
			System.out.printf("strs1 : %s, strs2 : %s, args : %s %n",strs1[i], strs2[i],args[i]);
		}
	}

}
