package pages.frontend;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;

public class NewUserAccount {
    private static final By SUCCESSFUL_USER_ACCOUNT_PAGE = By.xpath("(//*[ contains (text(), 'Your Account Has Been " +
            "Created!')])[1]");

    /**
     * Assert that the provided account full name is as expected on top-right corner in the admin area in the Header
     *
     * @param expectedUserRegisterAccount the user account successful message you expect to be present
     * @param messageOnFailure the message that will appear in your reports in case of assert failure
     */

    public static void verifyUserRegisterAccount(String expectedUserRegisterAccount, String messageOnFailure) {
        String actualUserRegisterAccount = Browser.driver.findElement(SUCCESSFUL_USER_ACCOUNT_PAGE).getText();
        Assert.assertEquals(actualUserRegisterAccount, expectedUserRegisterAccount, messageOnFailure);
    }
}
