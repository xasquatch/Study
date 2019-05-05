package ch08.enume;

enum Season{
	SPRING, SUMMER, FALL, WINTER
}

public class seasonEnumTest {

	public void compareEnum(Season season) {
		if (season.equals(season.SPRING)) {
			System.out.println("��");
		} else if (season.compareTo(season.WINTER)<0) {
			System.out.println("�ܿ����ƴ�");
		} else {
			System.out.println(season.compareTo(season.WINTER));
		}

	}
	
	public void enumSwitch(Season season) {
		switch (season) {
		case SPRING:
			System.out.println("��");
			break;
		case SUMMER:
			System.out.println("����");
			break;
		case FALL:
			System.out.println("����");
			break;
		case WINTER:
			System.out.println("�ܿ�");
			break;
			}
	}
	
	public static void main(String[] args) {
		seasonEnumTest ss = new seasonEnumTest();
		ss.compareEnum(Season.WINTER);
		System.out.println("---------------------");
		ss.enumSwitch(Season.SPRING);
		
	}

}
