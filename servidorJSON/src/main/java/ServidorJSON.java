

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorJSON {
	
	public static void main(String[] args) {
		try {
			ServerSocket serSoc = new ServerSocket(7878);
			Socket s = serSoc.accept();
			InputStreamReader isr = new InputStreamReader(s.getInputStream());

			

			int data = isr.read();
			while(data != -1){
			    char theChar = (char) data;
			    System.out.print(theChar);
			    data = isr.read();
			}
			
			isr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
