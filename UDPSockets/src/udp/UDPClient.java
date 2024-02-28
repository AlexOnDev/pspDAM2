package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;import java.net.UnknownHostException;

public class UDPClient { 
//	Usaremos DatagramSockets, hay que trabajar con bits a diferencia de los otros.
	
	public static void main(String[] args) throws IOException {
//		conexion punto a punto							Metodo que nos devuelve nuestra IP.
//															|
		DatagramSocket  dSock = new DatagramSocket(3000, InetAddress.getByName("localhost"));  //El puerto, mi IP
//													|			|
//													Puerto		Mi Ip
		
//		Creo un datagrama vacío en el que quepan 1000 bytes		
//						Una estimacion de lo que voy a recibir		Numero de bytes   <- No lo he entendido muy bien DD:
//														|			|
		DatagramPacket info = new DatagramPacket(new byte[1000], 1000);
		
//		Para recibir el mensaje del Servidor.		
		dSock.receive(info);
		
		System.out.println("Recibido de: " + info.getAddress() + ". \n" +
							"Por el puerto: " + info.getPort() + ". \n" + 
							"Datos recibidos: " + new String(info.getData(), "UTF-8")); //Saber con lo que estamos codificando (ASEGURARSE SIEMPRE)
//														|
//									Creamos un objeto de String para poder ver el texto
	}
// Se lanza primero el clinte.

	
// Nos llama teo desde su ordneador con una IP  brodcast (192.168.101.255)
}
