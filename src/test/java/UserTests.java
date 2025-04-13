import Api.BaseTest;
import Api.UserEndpoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.json.simple.JSONObject;

import org.testng.annotations.Test;

public class UserTests extends BaseTest {

     static String userId;

    @Test (priority = 1)
    public void createUserTest() {
        JSONObject creatuser = new JSONObject();
        creatuser.put("name","Mariam");
        creatuser.put("job","Tester eng");
        Response response = UserEndpoints.createUser(creatuser.toJSONString());

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("name"), creatuser.get("name"));
        Assert.assertEquals(response.jsonPath().getString("job"), creatuser.get("job"));
        System.out.println(response.jsonPath().getString("id"));
        userId = response.jsonPath().getString("id");
    }

    @Test(priority = 2,dependsOnMethods = "createUserTest")
    public void getUserTest() {
        Response response = UserEndpoints.getUser(userId);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 3) //to make it run after get the id without start all over the before class so id will be = null again
    public void updateUserTest() {
        JSONObject updatedUser = new JSONObject();
        updatedUser.put("job","Tester eng");
        Response response = UserEndpoints.updateUser(userId, updatedUser.toJSONString());

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("job"), updatedUser.get("job"));
    }

}
