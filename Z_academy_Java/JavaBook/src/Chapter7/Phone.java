package Chapter7;

class Phone {

	String number;

	Phone(){}
	public Phone(String number) {
		this.number = number;
	}

}

class HandPhone extends Phone {
	int price;

	public HandPhone(String Number, int price) {
//		super(number);
		super.number = number;
		this.price = price;

	}	
	public static void main(String[] args) {
		
	}

}

