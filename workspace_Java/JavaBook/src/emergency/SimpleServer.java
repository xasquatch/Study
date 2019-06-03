package emergency;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SimpleServer extends JFrame implements ActionListener{
	JTextArea ta;
	JTextField tf;
	ServerSocket s;
	//Socket s1;
	DataInputStream din;
	DataOutputStream dout;
	
	boolean stop;
	
	SimpleServer(){
		//launchFrame();		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ta = new JTextArea();
		
		tf = new JTextField("입력해주세요");
		tf.addActionListener(this);
		
		setBackground(Color.LIGHT_GRAY);
		ta.setEditable(false);
		tf.setEnabled(false);
		add(new JScrollPane(ta), BorderLayout.CENTER);
		add(tf, BorderLayout.SOUTH);
		setSize(500, 300);
		setVisible(true);
		
		ta.append("서비스 준비중 ....\n");		
		
		service();
	}
	
	//public void launchFrame(){
		
	//}
	
	public void service() {
		
		try{
			s = new ServerSocket(5432);
			
			while(true){			
				//ta.append("클라이언트 접속대기중 ....\n");
			
				Socket s1 = s.accept();
				ta.append("클라이언트가 접속하였습니다. "+s1.getInetAddress()+"\n");
				
				tf.setEnabled(true);	
				//ChatThread t = new ChatThread();
				ChatThread t = new ChatThread(s1);
				t.start();			
				
			}
			
		}catch(IOException e ){
			ta.append(e.getMessage()+"2");
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{
			
			
				String msg = tf.getText();
				ta.append("me : "+msg+"\n");
				dout.writeUTF(msg);
				tf.setText("");
			
				if(msg.equals("exit")) {
					//ta.append("me : exit...\n");				
					stop = true;
					dout.close();
					//s1.close();
					s.close();
					System.exit(0);			
				}
			
			
		}catch(IOException e){
			ta.append("연결이 종료되었습니다1");
			tf.setEnabled(false);
			try{
				dout.close();
				//s1.close();
				
			}catch(Exception e1){}
			//ta.append(e.toString());
			
		}
		
	}

	public static void main(String[] args) {
		 new SimpleServer();

	}
	
	class ChatThread extends Thread{
		Socket s1;
		ChatThread(Socket s1){
			this.s1 = s1;
		}
	@Override
	public void run() {
		try{
			dout=new DataOutputStream(s1.getOutputStream());
			din = new DataInputStream(s1.getInputStream());
			
			dout.writeUTF("채팅서버에 접속하신것을 환영합니다 ");
			
			while(!stop) {
				
					String msg = din.readUTF();
					//if(msg.equals("exit")) stop=true;
					//else 
					ta.append(s1.getInetAddress()+" "+msg+"\n");
				
			}
			
			tf.setEnabled(false);
			din.close();
			s1.close();			
		}catch(IOException e){
			ta.append("연결이 종료되었습니다3\n");
			tf.setEnabled(false);
			try{
			  din.close();
			  s1.close();			
			  //ta.append(e.getMessage()+"  1 \n");
			}catch(Exception e1){}
		}
		
	}
	}	

	
	
	
}
