package pages;

import framework.BrowserManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BSPBLoginPage {

    @FindBy (id = "login-button")
    WebElement loginButton;

    @FindBy (id = "login-otp-button")
    WebElement loginOtpButton;

    public BSPBLoginPage clickLoginButton(){
        loginButton.click();
        return PageFactory.initElements(BrowserManager.getBrowser(), BSPBLoginPage.class);
    }

    public BSPBProfilePage clickLoginOtpButton(){
        loginOtpButton.click();
        return PageFactory.initElements(BrowserManager.getBrowser(), BSPBProfilePage.class);
    }

}
