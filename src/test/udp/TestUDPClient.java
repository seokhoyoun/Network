package test.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TestUDPClient {

	public static void main(String[] args) throws IOException {
		// udp 데이터 받는 프로그램
		System.out.println("UDP receiver running....");
		udpReceiver();
	}

	private static void udpReceiver() throws IOException {
		// 1. 데이터를 받기 위한 byte[] 준비
		byte[] receiveMsg = new byte[1024];
		
		// 2. 소켓과 패킷 객체 생성
		DatagramSocket uclient = new DatagramSocket(5555);
		DatagramPacket pk = new DatagramPacket(receiveMsg, 1024);
		
		// 3. 데이터 받기
		uclient.receive(pk);
		
		// 4. 받은 데이터 출력 확인
		String msg = new String(receiveMsg);
		System.out.println("받은 메세지 : "+ msg);
		
		// 5. 소켓 닫기
		uclient.close();
	}

}
