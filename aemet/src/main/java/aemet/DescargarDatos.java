package aemet;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DescargarDatos {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Para que quede mas visual.
		String server = "https://opendata.aemet.es/opendata/";
		String apikey = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyMTAxNDZAaWVzc2llcnJhZGVndWFyYS5jb20iLCJqdGkiOiJkMGI0NWRhNi1lZmYzLTQwZDYtYmZkZi05MTE0ZThiZTg0ODAiLCJpc3MiOiJBRU1FVCIsImlhdCI6MTY3NTE1NDYzNSwidXNlcklkIjoiZDBiNDVkYTYtZWZmMy00MGQ2LWJmZGYtOTExNGU4YmU4NDgwIiwicm9sZSI6IiJ9.NW7CYlKvOy6mVtZWF8WoGWgbKgD4cGcRB44kaqelGhM";
		String endpoint = "api/observacion/convencional/todas";
		
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
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
		mapper.setDateFormat(df);
		
		//Mapeamos los datos en una lista.
		List<EstacionMeteo> listaEstaciones = mapper.readValue(resDatos.body(), new TypeReference<List<EstacionMeteo>>() {});
		
		System.out.println(listaEstaciones.get(0).getIdema());
		System.out.println(listaEstaciones.get(0).getUbi());
		System.out.println(listaEstaciones.get(0).getTa());

		
		HashMap<String, EstacionMeteo> mapaEstaciones = new HashMap<String, EstacionMeteo>();
		for(EstacionMeteo estacionMeteo : listaEstaciones) {
			mapaEstaciones.put(estacionMeteo.getIdema(), estacionMeteo); //El propio objeto tiene la clave
			
		}
		//coger el valor deseado filtrado por el idioma de Huesca(9901X)
		System.out.println(mapaEstaciones.get("9901X"));
		
		
		
	}

}
