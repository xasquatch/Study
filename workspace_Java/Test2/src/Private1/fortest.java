package Private1;

public class fortest {

	public static void main(String[] args) {

		
		int sum = 0;
		for(int i = 1; i<=20; i++) {
			sum += i;			
			double avg = sum / i;
			System.out.println("sum = "+sum+" avg = "+(int)avg);
			System.out.println("순서: "+i+" 누계 :"+sum);
		}
		
		
		
		System.out.println("프로그램 끝");
	}

}
