package Chapter7;

public class Test0402 {

	public static void main(String[] args) {
		Person [] ps = new Person[3];
		
		ps[0] = new Person("홍길동",10);
		ps[1] = new Person("이순신",40);
		ps[2] = new Person("유관순",20);
		
		for(Person pssys : ps)
			System.out.println(pssys.name+" "+pssys.age);
		
	}

}


