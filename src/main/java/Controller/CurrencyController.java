
package Controller;

import Dtos.CurrencyRequest;
import Dtos.CurrencyResponse;
import Service.CurrencyApiService;


public class CurrencyController {
 
    public CurrencyResponse convertCurrency(CurrencyRequest currencyRequest){
        CurrencyApiService apiService = new CurrencyApiService();
        return apiService.convertCurrency(currencyRequest);
    }
    
    
    
    
}
