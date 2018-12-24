package test.iphost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TestURLReading {

	public static void main(String[] args) throws MalformedURLException {
		// url의 파일을 읽어와서 콘솔에 출력
		String urlStr = "https://www.oracle.com/technetwork/java/javase/downloads/index.html";
		URL url = new URL(urlStr);
		try(BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))){
			int lineNumber = 1;
			String lineStr = null;
			while((lineStr = br.readLine())!= null) {
				System.out.println(lineNumber++ + " : " +lineStr);
			}
			System.out.println("=======================================================================");
			URLConnection uc = url.openConnection();
			System.out.println("file : "+url.getFile());
			System.out.println("length : "+uc.getContentLength());
			System.out.println("type : "+uc.getContentType());
			System.out.println("encoding : "+uc.getContentEncoding());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
