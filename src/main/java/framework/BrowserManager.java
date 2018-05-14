package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserManager {

    private static ThreadLocal<WebDriver> browser = new ThreadLocal<>();

    public static WebDriver getBrowser() {
        return browser.get();
    }

    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:/Webdrivers/chromedriver.exe");
        browser.set(new ChromeDriver());
        browser.get().manage().window().maximize();
        browser.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void closeBrowser(){
        browser.get().quit();
    }

}
