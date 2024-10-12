
package Dtos;

import com.google.gson.annotations.SerializedName;

public record CurrencyResponse(
        
        String countryImg,
        @SerializedName("conversion_result")
        double money
        
        ) {

}
