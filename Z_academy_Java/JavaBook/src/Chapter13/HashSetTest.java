package Chapter13;

import java.util.HashSet;
import java.util.Set;

class Phone {
	String number;

	public Phone(String number) {
		this.number = number;
	}

	public String toString() {
		return "��ȭ��ȣ : " + number;
	}

}

public class HashSetTest {

	Set<Object> hset = new HashSet<Object>();

	private void addMethod() {

		hset.add(Integer.valueOf(1));
		hset.add("Hello");
		hset.add("Hello");
		hset.add(null);
		hset.add(1);
		hset.add(new Phone("010-1234-1234"));
		hset.add(new Phone("010-1234-1234"));
		System.out.println("���" + hset);
	}

	private void retrieveMethod() {
		System.out.println("����" + hset.size());

		for (Object object : hset) {
			System.out.println("��������ȸ" + object);
		}
	}

	private void removeMethod() {
		hset.remove("Hello");
		System.out.println("�������" + hset);
	}

	public static void main(String[] args) {
		HashSetTest hst = new HashSetTest();
		hst.addMethod();
		System.out.println();
		hst.retrieveMethod();
		System.out.println();
		hst.removeMethod();
	}

}