package ch10.lambda;

@FunctionalInterface
interface FunctionalInterface1{
	void methodA();
}

public class LambdaEx1 {
	public static void useFIMethod(FunctionalInterface1 fi) {
		fi.methodA();
	}
	
	public static void main(String[] args) {
		useFIMethod(new FunctionalInterface1() {
			
			@Override
			public void methodA() {
				System.out.println("익명의 내부 클래스 형태");
				
			}
		});
		
		useFIMethod(() ->{
			System.out.println("람다식이용1");
		});
		
		useFIMethod(()->System.out.println("람다식 이용2"));
		
	}

}
