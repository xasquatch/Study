package Chapter3;

public class CompareOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	String s1 = new String("Hello");	// 할당방식 : 변수에 주소값 할당
	String s2 = new String("Hello");	//		할당된 주소번지마다 값을 할당
	
	String s3 = "Hello";	// 할당방식 : 리터럴테이블 참조방식,	중복된 값이면 그 주소값에 같이 할당
	String s4 = "Hello";	//		리터럴 테이블 : 중복된 값을 허용하지 않음
	
	System.out.println((s3==s4)+":"+(s3 == s4));

	

System.out.println("--------------------------------------------------------");

System.out.println('A'>'B');	//65>66
	//비교연산에서의 형변환
	//int 이하의 연선 - 일단 int로 변경 : 65==100
System.out.println('A'==65);
	//두 피연산자 중 큰 타입으로 형변환 :3.0 == 3.0
System.out.println(3 == 3.0);

	//주의 사항 : 0.1의 표현 문제
System.out.println(0.1+":"+0.1f+":"+(0.1==0.1f));
System.out.println(0.5+":"+0.5f+":"+(0.5==0.5f));
	double d1 = 0.1;
	float f1 = 0.1f;
System.out.println((int)(d1*10)==(int)(f1*10));
System.out.println((float)d1==f1);

	//문자열에서의 ==과 equals

System.out.println((s1 == s2)+":"+s1.equals(s2));
		
		
		
		
		
	}

}
