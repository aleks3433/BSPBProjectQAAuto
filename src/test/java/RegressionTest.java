import framework.BrowserManager;
import framework.Navigation;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BSPBMessagesPage;
import pages.BSPBPreviewExchangePage;
import pages.BSPBProfilePage;
import pages.BSPBStatementPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class RegressionTest {

    String messageText = "This is a test message";

    @BeforeTest
    public void openBrowser() {
        BrowserManager.openBrowser();
    }

    @Test
    public void testLogin() {
        BSPBProfilePage bspbProfilePage = Navigation.openBSPBLoginPage()
                .clickLoginButton()
                .clickLoginOtpButton();
        assertEquals(bspbProfilePage.getProfileName(), "Королёва Ольга", "Name should be correct");
    }

    @Test
    public void testPositiveClosingBalance() {
        BSPBStatementPage bspbStatementPage = Navigation.openBSPBLoginPage()
                .clickLoginButton()
                .clickLoginOtpButton()
                .hoverOnAccountAndClickOnStatement();
        assertTrue(bspbStatementPage.isClosingBalanceGraterThanZero(), "Closing balance should be greater than zero");
    }

    @Test
    public void testCurrencyExchange(){
        BSPBPreviewExchangePage bspbPreviewExchangePage = Navigation.openBSPBLoginPage()
                .clickLoginButton()
                .clickLoginOtpButton()
                .hoverOnCurrencyAndClickOnExchange()
                .selectDollarAccountForSale()
                .inputAmountForSale("100")
                .selectRubleAccountForEnrollment()
                .inputPaymentDetails("Some details")
                .clickCalculateButton()
                .clickConfirm();
        assertEquals(bspbPreviewExchangePage.getSuccessAlertText(), "Перевод выполнен!", "Alert text should be correct");
    }

    @Test
    public void testMessagesHistory(){
        BSPBMessagesPage bspbMessagesPage = Navigation.openBSPBLoginPage()
                .clickLoginButton()
                .clickLoginOtpButton()
                .clickMessagesButton()
                .clickNewMessageButton()
                .inputMessage(messageText)
                .clickSendButton();
        assertTrue(bspbMessagesPage.getMessagesTableText().contains(messageText), "Text should have message");
    }

    @AfterTest
    public void closeBrowser() {
        BrowserManager.closeBrowser();
    }
}
