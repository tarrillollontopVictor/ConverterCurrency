
package Service;

import Config.ApiConfig;
import Dtos.CountryDto;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IpDataUserService {
    
    private HttpClient hc;

    public IpDataUserService() {
        this.hc = HttpClient.newHttpClient();
    }
    
    public CountryDto getLocation(){
        
        try {
            String url = ApiConfig.getAPI_IP_USER();
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            
            HttpResponse<String>response = hc.send(request, HttpResponse.BodyHandlers.ofString());
            
            Gson gson = new Gson();
            
            CountryDto location = gson.fromJson(response.body(), CountryDto.class);
            
            System.out.println(location);
            
            return location;
            
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(IpDataUserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
        
        
        
    }
    
    
}
