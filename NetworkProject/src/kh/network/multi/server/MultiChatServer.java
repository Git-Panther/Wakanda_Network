package kh.network.multi.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Iterator;

public class MultiChatServer {
	private ServerSocket serverSocket;
	private Socket clientSocket;
	public static final int PORT = 8888;
	public void serverStart() throws IOException {
		// TODO Auto-generated method stub
		serverSocket = new ServerSocket(PORT);
		System.out.println("서비스 제공 시작");
		
		while(true) {
			clientSocket = serverSocket.accept();
			System.out.println("클라이언트 요청이 들어왔습니다.");
			
			// 병렬 처리
			new ServerReceiver(clientSocket).start();
		}
		
	}
	
	public class ServerReceiver extends Thread{
		private Socket socket;
		private DataInputStream dis;
		private DataOutputStream dos;
		private Hashtable<String, DataOutputStream> clients = new Hashtable<String, DataOutputStream>();
		
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				this.dis = new DataInputStream(this.socket.getInputStream());
				this.dos = new DataOutputStream(this.socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				String name = dis.readUTF();
				sendMessageAll(name + "님이 들어왔습니다.");
				clients.put(name, dos);
				String message = null;
				
				while(true) {
					message = dis.readUTF();
					sendMessageAll(message);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		public void sendMessageAll(String message) {
			// TODO Auto-generated method stub
			Iterator<String> keys = clients.keySet().iterator();
			String key = null;
			DataOutputStream toClient = null;
			while(keys.hasNext()) {
				key = keys.next();
				toClient = clients.get(key);
				try {
					toClient.writeUTF(message);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
		
	}
}
