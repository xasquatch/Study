
public class Ex3 {

	public static void main(String[] args) {
		int x = 1;
		int y = 2;
		int z = 3;
		
		System.out.println("X : " + x + ", Y : " + y + ", Z : " + z);
		
		x = y; // 기본 데이터의 대입연산은 변수에 저장된 실제 데이터(리터럴)의 복사 일어남
		System.out.println("X : " + x + ", Y : " + y + ", Z : " + z);
		
		
		int[] a = {1, 2, 3};
		int[] b = {4, 5, 6};
		int[] c = {7, 8, 9};
		
		System.out.println("A 배열 : " + a[0] + ", " + a[1] + ", " + a[2]);
		System.out.println("B 배열 : " + b[0] + ", " + b[1] + ", " + b[2]);
		System.out.println("C 배열 : " + c[0] + ", " + c[1] + ", " + c[2]);
		System.out.println("---------");
		a = b;
		// 참조변수 b에 저장된 4, 5, 6 데이터의 배열 주소값을 a에 복사
		// => 즉, 참조변수 a도 b와 똑같이 4, 5, 6 데이터의 배열을 가리키게 된다!
		// => 이 때, a가 원래 가리키고 있던 1, 2, 3 배열은 더 이상 참조되지 않으므로
		//    가비지 컬렉터(Garbage Collector) 에 의해 자동으로 제거됨
		
		System.out.println("A 배열 : " + a[0] + ", " + a[1] + ", " + a[2]);
		System.out.println("B 배열 : " + b[0] + ", " + b[1] + ", " + b[2]);
		System.out.println("C 배열 : " + c[0] + ", " + c[1] + ", " + c[2]);
		System.out.println("---------");
		b = c;
		// 참조변수 c에 저장된 7, 8, 9 데이터의 배열 주소값을 b에 복사
		// => 즉, 참조변수 b도 c와 똑같이 7, 8, 9 데이터의 배열을 가리키게 된다!
		// => 이 때, 여전히 4, 5, 6 배열은 참조변수 a 가 참조하므로
		//    가비지 컬렉터에 의한 제거 대상이 아니다!
		
		System.out.println("A 배열 : " + a[0] + ", " + a[1] + ", " + a[2]);
		System.out.println("B 배열 : " + b[0] + ", " + b[1] + ", " + b[2]);
		System.out.println("C 배열 : " + c[0] + ", " + c[1] + ", " + c[2]);
	}

}
