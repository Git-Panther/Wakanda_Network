package kh.network.multi.server;

import java.io.IOException;

public class ServerRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiChatServer server = new MultiChatServer();
		try {
			server.serverStart();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
