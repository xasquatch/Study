package ch04.loop;

import java.awt.DisplayMode;
import java.util.Scanner;

public class ProductManagerClient {

	private final String line = "******************************************";
	String mainMenu =  "현황조회(L)\t상품등록(R)\t상품판매(S)\t종료(X)";
	Scanner sc = new Scanner(System.in);
	
	private void displayMainMenu() {
		do {
			System.out.printf("%s%n%s%n%s%n",line,mainMenu,line);
			String input = sc.nextLine();
			if (input.equalsIgnoreCase("X")) {
				System.out.println("종료");
				return;
				
			}else if(input.equalsIgnoreCase("L")){
				System.out.println("현황조회");
			}else if(input.equalsIgnoreCase("S")){
				System.out.println("상품판매");
			}else if(input.equalsIgnoreCase("R")){
				System.out.println("상품등록");
			}else {
				System.out.println("적절한 메뉴가 아닙니다.");
			}
		} while (true);
		
	}
	
	public static void main(String[] args) {
		ProductManagerClient pr = new ProductManagerClient();
		pr.displayMainMenu();
		
	}

}
