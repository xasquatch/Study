package emergency;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocetEx2 {
	public static void main(String[] args) {
		ServerSocket s = null;
	      try{
	         s=new ServerSocket(5432);
	         System.out.println(" Yoon Mi Young Server Start.... " );
	         
	         while(true) {
	            Socket s1 = s.accept();        

	            
	            InputStream is = s1.getInputStream();
	            ObjectInputStream ois = new ObjectInputStream(is);            
	            System.out.println(ois.readObject());
	            
	            System.out.println("accept  From: " + s1.getInetAddress().toString());
	            
	            OutputStream os = s1.getOutputStream();
	            ObjectOutputStream oos = new ObjectOutputStream(os);
	            oos.writeObject("I'm Yoon Mi Young Server");
	            
	            
	            oos.close();
	            ois.close();	            
	            s1.close();
	         }
	      }catch(Exception e){
	          System.out.println(e.getMessage());
	       }

	}
}
