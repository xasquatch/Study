package ch07.poly;
class Phone{
	public String number;
	public Phone aboutMe() {
		return this;
	}
}
class HandPhone extends Phone{
	public int weight = 100;

	@Override
	public HandPhone aboutMe() {
		return this;
	}
	
}

public class PhoneTestsel1 {

	public static void main(String[] args) {

		HandPhone hp = new HandPhone();
			System.out.println(hp.aboutMe());
		Phone aboutMe = hp.aboutMe();
			System.out.println(aboutMe);
			System.out.println(((HandPhone)aboutMe));
		if (aboutMe instanceof HandPhone) {
			System.out.println(((HandPhone)aboutMe).weight);
			
		}
		HandPhone aboutMe2 = hp.aboutMe();
		System.out.println(aboutMe2.weight);
		
	}

}
