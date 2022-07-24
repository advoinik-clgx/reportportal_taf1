package scenarios;

import http.RpHttpClient;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    @BeforeSuite
    public static void setup() {
        RpHttpClient apiClient = new RpHttpClient();
        apiClient.healthCheck();
    }

}
