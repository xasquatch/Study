package Chapter13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

	List<Object> list = new ArrayList<>();
	List<Integer> integers = Arrays.asList(1,2,3,4,5);
	
	
	
	public void createTest() {
		list.add("Hello");
		list.add("Hello");
		list.add(null);
		list.addAll(integers);
		list.add(integers);
		list.add(0, new Object());
		System.out.println("추가후 내용 출력"+list);
		
	}
	
	private void deleteTest() {
		
		Iterator it = list.iterator();
		while (it.hasNext()) {
			if (it.next() instanceof Integer) {
				it.remove();
			}
			
		}
		System.out.println("삭제후"+list);
		list.clear();
		System.out.println("초기화후"+list);
		
//		list.remove(0);
//		list.remove("Hello");
//			for (int i = 0; i < list.size(); i++) {
//				if (list.get(i) instanceof Integer) {
//					list.remove(i);
//				}
//			}
//		System.out.println("삭제 후"+list);
//		list.clear();
//		System.out.println("초기화 후"+list);
	}

	private void updateTest() {
		list.set(1, "updated");
		System.out.println("업데이트 후 : "+list);
		
	}

	private void retrieveTest() {


		for (int i = 0; i < list.size(); i++) {
			System.out.println(i+":"+list.get(i));
		}
		if (list.contains("Hello")) {
			System.out.println("Hello의 위치는 "+list.indexOf("Hello") );
		}
		List<Object> sub = list.subList(3, 5);
		System.out.println("sub의 내용"+sub);
		System.out.println("sub의 내용을 다 가지고 있는가?" + list.containsAll(sub));
		
	}
	public static void main(String[] args) {
		ArrayListTest alt = new ArrayListTest();
		alt.createTest();
		alt.retrieveTest();
		alt.updateTest();
		alt.deleteTest();
	}

	

}
