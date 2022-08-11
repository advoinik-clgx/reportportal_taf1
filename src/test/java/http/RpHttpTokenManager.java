package http;

import configuration.Config;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import objects.users.User;

public class RpHttpTokenManager {
    private static final RequestSpecification oauthTokenRequestSpec = RpHttpRequestSpecManager.oauthTokenRequestSpec();

    public String obtainBearerToken(User user) {
        checkCredentials();

        String token = RestAssured.given(oauthTokenRequestSpec)
                .when()
                .contentType(ContentType.URLENC)
                .formParam("grant_type", "password")
                .formParam("username", user.getLogin())
                .formParam("password", user.getPassword())
                .post()
                .then()
                .statusCode(200)
                .and()
                .extract()
                .jsonPath()
                .getString("access_token");

        return "bearer %s".formatted(token);
    }

    private void checkCredentials() {
        if (Config.API_USER == null || Config.API_PASSWORD == null) {
            throw new IllegalArgumentException("rp_api_password and rp_api_user=ui environment variables are not defined. " +
                    "Please refer Readme.MD to fix it");
        }
    }
}
