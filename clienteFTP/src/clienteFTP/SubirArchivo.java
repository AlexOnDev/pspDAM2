package clienteFTP;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class SubirArchivo {

	public static void main(String[] args) throws SocketException, IOException {
		
		FTPClient cliente = new FTPClient();
		cliente.connect("127.0.0.1");
		boolean conectado = cliente.login("user", "p@ssw0rd");
		//Para establecer modo pasivo (depende de la configuracin del servidor)
		//cliente.enterLocalPassiveMode();
		//Le decimos el tipo de fichero que vamos a subir, todo lo que no sea TXT es binario.
		cliente.setFileType(FTP.BINARY_FILE_TYPE);
		
		if(conectado) {
			System.out.println("¡Login correcto!");
			
			//Para poder subir el archivo
			File archivoSubida = new File("./Archivos/ParaSubir.pdf");
			FileInputStream is = new FileInputStream(archivoSubida);
			OutputStream os = cliente.storeFileStream("ParaSubir2.pdf");
			//preparar el buffer
			byte[] buffer = new byte[10247];
			int bytesLeidos = 0;
			//hacer un bucl para enviar los bytes del archivo
			while((bytesLeidos = is.read(buffer)) != -1) {
				os.write(buffer, 0, bytesLeidos);
			}
			//Cerramos los archivos
			is.close();
			os.close();
			//Comprobamos si ha funcionado
			if(cliente.completePendingCommand()) {
				System.out.println("Archivo subido correctamente.");
			}else {
				System.out.println("Error al subir el archivo!!");
			}
			
			
		}else {
			System.err.println("Error en el login.");
		}
		cliente.disconnect();
		
	}
}
