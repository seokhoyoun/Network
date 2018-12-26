package test.tcp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient22 {

	public static void main(String[] args) {
		startClient();
	}

	private static void startClient() {
		Scanner sc = new Scanner(System.in);
		try(Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(),8888);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					PrintWriter pw  = new PrintWriter(socket.getOutputStream())){
			System.out.println("서버와 연결되었습니다.");
			while(true) {
				System.out.print("입력할 내용 : ");
				String line = sc.nextLine();
				 pw.println(line);
				 pw.flush();
				 System.out.println("서버 : "+ br.readLine());
				if(line.equals("quit")) break;
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
