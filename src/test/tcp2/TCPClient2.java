package test.tcp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient2 {

	public static void main(String[] args) {
		clientStart();
	}

	private static void clientStart() {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(),8888);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());
			while(true) {
				System.out.print("전송 할 메세지 : ");
				String line = sc.nextLine();
				pw.println(line);
				pw.flush();
				if(line.equals("quit")) {
					socket.close();
					br.close();
					pw.close();
					break;
				}
				System.out.println(br.readLine());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
