package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    public WebElement waitForElementPresent(WebElement webElement) {
        return new WebDriverWait(BrowserManager.getBrowser(), 5, 1000)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public void clickWithJS(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor) BrowserManager.getBrowser();
        executor.executeScript("arguments[0].click();", webElement);
    }

    public static void moveToWebElement(WebElement webElement) {
        Actions moveToWebElement = new Actions(BrowserManager.getBrowser());
        moveToWebElement.moveToElement(webElement).build().perform();
    }
}
