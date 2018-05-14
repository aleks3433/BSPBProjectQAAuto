package framework;

import org.openqa.selenium.support.PageFactory;
import pages.BSPBLoginPage;

public class Navigation {

    public static BSPBLoginPage openBSPBLoginPage(){
        BrowserManager.getBrowser().get("https://idemo.bspb.ru");
        return PageFactory.initElements(BrowserManager.getBrowser(), BSPBLoginPage.class);
    }
}
