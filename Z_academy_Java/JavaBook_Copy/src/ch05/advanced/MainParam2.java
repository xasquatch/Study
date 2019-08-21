package ch05.advanced;

public class MainParam2 {

	public static void main(String[] args) {
		
		int num = args.length >0 ?Integer.parseInt(args[0]) :5;
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			if (i % num == 0) {
				sum += i;
			}
		}
		System.out.println(num+"  "+sum);
	}
}
