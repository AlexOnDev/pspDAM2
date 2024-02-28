package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class DateObjectClient {
	public static void main(String[] args) {
		try {
			Socket sock = new Socket("localhost",3001);
			
			ObjectInputStream entradaObjeto = new ObjectInputStream(sock.getInputStream());
			
			//Date tiene que ser serializable
			Date fecha= (Date) entradaObjeto.readObject();
			Date fechaActual = new Date();
			
			//Tiempo aprox de conexion
			System.out.println("He recibido " + fecha);
			System.out.println("Son las: " + fechaActual);
			System.out.println("Diferencia: ");
			System.out.print((fecha.getTime() - fechaActual.getTime()) + "ms.");
		
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
