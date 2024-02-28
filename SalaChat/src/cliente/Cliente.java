package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import modelo.Mensaje;

public class Cliente {
	public static void main(String[] args) {
		
		try {
			Socket sock = new Socket("192.168.101.14", servidor.Servidor.PUERTO);
			new TecladoEnviar(sock).start();
			ObjectInputStream entrada = new ObjectInputStream(sock.getInputStream());
			
			while(true) {
				System.out.println((Mensaje) entrada.readObject());
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
