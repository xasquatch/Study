package ch08.enume;

enum Grade{
	SALES, PART_TIME_JOB, NORMAL
}


public class GradEnumTest {

	public static void main(String[] args) {
		Grade gd = Grade.SALES;
		System.out.println(Grade.SALES);
		System.out.println(gd);
		System.out.println(gd instanceof Enum);
		System.out.println(gd instanceof Object);


		
		
	}

}