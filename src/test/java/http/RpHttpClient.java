package http;

import configuration.Config;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RpHttpClient {
    private static final String API_URL = "%sapi/v1/".formatted(Config.BASE_URL);
    private static final String API_TOKEN = Config.API_TOKEN;
    private static final RequestSpecification serviceRequestSpec = serviceRequestSpec();

    private static RequestSpecification serviceRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(API_URL)
                .build();
    }

    public void healthCheck() {
        RestAssured.given(serviceRequestSpec)
                .basePath("project/analyzer/status")
                .param("access_token", API_TOKEN)
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200);
    }
}
