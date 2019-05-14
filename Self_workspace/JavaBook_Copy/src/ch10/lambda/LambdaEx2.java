package ch10.lambda;

@FunctionalInterface
interface FunctionalInterface2{
	void methodB(String msg);
}

public class LambdaEx2 {
	public static void useFIMethod(FunctionalInterface2 fi) {
		fi.methodB("홍길동");
	}
	
	public static void main(String[] args) {
		useFIMethod((String msg)->{
			System.out.println("람다식 이용1: "+msg);
		});
		useFIMethod(msg->System.out.println("람다식 이용2: "+msg ));
		
		
	}

}
