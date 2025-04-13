package Api;

import io.restassured.response.Response;

public class UserEndpoints {
    public static Response createUser(String createUser) {

        return RestUtils.sendRequest("POST", "/users", createUser);
    }

    public static Response getUser(String id) {
        return RestUtils.sendRequest("GET", "/users/" + id, null);
    }

    public static Response updateUser(String id, String updateUser) {
        return RestUtils.sendRequest("PUT", "/users/" + id, updateUser);
    }

}
