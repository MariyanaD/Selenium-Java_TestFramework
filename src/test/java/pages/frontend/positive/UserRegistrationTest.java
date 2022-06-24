package pages.frontend.positive;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.backend.AdminLogin;
import pages.backend.AdminStoreAccount;
import pages.frontend.NewUserAccount;
import pages.frontend.UserRegisterPage;
import utils.Browser;

public class UserRegistrationTest {

    @BeforeMethod
    public void setup() {
        Browser.openBrowser();
        AdminLogin.open();
        AdminLogin.login("admin", "parola123!");
        AdminStoreAccount.openMyStorePage();
        AdminStoreAccount.goToRegisterLink();
        UserRegisterPage.open();
        }

    @Test
    public void successfulRegisterAccount() {
        UserRegisterPage.fillRegisterForm("Mariyana", "Doychinova", "misi01@yopmail.com", "359663355", "parola123!","parola123!");
        NewUserAccount.verifyUserRegisterAccount("Your Account Has Been Created!", "The user cannot be registered");
          }


    @AfterMethod
    public void tearDown() {
        Browser.quit();
    }
}

