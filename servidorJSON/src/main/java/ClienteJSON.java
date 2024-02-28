

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

import com.google.gson.JsonObject;


public class ClienteJSON {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		JsonObject json = new JsonObject();
		
		json.addProperty("type", "CONNECT");
		Socket s = new Socket("localhost", 7878);
		try (OutputStreamWriter out = new OutputStreamWriter(
		        s.getOutputStream(), StandardCharsets.UTF_8)) {
			
		    out.write(json.toString());
		}
	}

}
