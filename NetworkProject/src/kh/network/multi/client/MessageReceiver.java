package kh.network.multi.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class MessageReceiver extends Thread {
	private Socket socket;
	private DataInputStream dis;
	
	public MessageReceiver(Socket socket) {
		this.socket = socket;
		try {
			this.dis = new DataInputStream(this.socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public  MessageReceiver() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		try {
			if(dis != null) {
				while(true) {
						System.out.println(dis.readUTF());
					
					}
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
