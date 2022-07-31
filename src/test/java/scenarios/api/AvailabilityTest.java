package scenarios.api;

import http.RpHttpClient;
import org.testng.annotations.Test;

class AvailabilityTest {

    @Test
    void serviceAvailableTest() {
        RpHttpClient apiClient = new RpHttpClient();
        apiClient.healthCheck();
    }
}
