package Chapter15;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest {

	public static void main(String[] args) throws IOException {

		File src = new File("C:/Temp/streamtest.dat");
		
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(src))) {
			dos.writeUTF("ȫ�浿");
			dos.writeInt(30);
			dos.writeDouble(170.5);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try(DataInputStream dis = new DataInputStream(new FileInputStream(src))) {
			String name = dis.readUTF();
			int age = dis.readInt();
			double weight = dis.readDouble();
			System.out.println(name+" "+age+" "+weight);
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		
	}

}
