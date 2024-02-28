package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateTextServerMultiClienteThread {

	public static final int PORT = 3001;

	public static void main(String[] args) {

		try {
			ServerSocket servSock = new ServerSocket(PORT);
			Socket socket;
			// Al ser un bucle no son hilos solo que en cada vuelta accede un cliente
			// diferente
			while (true) {
				socket = servSock.accept();
				// Hacemos el mismo codigo que la clase MultiCliente pero lo hacemos con hilo
				// permitiendo crear varios clientes casi simultaneamente.
				new HiloConexion(socket).start();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
