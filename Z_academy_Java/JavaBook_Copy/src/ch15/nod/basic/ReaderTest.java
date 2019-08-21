package ch15.nod.basic;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReaderTest {

	public static void main(String[] args) {
		char [] buffer = new char[10];
		try(Reader rd = new InputStreamReader(System.in)) {
			
			int read = -1;
			
			while ((read = rd.read(buffer)) > 0) {
				System.out.printf("읽은수:%d,정보:%s\n",read,new String(buffer,0,read));
				
			}
			
		} catch (IOException e) {
			 e.printStackTrace();
		}
	}

}
