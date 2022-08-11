package scenarios;

import http.RpHttpClient;
import lombok.extern.slf4j.Slf4j;
import objects.users.DefaultSuperAdmin;
import org.testng.annotations.BeforeTest;

@Slf4j
public class Base {
    @BeforeTest
    public void setup() {
        RpHttpClient apiClient = new RpHttpClient(new DefaultSuperAdmin());
        apiClient.healthCheck();
    }
}
