package pages.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Browser;

public class UserRegisterPage {
    private final static String adminRegisterPageURL = "https://shop.pragmatic.bg/index.php?route=account/register";
    private static final By FIRST_NAME_INPUT_FIELD = By.id("input-firstname");
    private static final By LAST_NAME_INPUT_FIELD = By.id("input-lastname");
    private static final By EMAIL_FIELD = By.id("input-email");
    private static final By TELEPHONE_FIELD = By.id("input-telephone");
    private static final By PASSWORD_INPUT_FIELD = By.id("input-password");
    private static final By PASSWORD_CONFIRM_FIELD = By.id("input-confirm");
    private static final By SUBSCRIBE_RADIO_BUTTON_1 = By.xpath("(//input[@checked='checked'])[1]");
    private static final By SUBSCRIBE_RADIO_BUTTON_2 = By.xpath("(//input[@value='0'])[1]");
    private static final By PRIVACY_POLICY_CHECKBOX = By.xpath("//input[@name='agree']");
    private static final By CONTINUE_BUTTON = By.xpath("//input[@type='submit']");
    private static final By REGISTER_FORM_VALIDATION_MESSAGE = By.xpath("//*[ contains (text(), 'E-Mail Address does " +
            "not appear to be valid!')]");


    /**
     * Opens the user register area of https://shop.pragmatic.bg/index.php?route=account/register
     */
    public static void open() {
        Browser.driver.get(adminRegisterPageURL);
         }

    /**
     * Logs in into the admin login area with the provided credentials (it also clicks the LOGIN button).
     * @param firstname the firstname you would like to register with
     * @param lastname  the lastname you would like to register with
     * @param email the email you would like to register with
     * @param telephone the telephone you would like to register with
     * @param password the password you would like to register with
     * @param passwordConfirm the password confirmation you would like to register with
     */

    public static void fillRegisterForm (String firstname, String lastname, String email, String telephone, String
            password, String passwordConfirm) {
        Browser.driver.findElement(FIRST_NAME_INPUT_FIELD).sendKeys(firstname);
        Browser.driver.findElement(LAST_NAME_INPUT_FIELD).sendKeys(lastname);
        Browser.driver.findElement(EMAIL_FIELD).sendKeys(email);
        Browser.driver.findElement(TELEPHONE_FIELD).sendKeys(telephone);
        Browser.driver.findElement(PASSWORD_INPUT_FIELD).sendKeys(password);
        Browser.driver.findElement(PASSWORD_CONFIRM_FIELD).sendKeys(passwordConfirm);
        Browser.driver.findElement(SUBSCRIBE_RADIO_BUTTON_1).click();
        //System.out.println(SUBSCRIBE_RADIO_BUTTON_1.isSelected());
        Browser.driver.findElement(SUBSCRIBE_RADIO_BUTTON_2).click();
        Browser.driver.findElement(PRIVACY_POLICY_CHECKBOX).click();
        Browser.driver.findElement(CONTINUE_BUTTON).click();
        }

    /**
     * Assert that the shown validation message is as expected
     * @param expectedRegisterFormValidationMessage the registration form validation message you expect
     * @param messageOnFailure the message that will appear in your reports in case of assert failure
     */
    public static void verifyRegisterFormValidationMessage(String expectedRegisterFormValidationMessage,
                                                        String messageOnFailure) {
        String actualRegisterFormValidationMessage =
                Browser.driver.findElement(REGISTER_FORM_VALIDATION_MESSAGE).getText();
        Assert.assertTrue(actualRegisterFormValidationMessage.contains(expectedRegisterFormValidationMessage),
                messageOnFailure);
    }
}
