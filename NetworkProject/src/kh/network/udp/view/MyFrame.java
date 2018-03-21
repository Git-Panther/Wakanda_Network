package kh.network.udp.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2852186764194326840L;
	@SuppressWarnings("unused")
	private int toPort;
	@SuppressWarnings("unused")
	private InetAddress ipInfo;
	private DatagramSocket socket;
	private JTextArea messageArea;
	private JTextField inputMessage;
	
	public MyFrame(InetAddress ipInfo, int toPort, DatagramSocket socket) {
		// TODO Auto-generated constructor stub
		this.ipInfo = ipInfo;
		this.toPort = toPort;
		this.socket = socket;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		
		messageArea = new JTextArea(5, 30); // 150자
		messageArea.setEditable(false);
		add(messageArea, "Center");
		
		inputMessage = new JTextField();
		inputMessage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String message = inputMessage.getText();
				byte[] messageArr = message.getBytes();
				
				DatagramPacket dp = new DatagramPacket(messageArr, messageArr.length, ipInfo, toPort);
				try {
					socket.send(dp);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				messageArea.append("Message sent : " + inputMessage.getText() + "\n");
				inputMessage.setText("");
			}
		});
		add(inputMessage, "South");
		setVisible(true);
		readMessage(); // while문이라 계속 읽을 것이다.
	}
	
	public void readMessage() {
		while(true) { // 계속 읽어야 한다.
			byte[] buffer = new byte[256];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			try {
				socket.receive(packet);
				messageArea.append("Message received : " + new String(buffer) + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
