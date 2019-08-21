package ch05.multi;

public class VariableLegnthArray {

	public static void main(String[] args) {
		int[][] arr2 = new int[4][];
		arr2[0] = new int[] {1,2,4,5};
		arr2[1] = new int[] {10,20,30,40,50};
		arr2[2] = new int[] {20,20,20};
		arr2[3] = new int[] {30,30,30,30,30};
		
		int sum = 0;
		int count = 0;
		
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				sum += arr2[i][j];
				count++;
			}
		}
		System.out.println(sum+" "+(sum*1.0/count));
	}
}
