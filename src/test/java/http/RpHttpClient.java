package http;

import configuration.Config;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import objects.users.User;
import org.testng.Assert;

public class RpHttpClient {
    private static final RequestSpecification serviceRequestSpec = RpHttpRequestSpecManager.serviceRequestSpec();
    private final String bearerToken;

    public RpHttpClient(User user) {
        this.bearerToken = new RpHttpTokenManager().obtainBearerToken(user);
    }

    public void healthCheck() {
        RestAssured.given(serviceRequestSpec)
                .basePath("project/analyzer/status")
                .when()
                .header("Authorization", this.bearerToken)
                .get()
                .then()
                .assertThat()
                .statusCode(200);
    }

    public void pingHost() {
        int pingStatusCode = RestAssured
                .given()
                .baseUri(Config.BASE_URL)
                .when()
                .get()
                .then()
                .extract()
                .statusCode();

        Assert.assertEquals(pingStatusCode, 200,
                "Pinging Report Portal server, it should return status code 200, but returned %s"
                        .formatted(pingStatusCode));
    }
}
