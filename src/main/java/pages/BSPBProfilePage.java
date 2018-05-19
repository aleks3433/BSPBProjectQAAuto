package pages;

import framework.BrowserManager;
import framework.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BSPBProfilePage {

    @FindBy(css = ".filter-option.pull-left")
    WebElement profileName;

    @FindBy(id = "accounts-index")
    WebElement account;

    @FindBy(id = "statements-statement")
    WebElement statement;

    @FindBy(id = "currency-rates")
    WebElement currency;

    @FindBy(id = "currencyExchange")
    WebElement exchange;

    @FindBy(id = "messages-button")
    WebElement messagesButton;

    public String getProfileName() {
        return profileName.getText();
    }

    public BSPBStatementPage hoverOnAccountAndClickOnStatement() {
        Utils.moveToWebElement(account);
        statement.click();
        return PageFactory.initElements(BrowserManager.getBrowser(), BSPBStatementPage.class);
    }

    public BSPBExchangePage hoverOnCurrencyAndClickOnExchange() {
        Utils.moveToWebElement(currency);
        exchange.click();
        return PageFactory.initElements(BrowserManager.getBrowser(), BSPBExchangePage.class);
    }

    public BSPBMessagesPage clickMessagesButton() {
        messagesButton.click();
        return PageFactory.initElements(BrowserManager.getBrowser(), BSPBMessagesPage.class);
    }

}
