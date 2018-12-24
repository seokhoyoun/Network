package test.tcp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer2 {
	
	
	public static void main(String[] args) {
		try {
			startServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void startServer() throws IOException {
		int port = 8888;
		ServerSocket server = new ServerSocket(port);
		Socket client = server.accept(); 
		try(ServerSocket ss = new ServerSocket();
				BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
					PrintWriter pw = new PrintWriter(client.getOutputStream())){
			while(true) {
				System.out.println("클라이언트 메세지 수신을 기다리는 중...");
				String cmes = br.readLine();
				if(cmes.equals("quit")) {
					pw.println("연결이 끊어졌습니다.");
					client.close();
				}
				System.out.println("받은 메세지 : "+cmes);
				pw.println("서버 메세지 수신...");
				pw.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
