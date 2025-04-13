package Api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestUtils {

    public static Response sendRequest(String method, String endpoint, Object body) {
        switch (method) {
            case "POST":
                return given()
                        .contentType("application/json")
                        .body(body)
                        .when()
                        .post(endpoint);

            case "PUT":
                return given()
                        .contentType("application/json")
                        .body(body)
                        .when()
                        .put(endpoint);

            case "GET":
                return given()
                        .when()
                        .get(endpoint);



            default:
                throw new IllegalArgumentException("Invalid HTTP method: " + method);
        }
    }
}
