package Chapter2;

public class IntegerProblem {

	public static int addNormal(int base, int addThis) {
		return base + addThis;
		
	}

	public static int addSafety(int base, int addThis) {
	
		if((Integer.MAX_VALUE - addThis) > base) {
			return base + addThis;
		}else {
			throw new ArithmeticException("¿À¹öÇÃ·Î¿ì ¹ß»ý");
		}
	}
	
	public static void main(String[] args) {
		int result = addNormal(Integer.MAX_VALUE,1);
		System.out.println("ÀÏ¹Ý µ¡¼À °á°ú: " + result);
		
			try {
			
				result = addSafety(100, 100);
				System.out.println("¾ÈÀüÇÑ µ¡¼À °á°ú 1:"+result);
		
				result = addSafety(Integer.MAX_VALUE, 100);
				System.out.println("¾ÈÀüÇÑ µ¡¼À °á°ú 2:"+result);
			
			} catch (ArithmeticException e) {
				System.out.println(e.getMessage());
			}
	}
		
}
