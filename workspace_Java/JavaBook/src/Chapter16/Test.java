package Chapter16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		List<String> heroes = Arrays.asList("���̾��","�����̴���","��ũ","�丣");
		List<String> sub = new ArrayList<>();
		for (String hero : heroes) {
			if (hero.length()>3) {
				sub.add(hero);
			}
		}
		for (String hero : sub) {
			System.out.println(hero);
		}
	}

}