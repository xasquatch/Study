package Chapter10;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		String[] str = {"홍길동","유관순","이순신"};
		//이름순으로 정렬
		Arrays.sort(str);
		
		for(String i : str) {
			System.out.println(i);
		}
		System.out.println("---------------------------------------");
		Person [] ps = {new Person("홍길동",90), new Person("유관순",417), new Person("이순신",50)	};

//		class Cmp implements Comparator<Person>{				//case1 start
//
//			@Override
//			public int compare(Person arg0, Person arg1) {
//				int result;
//				if(arg0.age >arg1.age) {
//					result = 1;
//				}else {
//					result = -1;
//				}
//				return result;
//				return 1;
//				return -1;
//				return 0;
//			}
//			
//		}
//		Arrays.sort(ps, new Cmp());								//case2 end
		
		Arrays.sort(ps, (arg0, arg1) -> {
			int result;
			if(arg0.age >arg1.age) {
				result = 1;
			}else {
				result = -1;
			}
			return result;
		
//				return arg0.name.compareTo(arg1.name);
			
			
		});														//case2 end
		
		for(Person p : ps) System.out.println(p);

		
		
	}
	
}