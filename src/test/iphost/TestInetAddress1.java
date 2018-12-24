package test.iphost;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress1 {

	public static void main(String[] args) {
		// java.net.InetAddress class test
		
		try {
			// host name : domain name
			InetAddress naverIP = InetAddress.getByName("www.naver.com");
			InetAddress[] naverIP2 = InetAddress.getAllByName("www.naver.com");
			System.out.println("네이버 웹서버의 ip주소 : "+ naverIP.getHostAddress());
			InetAddress[] googles = InetAddress.getAllByName("www.google.com");
			System.out.println("구글 웹 서버 갯수 : "+ googles.length);
			System.out.println("====================================");
			for(InetAddress e : googles) {
				System.out.println(e.getHostAddress());
			}
			System.out.println("====================================");
			for(InetAddress e : naverIP2){
				System.out.println(e.getHostAddress());
			}
			
			InetAddress mIP = InetAddress.getLocalHost();
			System.out.println(mIP.getHostName());
			System.out.println(mIP.getHostAddress());
		} catch (UnknownHostException e) {
			System.out.println("도메인 명이 틀렸습니다.");
			System.out.println("확인 후 다시 실행하세요");
		} 
	}

}
