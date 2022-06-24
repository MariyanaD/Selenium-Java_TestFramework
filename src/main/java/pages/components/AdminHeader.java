package pages.components;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;

public class AdminHeader {

    private static final By PROFILE_FULL_NAME_LINK = By.xpath("(//a[@class='dropdown-toggle'])[1]");

    /**
     * Assert that the provided account full n
     * ame is as expected on top-right corner in the admin area
     * in the Header
     * @param expectedAccountFullName the account full name you expect to be present in the top-right corner account area
     * @param messageOnFailure the message that will appear in your reports in case of assert failure
     */
    public static void verifyAccountFullName(String expectedAccountFullName, String messageOnFailure) {
        String actualAccountFullName = Browser.driver.findElement(PROFILE_FULL_NAME_LINK).getText();
        Assert.assertEquals(actualAccountFullName, expectedAccountFullName, messageOnFailure);
    }

    /**
     * Navigate to the account full name dropdown and choose one of the dropdown list.
     * @param expectedAccountDropdownPage the admin account page that appear in the top right side after clicking on the dropdown
     * @param messageOnFailure the message that will appear in your reports in case of assert failure
     */
    public static void goToAccountFullNameDropDownPage(String expectedAccountDropdownPage, String messageOnFailure) {
       Browser.driver.findElement(PROFILE_FULL_NAME_LINK).click();
    }

}
