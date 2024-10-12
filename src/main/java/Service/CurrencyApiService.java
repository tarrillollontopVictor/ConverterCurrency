
package Service;

import Config.ApiConfig;
import Dtos.CurrencyRequest;
import Dtos.CurrencyResponse;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CurrencyApiService {
    
    
    private final HttpClient client;

    public CurrencyApiService() {
        this.client = HttpClient.newHttpClient();
    }
    
    public CurrencyResponse convertCurrency(CurrencyRequest currencyRequest){
        
        try {
            String url = ApiConfig.getAPI_GET_COUNTRY_CONVERT()+currencyRequest.currencyCode1()+"/"+currencyRequest.currencyCode2()+"/"+currencyRequest.money();
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            Gson gson = new Gson();
            
            return gson.fromJson(response.body(), CurrencyResponse.class);
            
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(CurrencyApiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    
    
    
}
