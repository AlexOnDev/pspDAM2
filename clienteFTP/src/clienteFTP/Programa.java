package clienteFTP;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;


public class Programa {
	
	public static void main(String[] args) throws SocketException, IOException {
		FTPClient cliente = new FTPClient();
		cliente.connect("127.0.0.1");
		boolean conectado = cliente.login("user", "p@ssw0rd");
		
		if(conectado) {
			System.out.println("¡Login correcto!");
			//cliente.cwd("carpeta");  //para entrar a un directorio del servidor
		//	FTPFile[] archivos = cliente.listFiles(); // agrupar todo en la lista
		//	for(FTPFile ftpFile : archivos) {	//imprimir la lista de directorios, carpetas y archivos.
		/*		System.out.println("[Lista]" + ftpFile.getName());
				if(ftpFile.isFile()) {
					System.out.println("[File]" + ftpFile.getName());
				}else {
					
				}
			}*/
			mostrarDirectorio(cliente, "/", "");
			cliente.disconnect();
			
		}else {
			System.err.println("Error en el login.");
		}
		cliente.disconnect();
	}
	
	public static void mostrarDirectorio(FTPClient cliente, String carpeta, String prefijo) throws IOException {
		cliente.cwd(carpeta);
		FTPFile[] archivos = cliente.listFiles();
		for(FTPFile ftpFile : archivos) {	
			//System.out.println("[Lista]" + ftpFile.getName());
			if(ftpFile.isFile()) {
				System.out.println(prefijo + "-" + ftpFile.getName());
			}else {
				System.out.println(prefijo + "+" + ftpFile.getName() + "/");
				mostrarDirectorio(cliente, ftpFile.getName(), prefijo +"\t");
				cliente.changeToParentDirectory();
				
			}
		}
	}
}
//mostrar de manera recursiva todos los directorios del servidor.