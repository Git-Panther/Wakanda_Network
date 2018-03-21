package kh.network.udp.run;

import java.util.Scanner;

import kh.network.udp.model.Message;

public class UdpRun {
	private static Scanner sc = new Scanner(System.in);
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("내 포트 번호 : ");
		int myPort = sc.nextInt();
		
		System.out.print("상대 포트 번호 : ");
		int toPort = sc.nextInt();
		
		@SuppressWarnings("unused")
		Message message = new Message(myPort, toPort);
	}

}
