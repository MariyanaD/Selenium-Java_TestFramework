package pages.backend.positive;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.backend.AdminLogin;
import pages.components.AdminHeader;

public class AdminLoginTests extends BaseTests {

    @Test
    public void successfulLogin(){
        AdminLogin.login("admin", "parola123!");
        AdminHeader.verifyAccountFullName("Milen Strahinski", "The fullname of the " +
                "logged in account is not present in the top header, which means it's not logged in.");
    }
}
