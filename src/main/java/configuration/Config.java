package configuration;

public class Config {
    public static final String BASE_URL = System.getProperty("rp_endpoint", "http://localhost:8080/");
    public static final Environment ENV = BASE_URL.matches("\\w+://localhost:.*")
            ? Environment.LOCAL
            : Environment.REMOTE;
    public static final String DRIVER_NAME = System.getProperty("web_driver");
    public static final String API_TOKEN = System.getenv("api_token");
    public static final String RP_LOGIN = System.getenv("RP_LOGIN");
    public static final String RP_PASSWORD = System.getenv("RP_PASSWORD");

    private Config() {
    }
}
