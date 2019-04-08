package chapter6;

public class MyExp {

	int base;
	int exp;
	
	int getValue(){
		
		int value = 1;
		for(int i =1; i<exp; i++) {
			value *= base;
		}
		return value;
	}
	
	public static void main(String[] args) {
		MyExp data = new MyExp();
		
		data.base = 2;
		data.exp = 3;
		
		System.out.println(data.getValue());
		
	}
}
