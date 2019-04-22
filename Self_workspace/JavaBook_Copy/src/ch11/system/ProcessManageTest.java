package ch11.system;

import java.util.Scanner;

class Dummy {

	public Dummy() {
		System.out.println("dummy 按眉 积己");
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("dummy 按眉 家戈");
	}

}

public class ProcessManageTest {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)){
			while(true) {
				System.out.println("疙飞 涝仿CGX");
				String readline = sc.nextLine();
				if (readline.equals("C")) {
					new Dummy();
				}else if (readline.equals("G")) {
					System.gc();
				}else if (readline.equals("X")) {
					System.exit(0);
				}
					
			}
			
		}
	}

}
