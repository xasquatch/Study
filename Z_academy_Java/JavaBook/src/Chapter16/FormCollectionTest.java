package Chapter16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FormCollectionTest {

	public static void main(String[] args) {

		String[] heroes = {"���̾��","�����̴���","��ũ","�丣"};
		Stream<String> fromArray = Arrays.stream(heroes);
		
		List<String> heroList = Arrays.asList(heroes);
		Stream<String> fromList = heroList.stream();
		fromList.forEach(a -> System.out.println("["+a+"],"));
	
	}

}