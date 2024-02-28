package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

import server.DateTextServer;

public class DataTextClient {

	public static void main(String[] args) {
		try {
			//Sin timeout
			//Socket sock = new Socket("localhost", server.DataTextServer.PORT);
			
			//Preparo el socket
			Socket sock = new Socket();
			
			//Perparo la direccion del serivdor. IP y ppuerto
			SocketAddress sockAddr= new InetSocketAddress("192.168.101.100", 3001);
			
			//Intento la conexion, estableciendo un timeout de 6 segundos.
			sock.connect(sockAddr,6000);
			
			DataInputStream entrada= new DataInputStream(sock.getInputStream());
			String fecha = entrada.readUTF();
			
			System.out.println(fecha);
			entrada.close();
			sock.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
