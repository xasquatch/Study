package Array;

public class arraytest1 {

	public static void main(String[] args) {
		
		int intArray[] = new int[5];
		
		for(int i = 0; i < 5; i++) {
			intArray[i] = (i+1)*10;
			
			System.out.println("intArray["+ i +"] = "+ intArray[i]);
			
		}

	}

}
