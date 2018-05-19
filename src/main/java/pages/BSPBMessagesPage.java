package pages;

import framework.BrowserManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BSPBMessagesPage {

    @FindBy(id = "new-message-btn")
    WebElement newMessageButton;

    @FindBy(xpath = "//textarea")
    WebElement messageField;

    @FindBy(id = "send-button")
    WebElement sendButton;

    @FindBy(id = "messages")
    WebElement messagesTable;

    public BSPBMessagesPage clickNewMessageButton() {
        newMessageButton.click();
        return PageFactory.initElements(BrowserManager.getBrowser(), BSPBMessagesPage.class);
    }

    public BSPBMessagesPage inputMessage(String message) {
        messageField.sendKeys(message);
        return PageFactory.initElements(BrowserManager.getBrowser(), BSPBMessagesPage.class);
    }

    public BSPBMessagesPage clickSendButton() {
        sendButton.click();
        return PageFactory.initElements(BrowserManager.getBrowser(), BSPBMessagesPage.class);
    }

    public String getMessagesTableText() {
        return messagesTable.getText();
    }
}
