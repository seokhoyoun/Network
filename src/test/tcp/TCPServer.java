package test.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		// TCP Server 프로그램
		ServerStart();
	}

	public static void ServerStart() {
		// 1. port 번호 정하기
		int port = 7777;
		ServerSocket server = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			
		// 2. 서버용 소켓 객체 만들기
		server = new ServerSocket(port);
		
		// 3.클라이언트로 부터 연결요청을 기다림.
		while(true) {
			System.out.println("클라이언트 요청을 기다리는 중...");
			
			// 4. 연결 요청한 클라이언트의 요청을 수락함
			// 해당 클라이언트의 정보를 저장한 소켓 객체 생성함.
			Socket client = server.accept();
			System.out.println(client.getInetAddress().getHostAddress()+"에서 연결 요청됨");
			
			//5. 해당 클라이언트와 입출력 스트림 생성함.
			InputStream is = client.getInputStream();
			OutputStream os = client.getOutputStream();
			
			// 성능 또는 사용 개선을 위해 보조스트림 추가로 연결
			// 바이트 스트림을 문자스트림으로 바꿀 수도 있다.
			
			br = new BufferedReader(new InputStreamReader(is));
			pw = new PrintWriter(os);
			
			// 6. 메세지를 주고받음
			// 클라이언트가 보낸 메세지 읽어서 출력
			String mes = br.readLine();
			System.out.println("받은 메세지 : "+ mes);
			// 서버가 답을 보냄
			pw.println("서버 메세지 수신...");
			pw.flush();
			
			// 7. 스트림 반납함
			pw.close();
			br.close();
			client.close();
		} //while
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				
				
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
