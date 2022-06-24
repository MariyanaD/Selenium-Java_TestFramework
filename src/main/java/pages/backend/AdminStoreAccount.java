package pages.backend;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;

public class AdminStoreAccount {

    private final static String adminStorePageURL = "https://shop.pragmatic.bg";

    private static final By PROFILE_SHOP_PAGE_ACCOUNT_LINK = By.xpath("(//*[ contains (text(), 'My Account')])[1]");
    private static final By REGISTER_ACCOUNT_PAGE_LINK = By.xpath("(//*[ contains (text(), 'Register')])[1]");
    private static final By OPEN_REGISTER_ACCOUNT_PAGE = By.xpath("(//*[ contains (text(), 'Register Account')])[1]");

    public static void openMyStorePage() {
        Browser.driver.get(adminStorePageURL);
    }
    public static void verifyMyAccountStore(String expectedStorePageAccountName, String messageOnFailure) {
        String actualStorePageAccountName = Browser.driver.findElement(PROFILE_SHOP_PAGE_ACCOUNT_LINK).getText();
        Assert.assertEquals(actualStorePageAccountName, expectedStorePageAccountName, messageOnFailure);
    }
    public static void goToRegisterLink() {
        Browser.driver.findElement(PROFILE_SHOP_PAGE_ACCOUNT_LINK).click();
        Browser.driver.findElement(REGISTER_ACCOUNT_PAGE_LINK).click();
    }
    public static void verifyMyRegisterAccountPage(String expectedRegisterAccountPage, String messageOnFailure) {
        String actualRegisterAccountPage = Browser.driver.findElement(OPEN_REGISTER_ACCOUNT_PAGE).getText();
        Assert.assertEquals(actualRegisterAccountPage, expectedRegisterAccountPage, messageOnFailure);
    }
}
