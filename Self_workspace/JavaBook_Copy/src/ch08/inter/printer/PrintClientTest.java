package ch08.inter.printer;

interface Printer {
	void print(String fileName);
}

class LaserPrinter implements Printer {

	@Override
	public void print(String fileName) {
		System.out.printf("Laser Printer로 출력 중 : %s%n", fileName);

	}

}

class DotPrinter implements Printer {

	@Override
	public void print(String fileName) {
		System.out.printf("Dot Printer로 출력 중 : %s%n", fileName);

	}

}

class PrintClient {

	private Printer printer;

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public void printThis(String fileName) {
		printer.print(fileName);
	}

}

public class PrintClientTest {

	public static void main(String[] args) {
		PrintClient pc = new PrintClient();
		pc.setPrinter(new DotPrinter());
		pc.printThis("Hello.java");
		pc.setPrinter(new LaserPrinter());
		pc.printThis("Hi.java");
	}

}
