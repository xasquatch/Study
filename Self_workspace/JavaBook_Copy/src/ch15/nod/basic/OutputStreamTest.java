package ch15.nod.basic;

import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamTest {

	public static void main(String[] args) {
		try (OutputStream op = System.out){
			String msg = "HELLO JAVAÀÚ¹Ù";
			op.write(msg.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
