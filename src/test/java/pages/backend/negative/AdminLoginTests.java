package pages.backend.negative;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.backend.AdminLogin;

public class AdminLoginTests extends BaseTests {

    @Test
    public void unsuccessfulLogin(){
        AdminLogin.login("admin1", "pass123");
        AdminLogin.verifyLoginFormValidationMessage("No match for Username and/or Password."
                ,"The expected validation message when logging in with the wrong credentials " +
                        "was not present");
    }
    @Test
    public void unsuccessfulLoginWithALotNumberOfLoginAttempts(){
            AdminLogin.login("admin", "pass123!");
            AdminLogin.verifyLoginFormValidationAttemptMessage("Too long tries for login",
                    " Warning: Your account has exceeded allowed number of login attempts. Please try " +
                            "again in 1 hour or reset password.");
        }
}

