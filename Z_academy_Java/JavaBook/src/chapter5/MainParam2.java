package chapter5;

public class MainParam2 {

	public static void main(String[] args) {
		
		int num = args.length >0 ? Integer.parseInt(args[0]):5;
		int sum = 0;
		for (int i=1; i<=100; i++) {
			if(i%num==0) {
				sum += i;
			}
			
			
		}
		System.out.println("1~100까지 "+ num + "의 배수의 합은 " + sum);
	}

}
