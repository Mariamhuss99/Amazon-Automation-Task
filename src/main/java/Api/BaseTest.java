package Api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = ConfigurationBase.getBaseUrl();
    }

}
