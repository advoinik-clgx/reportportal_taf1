package configuration;

public class Config {
    public static final String BASE_URL = System.getProperty("rp_endpoint", "http://localhost:8080/");
    public static final String DRIVER_NAME = System.getProperty("web_driver");
    public static final String BEARER_TOKEN = System.getenv("rp_bearer_token");

    private Config() {
    }
}
