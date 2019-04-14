package ch04.loop;

import java.awt.DisplayMode;
import java.util.Scanner;

public class ProductManagerClient {

	private final String line = "******************************************";
	String mainMenu =  "��Ȳ��ȸ(L)\t��ǰ���(R)\t��ǰ�Ǹ�(S)\t����(X)";
	Scanner sc = new Scanner(System.in);
	
	private void displayMainMenu() {
		do {
			System.out.printf("%s%n%s%n%s%n",line,mainMenu,line);
			String input = sc.nextLine();
			if (input.equalsIgnoreCase("X")) {
				System.out.println("����");
				return;
				
			}else if(input.equalsIgnoreCase("L")){
				System.out.println("��Ȳ��ȸ");
			}else if(input.equalsIgnoreCase("S")){
				System.out.println("��ǰ�Ǹ�");
			}else if(input.equalsIgnoreCase("R")){
				System.out.println("��ǰ���");
			}else {
				System.out.println("������ �޴��� �ƴմϴ�.");
			}
		} while (true);
		
	}
	
	public static void main(String[] args) {
		ProductManagerClient pr = new ProductManagerClient();
		pr.displayMainMenu();
		
	}

}
