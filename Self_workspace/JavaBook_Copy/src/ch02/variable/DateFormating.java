package ch02.variable;

import java.util.Calendar;

public class DateFormating {

	public static void main(String[] args) {

		Calendar Time = Calendar.getInstance();
		System.out.printf("%tA %<tB %<te, %<tY %n", Time);
		System.out.printf("%td %n", Time);
		System.out.printf("%tF %n",Time);
		System.out.printf("%tc %n",Time);
		System.out.printf("������ %tF�̰� ������ %<tR�Դϴ�. ", Time);
		
	}

}
