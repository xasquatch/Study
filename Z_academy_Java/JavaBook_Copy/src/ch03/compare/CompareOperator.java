package ch03.compare;

public class CompareOperator {

	public static void main(String[] args) {
		System.out.println('A' >'B');
		System.out.println('A' == 65);
		System.out.println(3==3.0);
		
		System.out.println(0.1+":"+0.1f+":"+(0.1 == 0.1f));
		System.out.println(0.5+":"+0.5f+":"+(0.5 == 0.5f));
		double d1 = 0.1;
		float f1 = 0.1f;
		System.out.println((int)(d1*10) == (int)(f1*10));
		System.out.println((float)d1 ==f1);
		
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		
		System.out.println((s1 == s2)+":"+s1.equals(s2));
	}

}
