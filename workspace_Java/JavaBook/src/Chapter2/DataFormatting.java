package Chapter2;

import java.util.Calendar;

public class DataFormatting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar currentTime = Calendar.getInstance();
		System.out.printf("%tA %<tB %<te, %<tY %n", currentTime);
		System.out.printf("%tD %n", currentTime);
		System.out.printf("%tF %n", currentTime);
		System.out.printf("%tc %n", currentTime);
		System.out.printf("������ %tF�̰� ������ %<tR�Դϴ�. %n", currentTime);
		
	}

}
