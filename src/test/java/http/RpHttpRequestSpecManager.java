package http;

import configuration.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RpHttpRequestSpecManager {
    private static final String API_URL = "%sapi/v1/".formatted(Config.BASE_URL);
    private static final String OAUTH_TOKEN_URL = "%suat/sso/oauth/token".formatted(Config.BASE_URL);

    static RequestSpecification serviceRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(API_URL)
                .build();
    }

    static RequestSpecification oauthTokenRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(OAUTH_TOKEN_URL)
                .build()
                .auth().basic(Config.API_USER, Config.API_PASSWORD);
    }
}
