package kh.network.udp.model;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import kh.network.udp.view.MyFrame;

public class Message {
	@SuppressWarnings("unused")
	private int myPort;
	@SuppressWarnings("unused")
	private int toPort;
	private InetAddress ipInfo;
	private DatagramSocket socket;
	@SuppressWarnings("unused")
	private MyFrame mf;
	
	public Message(int myPort, int toPort) {
		this.myPort = myPort;
		this.toPort = toPort;
		
		try {
			ipInfo = InetAddress.getByName("127.0.0.1");
			socket = new DatagramSocket(myPort);
			mf = new MyFrame(ipInfo, toPort, socket);
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
