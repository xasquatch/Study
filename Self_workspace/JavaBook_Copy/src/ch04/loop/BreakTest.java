package ch04.loop;

public class BreakTest {

	public static void main(String[] args) {
		System.out.println("2������ ����� 1000���� ���� ���� ū ����");
		
		int i = 1;
		while(true){
			i++;
			if(Math.pow(i, 2) >= 1000) {
				System.out.println(--i);
				break;
			}
			
		}
		System.out.println(i);
	}
}
