package chapter6;

public class StudentTest {

	public static void main(String[] args) {
		Student st = new Student("ȫ�浿",20,100,90,80); //��ü����

//		st.name = "ȫ�浿";
//		st.age = 20;
//		st.score1 = 100;
//		st.score2 = 90;
//		st.score3 = 80;
		st.print();

		double av = st.getAverage();
		System.out.println(av);

		Student st1 = new Student("�̼���",40,100,90,80);

//		st1.name = "�̼���";
//		st1.age = 40;
		st1.print();
	}
}