package Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.awt.SystemColor.scrollbar;

public class HomePage {
WebDriver driver;
    private By allButton= By.className("hm-icon-label");
   private By seeMoreButton=  By.xpath("//*[@id=\"hmenu-content\"]/div[1]/section[3]/ul/li[5]/a[1]/i");
private By videoGameButton=By.xpath("//*[@id=\"hmenu-content\"]/div[1]/section[3]/ul/ul/li[10]/a/i");
private By allVideoGamesButton=By.xpath("//*[@id=\"hmenu-content\"]/div[32]/section/ul/li[1]/a");

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement clickOnElementWhenClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    return element;
    }

    public WebElement AllButtonMethod() throws InterruptedException {
        return driver.findElement(allButton);
    }

public WebElement SeeMoreButtonMethod(){
        return clickOnElementWhenClickable(seeMoreButton);}

public WebElement VideoGameButtonMethod(){

    return clickOnElementWhenClickable(videoGameButton);
}
public void ScrollUntilFindElement(WebElement webElement){
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true);", webElement);
}
public WebElement AllVideoGamesButtomMethod(){

    return clickOnElementWhenClickable(allVideoGamesButton);
}


}