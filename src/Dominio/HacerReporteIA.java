//Guillermo Bértola 303665 y Santiago Durán 351471
package Dominio;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import Archivos.ArchivoLectura;
import java.io.File;


public class HacerReporteIA {

    private String API_KEY;
    private boolean errorDeApi;

    public HacerReporteIA() {
        API_KEY = System.getenv("ERP_API_KEY");
        
        errorDeApi = false;
        
        if (API_KEY == null || API_KEY.trim().isEmpty()) {
            errorDeApi = true;
        }
    }
    
    public boolean errorDeApi(){
        return this.errorDeApi;
    }
    
    public String construirPrompt(Area origen, Area destino, Empleado empleado) {
        ArchivoLectura arch = new ArchivoLectura(System.getProperty("user.dir")+ File.separator + "cvs" + "/CV" + empleado.getCedula() + ".txt");
        String cvEmpleado = "";
        while(arch.hayMasLineas()){
            cvEmpleado += arch.linea();
        }
        arch.cerrar();
        String prompt = "Analizaras deciciones tomadas dentro de una empresa. Debes dar una opinion sobre el traslado de area de un empleado. Se te dara, la descripcion del area de origen, la descripcion del area destino y un resumen del curriculum del empleado. Formula una opinion sobre si es buena idea el cambio de area respecto a las aptitudes del empleado y donde se puede adaptar mejor, dando pros y contras"+
                        "Datos areas: \n" +
                        "Area de origen: " + origen.getNombre() + origen.getDescripcion() + "\n" +
                        "Area de destino: " + destino.getNombre() + destino.getDescripcion() + "\n" +
                        "Curriculum: " + cvEmpleado;
        return prompt;
    }
    
    public String obtenerReporteGemini(String prompt) throws Exception {

        // El modelo solicitado: gemini-2.5-flash
        String URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" + API_KEY;

        // 1. Construir el cuerpo de la petición en JSON (payload)
        // Se recomienda usar objetos GSON para construir JSON de forma segura.
        JsonObject part = new JsonObject();
        part.addProperty("text", prompt);

        // 2. Crear el array 'parts' y añadir el objeto 'part'
        JsonArray partsArray = new JsonArray();
        partsArray.add(part); 

        // 3. Crear el objeto 'content' y añadir el array 'parts'
        JsonObject content = new JsonObject();
        content.add("parts", partsArray);

        // 4. Crear el array 'contents' y añadir el objeto 'content'
        JsonArray contentsArray = new JsonArray();
        contentsArray.add(content);

        // 5. Crear el objeto final 'jsonRequest' y añadir el array 'contents'
        JsonObject jsonRequest = new JsonObject();
        jsonRequest.add("contents", contentsArray);

        // Opcional: añade el modelo si quieres especificarlo explícitamente, 
        // aunque la URL ya lo tiene implícito.

        String requestBody = jsonRequest.toString();

        part.addProperty("text", prompt);
        content.getAsJsonArray("parts").add(part);
        jsonRequest.getAsJsonArray("contents").add(content);

        
        // 2. Crear la petición HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        // 3. Enviar la petición y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Error en la consulta a Gemini: Código HTTP " + response.statusCode() + " - " + response.body());
        }

        // 4. Procesar la respuesta JSON para extraer el texto
        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);

        // Navegar en el JSON para encontrar el texto generado
        // candidates -> 0 -> content -> parts -> 0 -> text
        String reporte = jsonResponse
                            .getAsJsonArray("candidates").get(0).getAsJsonObject()
                            .getAsJsonObject("content")
                            .getAsJsonArray("parts").get(0).getAsJsonObject()
                            .get("text").getAsString();

        return reporte;
    }
    
}

