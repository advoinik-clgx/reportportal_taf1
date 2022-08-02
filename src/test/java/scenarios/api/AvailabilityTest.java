package scenarios.api;

import http.RpHttpClient;
import org.testng.annotations.Test;

class AvailabilityTest extends BaseApi {

    @Test(testName = "API health check")
    void serviceAvailableTest() {
        RpHttpClient apiClient = new RpHttpClient();
        apiClient.healthCheck();
    }
}
