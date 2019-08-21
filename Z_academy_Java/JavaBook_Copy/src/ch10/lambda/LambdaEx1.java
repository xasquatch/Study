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
				System.out.println("�͸��� ���� Ŭ���� ����");
				
			}
		});
		
		useFIMethod(() ->{
			System.out.println("���ٽ��̿�1");
		});
		
		useFIMethod(()->System.out.println("���ٽ� �̿�2"));
		
	}

}
