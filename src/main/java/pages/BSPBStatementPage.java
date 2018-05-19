package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BSPBStatementPage {

    @FindBy(xpath = "//tr[@id='closing-balance-row']/th[@class='right amount']")
    WebElement closingBalance;

    public boolean isClosingBalanceGraterThanZero() {
        return Double.parseDouble(closingBalance.getText().replaceAll("\\s", "")) > 0;
    }
}
