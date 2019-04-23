package Chapter13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

class Listlotto{
	Integer bonus;
	List<Integer> lotto  = new ArrayList<>();
	
	public void setup() {
		Random rd = new Random();
		while (bonus == null) {
			int num = rd.nextInt(45)+1;
			if (!lotto.contains(num)) {
				if (lotto.size() <6) {
					lotto.add(num);
				}else {
					bonus = num;
				}
			}
		}
	
	}
}
public class ListLottoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
