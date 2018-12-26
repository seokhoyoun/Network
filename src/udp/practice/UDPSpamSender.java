package udp.practice;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSpamSender {
	// 192.168.30.(0~255)
	// 무작위로 10개의 ip에 스팸메세지를 전송하는 프로그램 작성

	public static void main(String[] args) {
		spamSender();
	}

	private static void spamSender() {
		int port = 6666;
		
		String[] ip = new String[10];
		
		for(int i = 0; i < ip.length; i++) {
			ip[i] = "192.168.30."+((int)(Math.random()*255))+1;
		}
		
		try(DatagramSocket ds = new DatagramSocket()){
			String msg = InetAddress.getLocalHost().getHostName()+"의 스팸!!!!!!!!!!!";
			byte[] bmsg = msg.getBytes();
			DatagramPacket pk = new DatagramPacket(bmsg, bmsg.length);
			for(int count = 0; count < 10; count++) {
				byte[] addr = msg.getBytes();
				InetAddress clients = InetAddress.getByAddress(addr);
				pk.setAddress(clients);
				ds.send(pk);
				/*for(int i = 0; i < addr.length; i++) {
					System.out.print(addr[i]+" ");
				}System.out.println();*/
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
	}

}
