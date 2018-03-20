package kh.network.multi.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import kh.network.multi.server.MultiChatServer;

public class MultiChatClient {
	public MultiChatClient() {
//		String ip = "127.0.0.1"; // localhost
		String ip = "192.168.10.33";
//		int port = MultiChatServer.PORT;
		int port = 10005;
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하십시오 : ");
		String name = sc.nextLine();
		
		try {
			Socket socket = new Socket(ip, port);
			
			new MessageSender(name, socket).start();
			new MessageReceiver(socket).start();;
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
