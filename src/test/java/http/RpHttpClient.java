package http;

import configuration.Config;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RpHttpClient {

    public RpHttpClient(){}

    private static final String API_URL = Config.BASE_URL.endsWith("/")
            ? "%sapi/v1/".formatted(Config.BASE_URL)
            : "%s/api/v1/".formatted(Config.BASE_URL);
    private final RequestSpecification serviceRequestSpec = serviceRequestSpec();

    private RequestSpecification serviceRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(API_URL)
                .build()
                .header("Authorization", Config.BEARER_TOKEN);
    }

    @Step("API health check. Call project/analyzer/status")
    public void healthCheck() {
        RestAssured.given(serviceRequestSpec)
                .basePath("project/analyzer/status")
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200);
    }
}
