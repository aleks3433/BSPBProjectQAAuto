package pages;

import framework.BrowserManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        Actions moveToAccount = new Actions(BrowserManager.getBrowser());
        moveToAccount.moveToElement(account).build().perform();
        statement.click();
        return PageFactory.initElements(BrowserManager.getBrowser(), BSPBStatementPage.class);
    }

    public BSPBExchangePage hoverOnCurrencyAndClickOnExchange() {
        Actions moveToCurrency = new Actions(BrowserManager.getBrowser());
        moveToCurrency.moveToElement(currency).build().perform();
        exchange.click();
        return PageFactory.initElements(BrowserManager.getBrowser(), BSPBExchangePage.class);
    }

    public BSPBMessagesPage clickMessagesButton(){
        messagesButton.click();
        return PageFactory.initElements(BrowserManager.getBrowser(), BSPBMessagesPage.class);
    }

}
