package test.iphost;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestInetAddress4 {

	public static void main(String[] args) {
		searchIP();
	}
	
	public static void searchIP() {
		// 키보드로 호스트명을 입력받아, 해당 호스트가 가진 IP주소 모두 출력
		// *none 입력시 종료되게 함.
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("호스트명 입력 : ");
			String host = sc.next();
			if(host.equals("none")) break;
			try {
				InetAddress[] ia = InetAddress.getAllByName(host);
				for(InetAddress e : ia) {
					System.out.println(e.getCanonicalHostName());
				}
			} catch (UnknownHostException e) {
				System.out.println("호스트 입력 오류");
			}
			
		}
		
	}

}
