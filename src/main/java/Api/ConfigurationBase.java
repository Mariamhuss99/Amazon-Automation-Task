package Api;

public class ConfigurationBase {
    private static String baseUrl = "https://reqres.in/api"; // default value

    public static String getBaseUrl() {
        return baseUrl;
    }
    
}
