package kh.network.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	private Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = new Client();
		try {
			client.requestConnect();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void requestConnect() throws UnknownHostException {
		// 1. 서버의 IP주소와 서버가 정한 port번호를 패러미터로 하여 클라이언트를...
		int port = Server.PORT;
		String ip = InetAddress.getLocalHost().getHostAddress();
		InputStream is = null;
		OutputStream os = null;
		BufferedReader br = null;
//		BufferedWriter bw = null;
		OutputStreamWriter osw = null;
		String message = null;
		
		try {
			Socket socket = new Socket(ip, port);
			// 2. 서버와의 입출력 스트림을 오픈한다.
			if(socket != null) {
				is = socket.getInputStream();
				os = socket.getOutputStream();
				// 3. 보조스트림
				br = new BufferedReader(new InputStreamReader(is));
//				bw = new BufferedWriter(new OutputStreamWriter(os));
				osw = new OutputStreamWriter(os);
				
				System.out.print("ID : ");
				String name = sc.nextLine();
				System.out.println("Inputed ID : " + name);
				osw.write(name + "\n");
				osw.flush();
				
				while(true) {
					System.out.print("Message : ");
					message = sc.nextLine();
					
					if("exit".equals(message)) {
						System.out.println("Terminated.");
						break;
					} else {
						osw.write(message + "\n");
						osw.flush();
					}					
				}
				
				// 5. 통신 종료
				osw.close();
				br.close();
				socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
