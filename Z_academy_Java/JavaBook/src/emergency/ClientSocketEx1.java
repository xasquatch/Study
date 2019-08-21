package emergency;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientSocketEx1 {

	public static void main(String[] args) {
		try {
			Socket s1 = new Socket("192.168.2.2",5432);
			InputStream is =s1.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			System.out.println(ois.readObject());
			ois.close();
			s1.close();
		}catch(Exception e) {}

	}

}
