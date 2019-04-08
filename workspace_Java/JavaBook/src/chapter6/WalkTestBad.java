package chapter6;

public class WalkTestBad {

		int memberVar = 10;
		
		static void change1(int var) {
			var += 10;
			System.out.printf("change1 : %d%n",var);
		}
		static void change2(WalkTestBad cbtl) {
			cbtl.memberVar += 100;
			System.out.printf("change2 : %d%n", cbtl.memberVar);
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WalkTestBad cbt = new WalkTestBad();
		cbt.memberVar = 5;
		System.out.printf("change1 호출 전 memberVar : %d%n",cbt.memberVar);
		
		change1(cbt.memberVar);
		System.out.printf("change1 호출 후 memberVar : %d%n",cbt.memberVar);
		
		change2(cbt);
		System.out.printf("change2 호출 후 memberVar : %d%n",cbt.memberVar);
		
	}
}
