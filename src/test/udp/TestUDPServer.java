package test.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class TestUDPServer {

	public static void main(String[] args) throws IOException {
		// UDP 패킷 전송용 프로그램
		udpSender();
		System.out.println("스팸 전송 끝...");
	}

	private static void udpSender() throws IOException {
		// 1. port 번호 지정
		int port = 5555;
		
		// 2. DatagramSocket 객체 생성함
		DatagramSocket ds = new DatagramSocket();
		
		// 3. 데이터를 받을 클라이언트 주소지정
		InetAddress client = InetAddress.getByName("127.0.0.1");
		
		// 4. 전송할 메세지 데이터 준비
		String mes = "이것은 스팸메세지 입니다.";
		byte[] sendMsg = mes.getBytes();
		
		// 5. 메세지 담을 객체 생성
		DatagramPacket pk = new DatagramPacket(sendMsg,0,sendMsg.length,client,port);
		
		// 6. 패킷을 전송함
		ds.send(pk);
		
		// 7. 소켓 닫기
		ds.close();
	}

}
