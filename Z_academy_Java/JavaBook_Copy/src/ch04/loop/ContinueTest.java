package ch04.loop;

public class ContinueTest {

	public static void main(String[] args) {

		System.out.println("1~1000���� ���� �� 3�� ����� ����?");
		int i = 0;
		int result = 0;
		while(i<=1000){
			if(i%3==0) {
				result += i;
			}
			i++;
		}
		System.out.println(result);
	}

}
