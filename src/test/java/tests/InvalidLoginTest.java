package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest {
    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][]{
//                {"Invalid1234", "Invalid77512"},
//                {"Teet", "14123121"}, // correct user
//                {"", "1234"},
                {"Teet", ""},
                {"Teet", "Track1"}
        };
    }
    @Test(dataProvider = "invalidCredentials")
    public void invalidLoginCredentials(String username, String password) throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl();
        homePage.verifyUrl();
        Header header = new Header(driver);
        header.goToLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyUrl();
        String loginHeader = loginPage.getHeader();
        Assert.assertEquals(loginHeader, "Sign in", "Invalid login header");
        loginPage.logIn(username, password);

        loginPage.getErorrToastMsg();
    }
}
