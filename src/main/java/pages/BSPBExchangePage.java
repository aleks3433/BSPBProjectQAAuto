package pages;

import framework.BrowserManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BSPBExchangePage {

    @FindBy(id = "acc1")
    WebElement debitAccountSelection;

    @FindBy(id = "from-amount")
    WebElement amountForSale;

    @FindBy(id = "acc2")
    WebElement enrollAccountSelection;

    @FindBy(className = "span7")
    WebElement paymentDetails;

    @FindBy(id = "forward")
    WebElement calculateButton;

    public BSPBExchangePage selectDollarAccountForSale() {
        Select debitAccount = new Select(debitAccountSelection);
        debitAccount.selectByIndex(3);
        return PageFactory.initElements(BrowserManager.getBrowser(), BSPBExchangePage.class);
    }

    public BSPBExchangePage inputAmountForSale(String amount) {
        amountForSale.sendKeys(amount);
        return PageFactory.initElements(BrowserManager.getBrowser(), BSPBExchangePage.class);
    }

    public BSPBExchangePage selectRubleAccountForEnrollment() {
        Select enrollmentAccount = new Select(enrollAccountSelection);
        enrollmentAccount.selectByIndex(1);
        return PageFactory.initElements(BrowserManager.getBrowser(), BSPBExchangePage.class);
    }

    public BSPBExchangePage inputPaymentDetails(String paymentDetailsText) {
        paymentDetails.sendKeys(paymentDetailsText);
        return PageFactory.initElements(BrowserManager.getBrowser(), BSPBExchangePage.class);
    }

    public BSPBPreviewExchangePage clickCalculateButton() {
        calculateButton.click();
        return PageFactory.initElements(BrowserManager.getBrowser(), BSPBPreviewExchangePage.class);
    }
}
