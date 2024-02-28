package servidor;

import java.net.Socket;
import java.util.ArrayList;

import modelo.Mensaje;

public class Emisor extends Thread{
	private Socket sock;
	private ArrayList<Mensaje> listaMensajes = new ArrayList<Mensaje>();
	
	public Emisor(Socket sock, ArrayList<Mensaje> listaMensajes) {
		this.sock = sock;
		this.listaMensajes = listaMensajes;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		//Inicializar la salida. object output stream
		//while true
			// esperar notificacion de ultimo mensaje añadido a la lista (sincronizadamente)
			// coger el ultimo mensaje (sincronizadamente)
			// enviarlo
	}
	
	


}
