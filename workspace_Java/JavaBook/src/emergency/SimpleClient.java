package emergency;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import emergency.SimpleServer.ChatThread;

public class SimpleClient extends Thread implements ActionListener {

	JTextArea ta;
	JTextField tf, tf2;
	JDialog dialog;
	String host;
	
	Socket s1;
	DataInputStream din;
	DataOutputStream dout;
	Dialog frame;
	boolean stop;
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setBackground(Color.lightGray);
		ta.setEditable(false);
		frame.add(new JScrollPane(ta),BorderLayout.CENTER);
		frame.add(tf, BorderLayout.SOUTH);
		
		JOptionPane.showInputDialog(null,"input IP");
		host= str.trim;
		if (host.equals("")) host="localhost";
			
		
		service();
	}

	public void service() {
		try {
			s1 = new Socket(host,5432);
			din = new DataInputStream(s1.getInputStream());
			dout = new DataOutputStream(s1.getOutputStream());
			
			ta.append(host+"connect complete....\n");
			
			Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						while (!stop) {
							String msg = din.readUTF();
							ta.append(msg);
							if (msg.equals("exit")) break;
						}
						din.close();
						s1.close();
						System.exit(0);
					} catch (Exception e) {
						ta.append(e.getMessage());
					}
					
				}
			});
					
			t.start();
		} catch (Exception e) {
			System.out.println("disconnect,...");
			System.exit(0);
		}
		
	}
	public static void main(String[] args) {
		

	}

}
