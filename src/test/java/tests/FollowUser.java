package tests;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.LoginPage;

// Follow the first user from homepage
public class FollowUser extends BaseTest {
    @Parameters({"username","password"})
    @Test
    public void followUserHomePage(String username, String password){
        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl();
        homePage.verifyUrl();
        Header header = new Header(driver);
        header.goToLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyUrl();
        Assert.assertEquals(loginPage.getHeader(), "Sign in", "Incorrect login header");
        loginPage.logIn(username, password);

        homePage.followFirstUser();
    }
}
