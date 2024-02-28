package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import modelo.Mensaje;

public class TecladoEnviar extends Thread {

	Socket sock;
	ObjectOutputStream salida;
	
	public TecladoEnviar(Socket sock) {
		this.sock = sock;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.println("Escribe tu nombre y pulsa enter: ");
		String nombre = teclado.nextLine();
		
		try {
			salida = new ObjectOutputStream(sock.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true) {
			try {
				salida.writeObject(new Mensaje(nombre, teclado.nextLine()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
	
}
