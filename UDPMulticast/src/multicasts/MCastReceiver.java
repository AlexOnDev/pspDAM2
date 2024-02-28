package multicasts;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class MCastReceiver {
	
	public static void main(String[] args) throws IOException {
//														Puerto
//														  |			
		MulticastSocket mCastSock = new MulticastSocket(3000);
//														Ip 
		InetAddress ipGrupo = InetAddress.getByName("224.0.0.1");
	    mCastSock.setNetworkInterface(NetworkInterface.getByName("eth1"));											

		mCastSock.joinGroup(ipGrupo); //unir a ese grupo en especifico.
		while (true) {
		byte[] arrayDeBytes = new byte[1000];
		DatagramPacket info = new DatagramPacket(arrayDeBytes, arrayDeBytes.length);
		
			mCastSock.receive(info);
			System.out.println("Recibido de: " + info.getAddress() + ". \n" +
					"Por el puerto: " + info.getPort() + ". \n" + 
					"Datos recibidos: " + new String(info.getData(), "UTF-8"));
		}
	}
}
