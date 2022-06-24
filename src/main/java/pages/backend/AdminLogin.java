package pages.backend;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;

public class AdminLogin {
private final static String adminLoginPageURL = "http://shop.pragmatic.bg/admin";

private static final By USERNAME_INPUT_FIELD = By.id("input-username");
private static final By PASSWORD_INPUT_FIELD = By.id("input-password");
private static final By LOGIN_BUTTON = By.cssSelector(".btn-primary");
private static final By LOGIN_FORM_VALIDATION_MESSAGE = By.cssSelector((".alert-danger"));
private static final By LOGIN_FORM_VALIDATION_ATTEMPTS_MESSAGE =
                     By.xpath(("//div[@class=\"alert alert-danger alert-dismissible\"]"));

    /**
     * Opens the admin login area of shop.pragmatic.bg/admin
     */
    public static void open() {
        Browser.driver.get(adminLoginPageURL);
    }

    /**
     * Logs in into the admin login area with the provided credentials (it also clicks the LOGIN button).
     * @param username the username you would like to login with
     * @param password the password you would like to login with
     */
    public static void login(String username, String password) {
     Browser.driver.findElement(USERNAME_INPUT_FIELD).sendKeys(username);
     Browser.driver.findElement(PASSWORD_INPUT_FIELD).sendKeys(password);
     Browser.driver.findElement(LOGIN_BUTTON).click();
    }

    /**
     * Assert that the shown validation message is as expected
     * @param expectedLoginFormValidationMessage the login form validation message you expect
     * @param messageOnFailure the message that will appear in your reports in case of assert failure
     */
    public static void verifyLoginFormValidationMessage(String expectedLoginFormValidationMessage,
                                                        String messageOnFailure) {
        String actualLoginFormValidationMessage =
                Browser.driver.findElement(LOGIN_FORM_VALIDATION_MESSAGE).getText();
        Assert.assertTrue(actualLoginFormValidationMessage.contains(expectedLoginFormValidationMessage),
                messageOnFailure);
    }

    public static void verifyLoginFormValidationAttemptMessage(String expectedLoginFormValidationAttemptMessage,
                                                               String messageOnFailure) {
        String actualLoginFormValidationAttemptMessage =
                Browser.driver.findElement(LOGIN_FORM_VALIDATION_ATTEMPTS_MESSAGE).getText();
        Assert.assertTrue(actualLoginFormValidationAttemptMessage.contains(expectedLoginFormValidationAttemptMessage),
                messageOnFailure);
    }
}
