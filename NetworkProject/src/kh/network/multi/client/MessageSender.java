package kh.network.multi.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MessageSender extends Thread {
	private Socket socket;
	private String name;
	private DataOutputStream dos;
	
	public MessageSender(String name, Socket socket) {
		try {
			this.name = name;
			this.socket = socket;
			dos = new DataOutputStream(this.socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		try {
			dos.writeUTF(name);
			if(dos != null) {
				System.out.print("Message : ");
				dos.writeUTF(name + " : " + sc.nextLine());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
