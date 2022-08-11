package scenarios.api;

import http.RpHttpClient;
import objects.users.DefaultSuperAdmin;
import org.testng.annotations.Test;

class AvailabilityTest {

    @Test
    void serviceAvailableTest() {
        RpHttpClient apiClient = new RpHttpClient(new DefaultSuperAdmin());
        apiClient.healthCheck();
    }
}
