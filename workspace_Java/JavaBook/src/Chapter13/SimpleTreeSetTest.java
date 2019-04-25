package Chapter13;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;

public class SimpleTreeSetTest {

	public static void main(String[] args) {

		TreeSet<Object> set = new TreeSet<>();
		set.addAll(Arrays.asList("W","o","r","l","d"));

		System.out.println("�������� treeset"+set);
		System.out.println("ó��"+set.first());
		System.out.println("������"+set.last());
		System.out.println("o�Ʒ����"+set.lower("o"));
		System.out.println("i�������"+set.higher("i"));
		System.out.println("m�������"+set.floor("m"));
		System.out.println("m�������"+set.ceiling("m"));
		
		NavigableSet<Object> naviset = set.descendingSet();
		System.out.println("Treeset ��������"+ naviset);
		System.out.println(set.descendingSet());
	}

}
