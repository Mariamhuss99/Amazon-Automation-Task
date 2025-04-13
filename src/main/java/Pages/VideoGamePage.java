package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.WaitUtils;

import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class VideoGamePage {
    static WebDriver driver;
    HomePage homePage;
    WaitUtils waitUtils;

    private final By seeMoreVideoGamesButton=By.cssSelector("span.a-size-medium.a-color-link.a-text-bold");
    private final By sortByDropDown=By.className("a-dropdown-prompt");
    private final By sortByHighToLowOption=By.id("s-result-sort-select_2");
    private final By priceTextField=By.className("a-price-whole");
    private final By goToPage2Button=By.cssSelector("a.s-pagination-item[aria-label='Go to page 2']");
    private final By addToCartButton=By.id("add-to-cart-button");
    private final By successMessage=  By.cssSelector("div.a-box.a-alert-inline.a-alert-inline-success.sw-atc-message");
    private final By cartIcon= By.id("nav-cart-count");
    private final By proceedToCheckOut =By.name("proceedToRetailCheckout");
    private final By FilterByFreeDelivery=By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div/span/div/div[2]/div[2]/ul[1]/span/span/li/span/a/div[1]/label/i");
private final By ConditionNewFilter=By.xpath("//span[text()='New']/ancestor::a");
    public VideoGamePage(WebDriver driver) {
        this.driver=driver;
        homePage= new HomePage(driver);
        waitUtils= new WaitUtils(driver);
    }
    public WebElement ConditionNewFilterMethod(){

        return waitUtils.clickOnElementWhenClickable(ConditionNewFilter);
    }
    public WebElement cartIconButtonMethod(){
        return waitUtils.clickOnElementWhenClickable(cartIcon);
    }
    public WebElement FilterByFreeDeliveryMethod(){

        return waitUtils.clickOnElementWhenClickable(FilterByFreeDelivery);
    }


    public WebElement proceedToCheckOutMethod(){
        return waitUtils.clickOnElementWhenClickable(proceedToCheckOut);
    }
    public WebElement successMessageMethod(){

        return waitUtils.waitUntilVisible(successMessage);
    }

    public WebElement addToCartButtonMethod(){
        return waitUtils.clickOnElementWhenClickable(addToCartButton);
    }
    public WebElement GoToPage2Method(){
        return waitUtils.clickOnElementWhenClickable(goToPage2Button);
    }

    public WebElement sortByDropDownMethod()
    {
        return waitUtils.clickOnElementWhenClickable(sortByDropDown);
    }
    public WebElement seeMoreVideoGamesButtonMethod(){

        return waitUtils.clickOnElementWhenClickable(seeMoreVideoGamesButton);
    }

    public void SortByOption(WebElement dropDown){
      dropDown.click();
    }
    public WebElement FromHighToLowSortElementMethod(){
        return waitUtils.clickOnElementWhenClickable(sortByHighToLowOption);
    }
    public List<WebElement> getItemsUnderThreshold(int threshold) {
        List<WebElement> itemsUnderThreshold = findItemsUnderThresholdOnPage(threshold);

        if (itemsUnderThreshold.isEmpty()) {
            GoToPage2Method().click();
            itemsUnderThreshold = findItemsUnderThresholdOnPage(threshold);
        }

        return itemsUnderThreshold;
    }

    private List<WebElement> findItemsUnderThresholdOnPage(int threshold) {
        waitUtils.clickOnElementWhenClickable(priceTextField);
        List<WebElement> prices = driver.findElements(priceTextField);
        List<WebElement> itemsUnderThreshold = new ArrayList<>();

        for (WebElement priceElement : prices) {
            String priceText = priceElement.getText().replaceAll("[^\\d.]", "");
            if (!priceText.isEmpty()) {
                double price = Double.parseDouble(priceText);
                if (price < threshold) {
                    itemsUnderThreshold.add(priceElement);
                }
            }
        }

        return itemsUnderThreshold;
    }
    public void AddItemsToCart(List<WebElement>elements){
        int i = 0;
        while (i < elements.size()) {
            try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((priceTextField)));
            System.out.println(elements);
            elements.get(i).click();
            addToCartButtonMethod().click();
            successMessageMethod().isDisplayed();
            driver.navigate().back();
            driver.navigate().back();
            i++;
            } catch (StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException caught at index " + i + ", retrying...");
                break;

            }
        }

    }
   /* public List<WebElement> GetThePriceUserNeed(int threshold){
homePage.clickOnElementWhenClickable(priceTextField);
        List<WebElement> prices=driver.findElements(priceTextField);
        List<WebElement>itemsUnderThreshold= new ArrayList<>();;
        for (int i=0;i<prices.size();i++)
        {
            String priceText = prices.get(i).getText().replaceAll("[^\\d.]", "");
            if (!priceText.isEmpty()) {
                double price = Double.parseDouble(priceText);
                if (price < threshold) {

                    itemsUnderThreshold.add(prices.get(i));
                        if (itemsUnderThreshold.isEmpty()) {
                            GoToPage2Method().click();
                            List<WebElement> prices=driver.findElements(priceTextField);
                            List<WebElement>itemsUnderThreshold= new ArrayList<>();;
                            for (int i=0;i<prices.size();i++)
                            {
                                String priceText = prices.get(i).getText().replaceAll("[^\\d.]", "");
                                if (!priceText.isEmpty()) {
                                    double price = Double.parseDouble(priceText);
                                    if (price < threshold) {

                                        itemsUnderThreshold.add(prices.get(i));

                                    }


                    //  System.out.println("Item under threshold: $" + price);

        }

    }

}
       return itemsUnderThreshold;*/
    }
