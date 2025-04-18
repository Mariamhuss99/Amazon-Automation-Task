package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class AddressPage {
    WebDriver driver;
    HomePage homePage;
    WaitUtils waitUtils;
    private final By addNewAdressButton= By.xpath("//*[@id=\"add-new-address-desktop-sasp-tango-link\"]/span/a");
    private final By firstNameTextField=By.id("address-ui-widgets-enterAddressFullName");
    private final By phoneNumberTextField=By.id("address-ui-widgets-enterAddressPhoneNumber");
    private final By streetNameTextField=By.id("address-ui-widgets-enterAddressLine1");
    private final By buildingNameTextField=By.id("address-ui-widgets-enter-building-name-or-number");
    private final By cityTextField=By.id("address-ui-widgets-enterAddressCity");
    private final By districtTextField=By.id("address-ui-widgets-enterAddressDistrictOrCounty");
    private final By useThisAddressButton=By.id("checkout-primary-continue-button-id");
    private final By autoCompleteField=By.id("address-ui-widgets-autoCompleteResult-0");
    //private By layOut=By.id("/html/body/div[9]/div/div/div/div/div/form/div/div[1]/div/div[12]/input");
    public AddressPage(WebDriver driver) {
        this.driver=driver;
        homePage= new HomePage(driver);
        waitUtils= new WaitUtils(driver);
    }
    public WebElement autoCompleteFieldMethod(){

        return waitUtils.clickOnElementWhenClickable(autoCompleteField);
    }
    public WebElement addNewAdressButtonMethod(){
        return waitUtils.clickOnElementWhenClickable(addNewAdressButton);
    }
    public WebElement phoneNumberTextFieldMethod(){
        return waitUtils.clickOnElementWhenClickable(phoneNumberTextField);
    }
    public WebElement firstNameTextFieldMethod(){
        return waitUtils.clickOnElementWhenClickable(firstNameTextField);
    }
    public WebElement streetNameTextFieldMethod(){
        return waitUtils.clickOnElementWhenClickable(streetNameTextField);
    }
    public WebElement buildingNameTextFieldMethod(){
        return waitUtils.clickOnElementWhenClickable(buildingNameTextField);
    }
    public WebElement cityTextFieldMethod(){
        return waitUtils.clickOnElementWhenClickable(cityTextField);
    }
    public WebElement districtTextFieldMethod(){
        return waitUtils.clickOnElementWhenClickable(districtTextField);
    }
    public WebElement useThisAddressButtonMethod(){
        return waitUtils.clickOnElementWhenClickable(useThisAddressButton);
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
