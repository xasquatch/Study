package ch10.lambda.functional;

import java.util.function.Consumer;

public class ConsumerTest {
	public static void printStudent(Student student, Consumer<Student> printer) {
		printer.accept(student);
	}
	
	public static void main(String[] args) {
		Student student = new Student("ȫ�浿", 80);
		
		printStudent(student, s -> System.out.println(s.name));
		printStudent(student, s -> s.score *=1.5);
		printStudent(student, s -> System.out.println(s.name+"; "+s.score));
	}

}

class Student{
	public String name;
	public double score;
	
	public Student(String name, double score) {
		this.name = name;
		this.score = score;
	}
	
	
}
