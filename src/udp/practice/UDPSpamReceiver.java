package udp.practice;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPSpamReceiver {
	
	public static void receiver() {
		// 무작위로 전송된 스팸메세지 받아서 출력하는 프로그램
		// 무한루프로 전송온 패킷 정보를 계속 받아 출력하는 프로그램
		byte[] bmsg = new byte[1024];
		
		try(DatagramSocket ds = new DatagramSocket(6666)) {
			DatagramPacket pk = new DatagramPacket(bmsg, 1024);
			ds.receive(pk);
			String msg = new String(bmsg);
			System.out.println("받은 메세지 : "+ msg);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
			System.out.println("UDP receiver running....");
			receiver();
	}

}
