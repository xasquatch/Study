package Chapter3;

public class BitMast {

	public static void main(String[] args) {

		int homeElecStatus = 0;
		int tvCheck = 0b1;
		String result = "";
		result = (homeElecStatus & tvCheck) > 0 ?"ÄÑÁü":"²¨Áü";
		System.out.println("tv»óÅÂ : " + result);
		
		//tvÄÑ±â
		homeElecStatus |= tvCheck;
		result = (homeElecStatus & tvCheck) > 0 ?"ÄÑÁü":"²¨Áü";
		System.out.println("tv»óÅÂ(ÄÑ±â) : " + result);
		
		//tv»óÅÂ¹İÀü
		homeElecStatus ^= tvCheck;
		result = (homeElecStatus & tvCheck) > 0 ?"ÄÑÁü":"²¨Áü";
		System.out.println("tv»óÅÂ(¹İÀü) : " + result);
		
		//tv»óÅÂ¹İÀü
		homeElecStatus &= ~tvCheck;
		result = (homeElecStatus & tvCheck) > 0 ?"ÄÑÁü":"²¨Áü";
		System.out.println("tv»óÅÂ(²ô±â) : " + result);
		

	}

}
