package kh.network.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress localIp = InetAddress.getLocalHost();
			System.out.println(localIp.getHostAddress());
			System.out.println(localIp.getHostName());
			
			InetAddress naverIp = InetAddress.getByName("www.naver.com");
			System.out.println(naverIp.getHostAddress());
			System.out.println(naverIp.getHostName());
			
			InetAddress[] naverIps = InetAddress.getAllByName("www.naver.com");
			for(InetAddress naver : naverIps) {
				System.out.println(naver.getHostAddress());
				System.out.println(naver.getHostName());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
