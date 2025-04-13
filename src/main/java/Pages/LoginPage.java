package Pages;

import org.openqa.selenium.*;

public class LoginPage {
    WebDriver driver;
    HomePage homePage;
    VideoGamePage videoGamePage;
    private By emailOrPhoneNumberTextField=By.id("ap_email_login");
    private By passwordTextField=By.id("ap_password");
    private By backToHomePageError=By.xpath("/html/body/center/p/b/a");


    public LoginPage(WebDriver driver) {
        this.driver=driver;
        homePage= new HomePage(driver);
videoGamePage= new VideoGamePage(driver);
    }

    public WebElement emailOrPhoneNumberMethod(){

        return homePage.clickOnElementWhenClickable(emailOrPhoneNumberTextField);
    }
    public WebElement passwordMethod(){

        return homePage.clickOnElementWhenClickable(passwordTextField);
    }
    public WebElement backToHomePageButtonErrorMethod(){

        return homePage.clickOnElementWhenClickable(backToHomePageError);
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

