package chapter5;

public class SimpleArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] points = new int[3];
		System.out.printf("�迭�� ũ�� : %d%n",points.length);

		points[0] = 1;
		points[1] = 'A';
//		points[2] = 1.5;
			
		System.out.printf("0 ��° ���: %d%n",points[0]);
		System.out.printf("1 ��° ���: %d%n",points[1]);
		System.out.printf("2 ��° ���: %d%n",points[2]);
	}

}
