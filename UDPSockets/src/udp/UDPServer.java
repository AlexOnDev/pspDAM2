package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPServer {
	
	public static void main(String[] args) throws IOException {
//		conexion punto a punto							Metodo que nos devuelve nuestra IP.
//															|
		DatagramSocket  dSock = new DatagramSocket(3001, InetAddress.getByName("localhost"));
//													|			|
//													Puerto		Mi Ip
		
//******Se cambia el puerto de 3000 a 3001, porque si estoy usando un puerto para enviar, necesito un puerto diferente para recibir.
//(teo)	Los datos de la conexion son referidos al receptor en este caso coinciden, menos el puerto, que tiene que ser diferente si estamos trabajando en localhost, ya que estaria ocupado.		
		
//		El servidor envia información
//		Clase datagram packet rellena con la info del cliente.
		
		String mensaje = "Hola Mundo"; // -> con caracteres especiales no cargan por tanto lo vamos a cambiar
//		Los datos de la conexión son referidos al receptor en este caso coinciden		
		
//											Metodo para pasar String a Bytes	Metodo para recuperar el tamaño		IP				Puerto
//															|							|							|				  |
		DatagramPacket info = new DatagramPacket(mensaje.getBytes("UTF-8"), mensaje.getBytes().length, InetAddress.getByName("localhost"), 3000);
//																	|
//															Para que lea las tiltes
		
//		Para mandar el mensaje.		
		dSock.send(info);
		
	}
	
}
// Enviar informacion y que el swithc utilice el metodo multicast para mandar la info a los demas.
