package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateTextServer{

	public static final int PORT = 3001;
	public static void main(String[] args) {
		
		try {
			ServerSocket servSock = new ServerSocket(PORT);
			
			Socket socket= servSock.accept();
			
			//Abrimos el canal por el que le vamos a mandar los datos y de parametro ponemos el ouptutstream del socket recien creado.
			DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
			Date fecha = new Date();			
			//Le mandamos la fecha
			salida.writeUTF(fecha.toString());
			
			//Cerramos el flujo de datos y la conexion
			salida.close();
			socket.close();
			servSock.close();
			
		} catch (IOException e) {
			// Si no puede acceder al puerto, el programa entra aqui
			e.printStackTrace();
		}
		
		
	}
	
	
}
