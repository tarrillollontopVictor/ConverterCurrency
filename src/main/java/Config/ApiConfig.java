package Config;

public class ApiConfig {

    private static final String API_GET_COUNTRY_CONVERT = "https://v6.exchangerate-api.com/v6/e1a9d5c6a11b78dfeb1f040b/pair/";
    private static final String API_GET_CURRENCY_CODE = "https://v6.exchangerate-api.com/v6/e1a9d5c6a11b78dfeb1f040b/latest/";
    private static final String API_IP_USER = "http://ip-api.com/json/";
    private static final String API_GET_FLAG = "https://restcountries.com/v3.1/name/";

    public static String getAPI_GET_CURRENCY_CODE() {
        return API_GET_CURRENCY_CODE;
    }

    public static String getAPI_GET_COUNTRY_CONVERT() {
        return API_GET_COUNTRY_CONVERT;
    }

    public static String getAPI_IP_USER() {
        return API_IP_USER;
    }

    public static String getAPI_GET_FLAG() {
        return API_GET_FLAG;
    }
    
    
}
