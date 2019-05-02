package ch15.nod.array;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MemoryIOTest {

	public static void main(String[] args) {

		char[] memory = "¾È³ç java world".toCharArray();
			
		char[] buffer = new char[5];
		int read = 0;
			try (CharArrayReader creader = new CharArrayReader(memory);
				CharArrayWriter cwriter = new CharArrayWriter();){
				while ((read = creader.read(buffer)) > 0) {
					cwriter.write(buffer,0,read);
//					System.out.println("-----------------------");
//					cwriter.write(buffer);
				}
				System.out.println(Arrays.toString(cwriter.toCharArray()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

}
