package ch15.nod.basic;

import java.io.IOException;
import java.io.InputStream;

public class InputStareamTest2 {

	public static void main(String[] args) {
		
		byte [] buffer = new byte[10];
		
		try (InputStream st = System.in) {
			
			int read = -1;
			
			
				while ((read = st.read(buffer))>-5) {
					System.out.println("���� ���� :" + read + ", ���ڿ� : "+new String(buffer,0,read));
					
				}
				
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("---------------------------------");
			e.getMessage();
		}

	}

}
