package ch10.lambda;

@FunctionalInterface
interface FunctionaInterface3{
	String methodB(String msg);
}

public class LambdaEx3 {
	public static void useFIMethod(FunctionaInterface3 fi) {
		System.out.println(fi.methodB("홍길동"));
	}
	
	public static void main(String[] args) {
		useFIMethod((String msg)->{
			return "람다식 이용 1:"+msg;
		});
		useFIMethod(msg->"람다식이용2"+msg);
	}

}
