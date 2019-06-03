package emergency;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientSocketEx2 {

	public static void main(String[] args) {
		try {
			Socket s1 = new Socket("localhost",5432);	
			
			OutputStream os = s1.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject("I'm tae client");
			
			InputStream is =s1.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);			
			System.out.println("server>>"+ois.readObject());
			
			ois.close();
			oos.close();
			s1.close();
		}catch(Exception e) {e.printStackTrace();}

	}

}
