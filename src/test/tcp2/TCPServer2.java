package test.tcp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer2 {
	
	
	public static void main(String[] args) {
		
			startServer();
		
	}

	public static void startServer() {
		int port = 8888;
		try(ServerSocket server = new ServerSocket(port)){
			while(true) {
				System.out.println("새 연결을 기다리는 중...");
				onServer(server);
			}
		} catch(IOException e){
			e.printStackTrace();
		}
		
	}

	public static void onServer(ServerSocket server) {
		Scanner sc = new Scanner(System.in);
		try(Socket client = server.accept(); 
				BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
					PrintWriter pw = new PrintWriter(client.getOutputStream())){
			while(true) {
				System.out.println(client.getInetAddress().getHostAddress()+"의 메세지 수신을 기다리는 중...");
				String cmes = br.readLine();
				if(cmes.equals("quit")) {
					pw.println("서버와의 연결을 종료합니다.");
					pw.flush();
					System.out.println(client.getInetAddress().getHostAddress()+" 연결이 종료되었습니다.");
					client.close();
					break;
				}
				System.out.println("받은 메세지 : "+cmes);
				System.out.print("보낼 메세지 입력 : ");
				pw.println(sc.nextLine());
				pw.flush();
			
			}	
		} catch (IOException e) {
			System.out.println("클라이언트와 연결이 종료되었습니다.");
		}
	}
}
