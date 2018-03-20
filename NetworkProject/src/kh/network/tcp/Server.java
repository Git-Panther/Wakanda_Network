package kh.network.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static final int PORT = 10000; // 0 ~ 65525 6000~7000 8000
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server();
		try {
			server.serverStart();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void serverStart() throws IOException { // 서버 돌아가는 방식
		ServerSocket server = new ServerSocket(PORT);
		Socket clientSocket = null;
		InputStream is = null;
		OutputStream os = null;
		BufferedReader br = null;
//		BufferedWriter bw = null;
		OutputStreamWriter osw = null;
		String message = null;
		while(true) {
			System.out.println("서버 실행");
			clientSocket = server.accept();
			
			// 연결된 클라이언트와 입출력 스트림을 생성
			is = clientSocket.getInputStream();
			os = clientSocket.getOutputStream();
			
			// 보조스트림
			br = new BufferedReader(new InputStreamReader(is));
//			bw = new BufferedWriter(new OutputStreamWriter(os));
			osw = new OutputStreamWriter(os);
			while(true) {
				message = br.readLine();
				if(message.equals("exit")) {
					System.out.println("프로그램 종료");
					break;
				} else {
					System.out.println(message);
				}
			}
			br.close();
			osw.close();
			clientSocket.close();
		}
	}
	
}
