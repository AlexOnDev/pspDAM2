package aemet;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DescargarDatosHuesca {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Para que quede mas visual.
		String server = "https://opendata.aemet.es/opendata/";
		String apikey = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyMTAxNDZAaWVzc2llcnJhZGVndWFyYS5jb20iLCJqdGkiOiJkMGI0NWRhNi1lZmYzLTQwZDYtYmZkZi05MTE0ZThiZTg0ODAiLCJpc3MiOiJBRU1FVCIsImlhdCI6MTY3NTE1NDYzNSwidXNlcklkIjoiZDBiNDVkYTYtZWZmMy00MGQ2LWJmZGYtOTExNGU4YmU4NDgwIiwicm9sZSI6IiJ9.NW7CYlKvOy6mVtZWF8WoGWgbKgD4cGcRB44kaqelGhM";
		String endpoint = "api/observacion/convencional/datos/estacion/9901X";
		
		HttpClient cliente = HttpClient.newHttpClient();
		HttpRequest req = HttpRequest.newBuilder().uri(URI.create(server + endpoint + "?api_key=" + apikey)).GET().build();
		
		HttpResponse<String> res = cliente.send(req, HttpResponse.BodyHandlers.ofString());
		
		System.out.println(res.body());
		System.out.println(res);
		
		
		//https://opendata.aemet.es/opendata/sh/2f2056ba
		//Usar jackson para obtener la cadena de datos y de metadatos
		ObjectMapper mapper = new ObjectMapper();
		String urlDatos = mapper.readTree(res.body()).at("/datos").asText(); //accede al contenido de la propiedad del objeto json "datos"
		
		//hacer las peticiones correspondientes de esos dos JSON
		HttpRequest reqDatos = HttpRequest.newBuilder().uri(URI.create(urlDatos)).GET().build();
		HttpResponse<String> resDatos = cliente.send(reqDatos, HttpResponse.BodyHandlers.ofString());
		
		//Mapeamos los datos en una lista.
		List<EstacionMeteo> observacionesHuesca = mapper.readValue(resDatos.body(), new TypeReference<List<EstacionMeteo>>() {});
		
		
		for(EstacionMeteo estacionMeteo : observacionesHuesca) {
			System.out.println(estacionMeteo.getFint() + " " + estacionMeteo.getTa());
			
			
		}
		//coger el valor deseado filtrado por el idioma de Huesca(9901X)

		
		
		
	}

}
