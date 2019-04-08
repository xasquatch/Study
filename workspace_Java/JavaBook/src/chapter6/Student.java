package chapter6;

public class Student {

		 int age;
		 String name;
		 int score1, score2, score3;

		 Student(String n, int a, int s1, int s2, int s3){	//积己磊
//			 System.out.println("切积积己磊 角青");
			 
			name = n;
			age = a;
			score1 = s1;
			score2 = s2;
			score3 = s3;
			 
		 }

		 double getAverage() {
			 int sum = score1 + score2 + score3;
			 //double avg = sum/3.0
			 return sum/3.0;
		 }

		 void print() {
			 System.out.println(age+" "+name);
	}
}