package ch10.lambda;

@FunctionalInterface
interface FunctionaInterface3{
	String methodB(String msg);
}

public class LambdaEx3 {
	public static void useFIMethod(FunctionaInterface3 fi) {
		System.out.println(fi.methodB("ȫ�浿"));
	}
	
	public static void main(String[] args) {
		useFIMethod((String msg)->{
			return "���ٽ� �̿� 1:"+msg;
		});
		useFIMethod(msg->"���ٽ��̿�2"+msg);
	}

}
