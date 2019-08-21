package ch03.operator;

public class IntegerProblem {

	public static int addNormal(int base, int addThis) {
		return base + addThis;
	}
	
	public static int addSafety(int base, int addThis) {
		System.out.println(Integer.MAX_VALUE);
		if((Integer.MAX_VALUE - addThis)>base) {
			return base + addThis;
		}else {
			throw new ArithmeticException("�����÷ο�߻�");
		}
	}
	
	public static void main(String[] args) {
		int result = addNormal(Integer.MAX_VALUE,1);
		System.out.println("������� : "+result);

		try {
			result = addSafety(100,100);
			System.out.println("������� 1 : "+result);
			result = addSafety(Integer.MAX_VALUE,100);
			System.out.println("������� 2 : "+result);
			
		}catch(ArithmeticException e){
			System.out.println(e.getMessage());
		}
	}

}
