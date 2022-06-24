package pages.backend.positive;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.backend.AdminLogin;
import pages.backend.AdminStoreAccount;
import pages.components.AdminHeader;
import utils.Browser;

public class AdminStoreAccountTest {

    @BeforeMethod
    public void setup (){
        Browser.openBrowser();
        AdminLogin.open();
        AdminLogin.login("admin", "parola123!");
        AdminStoreAccount.openMyStorePage();
        AdminStoreAccount.goToRegisterLink();

    }
    @Test
    public void successfulProfileAdminStoreOpen() {
        AdminHeader.goToAccountFullNameDropDownPage("Your Store", "Your Store " +
                "page does not exists.");
        AdminStoreAccount.verifyMyAccountStore("My Account", "The Store page " +
                "could not be open.");
    }
    @AfterMethod
    public void tearDown () {
        Browser.quit();
    }
}


