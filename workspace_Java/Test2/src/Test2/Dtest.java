package Test2;

public class Dtest {

	public static void main(String[] args) {
		
		int i = 0;
		while(true) {
			if(Math.pow(i,2)>1000) {
				break;
			}
			i++;
		}
		i--;
		System.out.println(i);
	}

	
}
