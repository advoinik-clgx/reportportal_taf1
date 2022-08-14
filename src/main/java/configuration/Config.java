package configuration;

public class Config {
    public static final String BASE_URL = System.getProperty("rp_endpoint", "http://localhost:8080/");
    public static final String DRIVER_NAME = System.getProperty("web_driver");
    public static final String API_USER = System.getenv("rp_api_user");
    public static final String API_PASSWORD = System.getenv("rp_api_password");
    public static final String SELENOID_BASE_URL = "http://144.126.246.213:4444";
    public static final Boolean RUN_ON_SELENOID = System.getProperty("selenoid") != null;

    private Config() {
    }
}
