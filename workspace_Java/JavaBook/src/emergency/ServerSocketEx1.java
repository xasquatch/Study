package emergency;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketEx1 {

	public static void main(String[] args) {
		ServerSocket s = null;
		try {
			s = new ServerSocket(5432);
			
		}catch(Exception e) {}
		try {
			while(true) {
				Socket s1 = s.accept();
				OutputStream os = s1.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject("I'm iron man");
				oos.close();
				s1.close();
			}
		}catch(Exception e) {}

	}

}
