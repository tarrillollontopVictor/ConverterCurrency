package Service;

import Config.ApiConfig;
import Dtos.CountryDto;
import Dtos.FlagDtoResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class FlagService {

    private final HttpClient hc;

    public FlagService() {
        this.hc = HttpClient.newHttpClient();
    }

    public FlagDtoResponse getFlagByCountry(CountryDto country) throws IOException, InterruptedException {
        // Construir la URL
        String url = ApiConfig.getAPI_GET_FLAG() + country.country();

        // Construir la solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = hc.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            // Procesar el cuerpo de la respuesta JSON
            String jsonString = response.body();

            // Parsear el JSON usando Gson
            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(jsonString, JsonArray.class);
            JsonObject countryInfo = jsonArray.get(0).getAsJsonObject();
            JsonObject flags = countryInfo.getAsJsonObject("flags");

            String imgFlag = flags.get("png").getAsString();
            String countryAb = countryInfo.get("cca2").getAsString();

            FlagDtoResponse flagDto = new FlagDtoResponse(imgFlag, countryAb);
            
            return flagDto;
        } else {
            throw new IOException("Error al obtener la bandera: " + response.statusCode());
        }
    }
}
