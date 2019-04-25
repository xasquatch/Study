package Chapter13;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;

public class SimpleTreeSetTest {

	public static void main(String[] args) {

		TreeSet<Object> set = new TreeSet<>();
		set.addAll(Arrays.asList("W","o","r","l","d"));

		System.out.println("오름차순 treeset"+set);
		System.out.println("처음"+set.first());
		System.out.println("마지막"+set.last());
		System.out.println("o아래요소"+set.lower("o"));
		System.out.println("i다음요소"+set.higher("i"));
		System.out.println("m이전요소"+set.floor("m"));
		System.out.println("m다음요소"+set.ceiling("m"));
		
		NavigableSet<Object> naviset = set.descendingSet();
		System.out.println("Treeset 내림차순"+ naviset);
		System.out.println(set.descendingSet());
	}

}
