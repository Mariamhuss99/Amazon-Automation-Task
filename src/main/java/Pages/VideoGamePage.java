package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class VideoGamePage {
    static WebDriver driver;
    HomePage homePage;

    private By seeMoreVideoGamesButton=By.cssSelector("span.a-size-medium.a-color-link.a-text-bold");
    private By sortByDropDown=By.className("a-dropdown-prompt");
    private By sortByHighToLowOption=By.id("s-result-sort-select_2");
    private By priceTextField=By.className("a-price-whole");
    private By goToPage2Button=By.cssSelector("a.s-pagination-item[aria-label='Go to page 2']");
    private By addToCartButton=By.id("add-to-cart-button");
    private By successMessage=  By.cssSelector("div.a-box.a-alert-inline.a-alert-inline-success.sw-atc-message");
    private By cartIcon= By.id("nav-cart-count");
    private By proceedToCheckOut =By.name("proceedToRetailCheckout");

    public VideoGamePage(WebDriver driver) {
        this.driver=driver;
        homePage= new HomePage(driver);
    }
    public WebElement cartIconButtonMethod(){
        return homePage.clickOnElementWhenClickable(cartIcon);
    }
    public WebElement proceedToCheckOutMethod(){
        return homePage.clickOnElementWhenClickable(proceedToCheckOut);
    }
    public WebElement successMessageMethod(){

        return waitUntilVisible(successMessage);
    }
    public static WebElement waitUntilVisible( By locator) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement addToCartButtonMethod(){
        return homePage.clickOnElementWhenClickable(addToCartButton);
    }
    public WebElement GoToPage2Method(){
        return homePage.clickOnElementWhenClickable(goToPage2Button);
    }

    public WebElement sortByDropDownMethod()
    {
        return homePage.clickOnElementWhenClickable(sortByDropDown);
    }
    public WebElement seeMoreVideoGamesButtonMethod(){

        return homePage.clickOnElementWhenClickable(seeMoreVideoGamesButton);
    }

    public void SortByOption(WebElement dropDown){
      dropDown.click();
    }
    public WebElement FromHighToLowSortElementMethod(){
        return homePage.clickOnElementWhenClickable(sortByHighToLowOption);
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
        homePage.clickOnElementWhenClickable(priceTextField);
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
            //homePage.ScrollUntilFindElement(elements.get(i));
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
