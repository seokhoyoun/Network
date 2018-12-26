package udp.practice2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSpamSender2 {
	// 192.168.30.(0~255)
	// 무작위로 10개의 ip에 스팸메세지를 전송하는 프로그램 작성

	public static void main(String[] args) {
		spamSender();
	}

	private static void spamSender() {
		String[] ip = new String[10];
		
		for(int i = 0; i < ip.length; i++) {
			ip[i] = "192.168.30."+(int)Math.random()*255;
		}
		
		try{
			DatagramSocket ds = new DatagramSocket();
			String msg = InetAddress.getLocalHost().getHostName()+"의 스팸!!!!!!!!!!!";
			byte[] bmsg = msg.getBytes();
			for(int count = 0; count < 10; count++) {
				DatagramPacket pk = new DatagramPacket(bmsg, bmsg.length, InetAddress.getByName(ip[count]),6666);
				ds.send(pk);
				System.out.println(ip[count] + "로 보냄...");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
	}

}
