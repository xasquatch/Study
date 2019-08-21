package ch05.basic;

public class SimpleArray {

	public static void main(String[] args) {

		int [] points = new int[3];
		System.out.printf("배열크기 : %d%n",points.length);
		
		points[0] = 1;
		points[1] = 'A';
//		points[2] = 1.5;
		
		System.out.println(points[0]);
		System.out.println(points[1]);
		System.out.println(points[2]);
		
	}

}
