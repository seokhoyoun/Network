package test.iphost;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress2 {

	public static void main(String[] args) throws UnknownHostException {
		// IP 주소로 호스트명 알아내기
		byte[] naverIP = {125,(byte)209,(byte)222,(byte)142};
		InetAddress naverInet = InetAddress.getByAddress(naverIP);
		System.out.println("알아낸 호스트 명 : "+naverInet.getHostName());
		System.out.println("host name : "+naverInet.getCanonicalHostName());
		System.out.println(naverInet.toString());
	}
}
