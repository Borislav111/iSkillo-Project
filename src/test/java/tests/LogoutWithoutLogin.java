package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.LoginPage;

// Checking that the logout button is not visible when user is not logged in
public class LogoutWithoutLogin extends BaseTest {

    @Test
    public void noLoginLogout() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl();
        Header header = new Header(driver);
        header.checkLogoutBtn();
        Boolean loginLinkDisplayed = header.checkLoginLink();
        Assert.assertTrue(loginLinkDisplayed);
    }
}
