package Chapter2;

public class FloatTest {

		public static void main(String[] args) {
			
			//float = 3.14;
			float f2 = 3.14f;
			
			double d1 = 3.14;
			System.out.println(f2 +","+ d1);
			
			double d2 = 3.14e2;
			System.out.println(d2);

			double d3 = 3.14e-2;
			System.out.println(d3);
			
			//출력 결과의 유효숫자 비교
			float f3 = 0.1234567890123456789f;
			double d4 = 0.123456789123456789;
			System.out.println(f3+d4);
			
			
			
		}
}
