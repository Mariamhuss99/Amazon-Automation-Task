package Pages;

import org.openqa.selenium.*;
import utils.WaitUtils;

public class LoginPage {
    WebDriver driver;
    HomePage homePage;
    VideoGamePage videoGamePage;
    WaitUtils waitUtils;
    private final By emailOrPhoneNumberTextField=By.id("ap_email_login");
    private final By passwordTextField=By.id("ap_password");
    private final By backToHomePageError=By.xpath("/html/body/center/p/b/a");


    public LoginPage(WebDriver driver) {
        this.driver=driver;
        homePage= new HomePage(driver);
        videoGamePage= new VideoGamePage(driver);
        waitUtils = new WaitUtils(driver);
    }

    public WebElement emailOrPhoneNumberMethod(){

        return waitUtils.clickOnElementWhenClickable(emailOrPhoneNumberTextField);
    }
    public WebElement passwordMethod(){

        return waitUtils.clickOnElementWhenClickable(passwordTextField);
    }
    public WebElement backToHomePageButtonErrorMethod(){

        return waitUtils.clickOnElementWhenClickable(backToHomePageError);
    }





    public void LoginMethod(String emailOrPhonNumber,String password){
        emailOrPhoneNumberMethod().clear();
        emailOrPhoneNumberMethod().sendKeys(emailOrPhonNumber);
        emailOrPhoneNumberMethod().sendKeys(Keys.ENTER);
        passwordMethod().clear();
        passwordMethod().sendKeys(password);
        passwordMethod().sendKeys(Keys.ENTER);
HandleTheLoginException();
    }
    public void HandleTheLoginException(){
        while (true) {
            try {

                backToHomePageButtonErrorMethod().click();
                System.out.println("Element found and clicked!");
                videoGamePage.cartIconButtonMethod().click();
                videoGamePage.proceedToCheckOutMethod().click();
                break;
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Element not found so it login successfully with no exceptions");
                break;

            }
        }
    }
    }

