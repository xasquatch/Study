package ch10.lambda;

@FunctionalInterface
interface FunctionalInterface2{
	void methodB(String msg);
}

public class LambdaEx2 {
	public static void useFIMethod(FunctionalInterface2 fi) {
		fi.methodB("ȫ�浿");
	}
	
	public static void main(String[] args) {
		useFIMethod((String msg)->{
			System.out.println("���ٽ� �̿�1: "+msg);
		});
		useFIMethod(msg->System.out.println("���ٽ� �̿�2: "+msg ));
		
		
	}

}
