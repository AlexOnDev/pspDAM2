package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class DateObjectClientPersona {
	public static void main(String[] args) {
		try {
			Socket sock = new Socket("localhost",3001);
			
			ObjectInputStream entradaObjeto = new ObjectInputStream(sock.getInputStream());
			
			model.Persona p = (model.Persona) entradaObjeto.readObject();
			System.out.println(p);
			
		
			
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
