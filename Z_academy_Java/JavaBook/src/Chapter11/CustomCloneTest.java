package Chapter11;

import java.util.Arrays;

	class Person implements Cloneable{
		String name;
		int age;
		int[] score;
	
	
		public Person(String name, int age, int[] score) {
			this.name = name;
			this.age = age;
			this.score = score;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[name="+name+", age="+age+",score="+Arrays.toString(score)+"]";
		}
		

		@Override
		public Object clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			return super.clone();
		}

}
public class CustomCloneTest{
	public static void main(String[] args) throws CloneNotSupportedException {

		Person original = new Person("ȫ", 20, new int[] {100,90});
//		System.out.println(original);
//		Object cloned = original.clone();
//		System.out.println(cloned);
//		System.out.println(System.identityHashCode(original)+":"+System.identityHashCode(cloned));
//-----------------------------------------------------------------------
		System.out.println(original);
		Object cloned = original.clone();
		System.out.println(cloned);
		original.score[0] = 70;
		System.out.println(cloned);
	
	}
}