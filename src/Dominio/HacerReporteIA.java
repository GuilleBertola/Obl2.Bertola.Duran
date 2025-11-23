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
        String prompt = "Analizaras deciciones tomadas dentro de una empresa. Debes dar una opinión sobre el traslado de área de un empleado. Se te dará, la descripción del área de orígen, la descripción del área destino y un resumen del currículum del empleado. Formula una opinión sobre si es buena idea el cambio de área respecto a las aptitudes del empleado y donde se puede adaptar mejor, dando pros y contras"+
                        "Datos áreas: \n" +
                        "Área de origen: " + origen.getNombre() + origen.getDescripcion() + "\n" +
                        "Área de destino: " + destino.getNombre() + destino.getDescripcion() + "\n" +
                        "Curriculum: " + cvEmpleado;
        return prompt;
    }
    
    public String obtenerReporteGemini(String prompt) throws Exception {

        // El modelo solicitado: gemini-2.5-flash
        String URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" + API_KEY;

        //Se crea una "part" (ver proximo comment) explicita el tipo de dato y le pasa el prompt. si enviaramos varios tipos de datos este es uno de ellos
        JsonObject part = new JsonObject();
        part.addProperty("text", prompt); //Esto seria como un HashMap?

        // El array parts lleva los diferentes tipos de entradas (videos, imagenes texto) solo ponemos el texto dentro porque solo eso usamos
        JsonArray partsArray = new JsonArray();
        partsArray.add(part); 

        // cada content es una de las interacciones con el modelo
        JsonObject content = new JsonObject();
        content.add("parts", partsArray);

        // Aca van las diferentes partes de la conversacion, solo hay un objeto porque solo hacemos una pregunta
        JsonArray contentsArray = new JsonArray();
        contentsArray.add(content);

        // Este es el formato que se le envia
        JsonObject jsonRequest = new JsonObject();
        jsonRequest.add("contents", contentsArray);

        String requestBody = jsonRequest.toString(); //Solo se pueden enviar texto, manda el texto con el formato esperado del toString

        part.addProperty("text", prompt);
        content.getAsJsonArray("parts").add(part);
        jsonRequest.getAsJsonArray("contents").add(content);

        
        // 2. Crear la petición HTTP
        HttpClient client = HttpClient.newHttpClient(); //Crea el "navegador"
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL)) //Esta es la url creada anteriormente con la api
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody)) //Este es el texto creado en formato gson
                .build();

        // 3. Enviar la petición y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) { //Si el status es 200 sigifica que fue exitoso, si no es un error el cual lo dice, mas adelante trabajamos en este error
            throw new RuntimeException("Error en la consulta a Gemini: Código HTTP " + response.statusCode() + " - " + response.body());
        }

        // 4. Procesar la respuesta JSON para extraer el texto
        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);

        //La respuesta viene en el mismo formato que lo enviamos, hay que entar en todos los diferentes objetos hasta llegar al texto
        String reporte = jsonResponse.getAsJsonArray("candidates").get(0).getAsJsonObject().getAsJsonObject("content").getAsJsonArray("parts").get(0).getAsJsonObject().get("text").getAsString();

        return reporte;
    }
    
}

