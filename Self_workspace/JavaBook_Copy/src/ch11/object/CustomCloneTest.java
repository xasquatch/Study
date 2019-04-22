package ch11.object;

import java.util.Arrays;

class Person implements Cloneable {
	String name;
	int age;
	int[] score;

	public Person(String name, int age, int[] score) {
		this.name = name;
		this.age = age;
		this.score = score;

	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
//		Person cloned2 = (Person)super.clone();
//		cloned2.score = this.score.clone();
//		cloned2.name = this.name;
//		cloned2.age = this.age;
//		return cloned2;
	}

	
	
	@Override
	public String toString() {
		return "[name=" + name + ", age = " + age + ", score = " + Arrays.toString(score) + "]";

	}

}

public class CustomCloneTest {

	public static void main(String[] args)throws CloneNotSupportedException {

		Person ps = new Person("홍길", 20, new int[] { 100, 90 });
//		System.out.printf("원본%s%n",ps);
//		Object cloned = ps.clone();
//		System.out.printf("복제%s\t",cloned);
//		System.out.println(System.identityHashCode(ps)+":"+System.identityHashCode(cloned));
		
		System.out.printf("원본%s%n",ps);
		Object cloned = ps.clone();
		System.out.printf("복제%s\n",cloned);
		ps.score[0] = 80;
		ps.age = 80;
		ps.name = "제길";
		System.out.printf("원본%s%n",ps);
		System.out.printf("복제%s\t",cloned);
		System.out.println(System.identityHashCode(ps)+":"+System.identityHashCode(cloned));
	}

}
