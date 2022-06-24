package core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.backend.AdminLogin;
import utils.Browser;

public class BaseTests {
    @BeforeMethod
    public void setup (){
        Browser.openBrowser();
        AdminLogin.open();
    }
   @AfterMethod
    public void tearDown(){
       Browser.quit();
    }
}
