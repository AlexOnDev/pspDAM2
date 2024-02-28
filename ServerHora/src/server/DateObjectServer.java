package server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class DateObjectServer {
	public static void main(String[] args) {
		try {
			ServerSocket serSock = new ServerSocket(3001);
			Socket socket= serSock.accept();
			
			ObjectOutputStream salidaObjeto = new ObjectOutputStream(socket.getOutputStream());
			//salidaObjeto.writeObject(new Date());
			salidaObjeto.writeObject(new model.Persona("Pepe",23));
			salidaObjeto.close();
			socket.close();
			serSock.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
