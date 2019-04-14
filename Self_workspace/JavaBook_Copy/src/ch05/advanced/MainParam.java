package ch05.advanced;

public class MainParam {

	public static void main(String[] args) {

		int sum = 0;
		for (String arg : args) {
			int num = Integer.parseInt(arg);
			sum += num;
		}
		System.out.println(args.length+"  "+sum);
	}

}
