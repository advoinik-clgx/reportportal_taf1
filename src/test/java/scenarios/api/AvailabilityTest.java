package scenarios.api;

import http.RpHttpClient;
import objects.users.DefaultSuperAdmin;
import org.testng.annotations.Test;

class AvailabilityTest {

    @Test(testName = "API health check")
    void serviceAvailableTest() {
        RpHttpClient apiClient = new RpHttpClient(new DefaultSuperAdmin());
        apiClient.healthCheck();
    }
}
