package Chapter7;

public class Test0402 {

	public static void main(String[] args) {
		Person [] ps = new Person[3];
		
		ps[0] = new Person("ȫ�浿",10);
		ps[1] = new Person("�̼���",40);
		ps[2] = new Person("������",20);
		
		for(Person pssys : ps)
			System.out.println(pssys.name+" "+pssys.age);
		
	}

}

