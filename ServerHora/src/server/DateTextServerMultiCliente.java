package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateTextServerMultiCliente {

	public static final int PORT = 3001;

	public static void main(String[] args) {

		try {
			ServerSocket servSock = new ServerSocket(PORT);
			Socket socket;
			// Al ser un bucle no son hilos solo que en cada vuelta accede un cliente
			// diferente
			while (true) {
				socket = servSock.accept();
				DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
				Date fecha = new Date();
				salida.writeUTF(fecha.toString());
				salida.close();
				socket.close();
				// servSock.close()

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
