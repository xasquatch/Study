package Chapter13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Phone2 {
	String number;
	Integer price;

	public Phone2(String num, Integer pr) {
		this.number = num;
		this.price = pr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
			System.out.println("�� number:"+number.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
			System.out.println("�� number:"+number.hashCode());
			System.out.println();
			System.out.println("�� price:"+price.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
			System.out.println("�� price:"+price.hashCode());
			System.out.println("-----------------");
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone2 ot = (Phone2) obj;
		if (number == null) {
			if (ot.number != null)
				return false;
		} else if (!number.equals(ot.number))
			return false;
		if (price == null) {
			if (ot.price != null)
				return false;
		} else if (!price.equals(ot.price))
			return false;
		return true;

	}

	@Override
	public String toString() {
		return "SamePhone [number = " + number + ", price = " + price + "]";
	}

}

public class PhoneTest {

	public static void main(String[] args) {
		Set<Phone2> pset = new HashSet();
		pset.add(new Phone2("010", 2000));
		pset.add(new Phone2("010", 2000));
		pset.add(new Phone2("011", 3000));
		pset.add(new Phone2("011", 3000));
		pset.add(new Phone2("011", 1000));
		System.out.println("set�� ũ��"+pset.size());
		Iterator it = pset.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			
		}
	}

}
