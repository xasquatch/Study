package chapter5;

public class Param {

	public static void main(String[] args) {
	
		int sum = 0;
		for (String arg:args) {
			int num = Integer.parseInt(arg);
			sum = sum+num;
		}
		System.out.printf("�迭�� ���� : %d,����� ���� : %d", args.length, sum);
	}

}
