package ch15.nod.basic;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

	public static void main(String[] args) throws IOException {
		try (InputStream input = System.in){
			int read = -1;
			while ((read = System.in.read())!=-1) {
				System.out.println("���� �� : "+ read+", ���ڷ� :"+(char)read);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
