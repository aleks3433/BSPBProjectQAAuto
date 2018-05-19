package pages;

import framework.BrowserManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BSPBPreviewExchangePage {

    @FindBy(id = "confirm")
    WebElement confirmButton;

    @FindBy(css = ".alert.alert-success")
    WebElement successAlert;

    @FindBy(id = "confirmation-frame")
    WebElement confirmationFrame;

    public BSPBPreviewExchangePage clickConfirm() {
        BrowserManager.getBrowser().switchTo().frame(confirmationFrame);
        confirmButton.click();
        return PageFactory.initElements(BrowserManager.getBrowser(), BSPBPreviewExchangePage.class);
    }

    public String getSuccessAlertText() {
        return successAlert.getText();
    }
}
