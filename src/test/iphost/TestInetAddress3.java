package test.iphost;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestInetAddress3 {

	public static void main(String[] args) {
		// 키보드로 도메인 명을 입력받아 해당 호스트 서버의 ip 주소 조회
		// 조회된 ip 주소의 호스트명 출력 처리
		searchIP();
	}
	
	public static void searchIP() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("도메인 명 입력 : ");
		String domain = sc.next();
		try {
//			InetAddress ia = InetAddress.getByName(domain);
			InetAddress[] ia2 = InetAddress.getAllByName(domain);
//			System.out.println(ia.getHostAddress());
			for(InetAddress e : ia2) {
				System.out.println(e.getHostAddress());
			}
		} catch (UnknownHostException e) {
			System.out.println("도메인 입력 오류!");
		}
	}

}
