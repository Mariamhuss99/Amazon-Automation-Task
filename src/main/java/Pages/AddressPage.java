package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressPage {
    WebDriver driver;
    HomePage homePage;
    private By addNewAdressButton= By.xpath("//*[@id=\"add-new-address-desktop-sasp-tango-link\"]/span/a");
    private By firstNameTextField=By.id("address-ui-widgets-enterAddressFullName");
    private By phoneNumberTextField=By.id("address-ui-widgets-enterAddressPhoneNumber");
    private By streetNameTextField=By.id("address-ui-widgets-enterAddressLine1");
    private By buildingNameTextField=By.id("address-ui-widgets-enter-building-name-or-number");
    private By cityTextField=By.id("address-ui-widgets-enterAddressCity");
    private By districtTextField=By.id("address-ui-widgets-enterAddressDistrictOrCounty");
    private By useThisAddressButton=By.id("checkout-primary-continue-button-id");
    private By autoCompleteField=By.id("address-ui-widgets-autoCompleteResult-0");
    private By layOut=By.id("/html/body/div[9]/div/div/div/div/div/form/div/div[1]/div/div[12]/input");
    public AddressPage(WebDriver driver) {
        this.driver=driver;
        homePage= new HomePage(driver);
    }
    public WebElement autoCompleteFieldMethod(){

        return homePage.clickOnElementWhenClickable(autoCompleteField);
    }
    public WebElement addNewAdressButtonMethod(){
        return homePage.clickOnElementWhenClickable(addNewAdressButton);
    }
    public WebElement phoneNumberTextFieldMethod(){
        return homePage.clickOnElementWhenClickable(phoneNumberTextField);
    }
    public WebElement firstNameTextFieldMethod(){
        return homePage.clickOnElementWhenClickable(firstNameTextField);
    }
    public WebElement streetNameTextFieldMethod(){
        return homePage.clickOnElementWhenClickable(streetNameTextField);
    }
    public WebElement buildingNameTextFieldMethod(){
        return homePage.clickOnElementWhenClickable(buildingNameTextField);
    }
    public WebElement cityTextFieldMethod(){
        return homePage.clickOnElementWhenClickable(cityTextField);
    }
    public WebElement districtTextFieldMethod(){
        return homePage.clickOnElementWhenClickable(districtTextField);
    }
    public WebElement useThisAddressButtonMethod(){
        return homePage.clickOnElementWhenClickable(useThisAddressButton);
    }
    public void clearAndFillTheTxtField(WebElement element,String text){
        element.clear();
        element.sendKeys(text);
    }



    public void AddNewAddressMethod() throws InterruptedException {
addNewAdressButtonMethod().click();
        clearAndFillTheTxtField(firstNameTextFieldMethod(),"Mariam Mahmoud");
        clearAndFillTheTxtField(phoneNumberTextFieldMethod(),"01069794877");
        clearAndFillTheTxtField(streetNameTextFieldMethod(),"Test");
        clearAndFillTheTxtField(buildingNameTextFieldMethod(),"TestBuilding");
    clearAndFillTheTxtField(cityTextFieldMethod(),"Cairo");

      clearAndFillTheTxtField(districtTextFieldMethod(),"1 (1st Settlement)");

        useThisAddressButtonMethod().click();




    }



}
