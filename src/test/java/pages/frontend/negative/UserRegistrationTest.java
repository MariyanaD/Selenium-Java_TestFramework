package pages.frontend.negative;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.backend.AdminLogin;
import pages.backend.AdminStoreAccount;
import pages.frontend.UserRegisterPage;
import utils.Browser;

public class UserRegistrationTest {
    @BeforeMethod
    public void setup() {
        Browser.openBrowser();
        UserRegisterPage.open();
    }

    @Test
    public void unsuccessfulRegistration() {
        UserRegisterPage.fillRegisterForm("Mariyana", "Doychinova", "juju@grgt", "3598654", "parola123!", "parola123!");
        UserRegisterPage.verifyRegisterFormValidationMessage("E-Mail Address does not appear to be valid!"
                , "The expected validation message when registering with the wrong/missing email " +
                        "was not present");
    }

}


