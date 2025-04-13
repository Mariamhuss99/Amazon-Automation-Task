import Pages.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateOrdertests extends BaseClass {
    private HomePage homePage;
    private VideoGamePage videoGamePage;
    private  LoginPage loginPage;
    private AddressPage addressPage;
    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get("https://www.amazon.eg/-/en/");
     homePage= new HomePage(driver);
     videoGamePage = new VideoGamePage(driver);
       loginPage= new LoginPage(driver);
addressPage= new AddressPage(driver);
    }
    @Test
    public void checkoutVideoGamesOrderSuccessfully() throws InterruptedException {
//test steps to create order
        homePage.AllButtonMethod().click();
        homePage.SeeMoreButtonMethod().click();
       homePage.ScrollUntilFindElement(homePage.VideoGameButtonMethod());
        homePage.VideoGameButtonMethod().click();
        homePage.AllVideoGamesButtomMethod().click();
        homePage.ScrollUntilFindElement(videoGamePage.seeMoreVideoGamesButtonMethod());
        videoGamePage.seeMoreVideoGamesButtonMethod().click();
        videoGamePage.FilterByFreeDeliveryMethod().click();
       // videoGamePage.ConditionNewFilterMethod().click();
        videoGamePage.sortByDropDownMethod().click();
        videoGamePage.SortByOption(videoGamePage.FromHighToLowSortElementMethod());
 videoGamePage.AddItemsToCart( videoGamePage.getItemsUnderThreshold(15000));
videoGamePage.cartIconButtonMethod().click();
videoGamePage.proceedToCheckOutMethod().click();
loginPage.LoginMethod("01069794877","Mariam123?");
addressPage.AddNewAddressMethod();

    }
@AfterTest
    public void tearDown(){
        driver.quit();
}

}
