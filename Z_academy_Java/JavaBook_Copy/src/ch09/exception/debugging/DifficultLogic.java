package ch09.exception.debugging;

public class DifficultLogic {
	
	public DifficultLogic() {}

	public long factorial(int num) {
		if(num == 1) {
			return 1;
		}else {
			return num * factorial(num-1);
		}
	}
	
	public static void main(String[] args) {
		// not difficult.
		DifficultLogic dit = new DifficultLogic();
		System.out.println(dit.factorial(5));

	}

}
