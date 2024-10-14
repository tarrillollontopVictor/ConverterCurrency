
package Controller;

import Dtos.CountryDto;
import Dtos.FlagDtoResponse;
import Service.FlagService;
import Service.IpDataUserService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountryController {
    
    public FlagDtoResponse getFlag(){
        
        try {
            IpDataUserService ipData = new IpDataUserService();
            CountryDto cd = ipData.getLocation();
            FlagService flagService = new FlagService();
            return flagService.getFlagByCountry(cd);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(CountryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
