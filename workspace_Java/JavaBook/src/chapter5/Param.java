package chapter5;

public class Param {

	public static void main(String[] args) {
	
		int sum = 0;
		for (String arg:args) {
			int num = Integer.parseInt(arg);
			sum = sum+num;
		}
		System.out.printf("배열의 길이 : %d,요소의 총합 : %d", args.length, sum);
	}

}
