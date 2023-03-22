package tests;

import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ValidLogin extends BaseTest{
    @DataProvider(name = "validLogin")
    public Object[][] validLogin(){
        return new Object[][]{
                {"Teet", "Track1"}
        };
    }
    @Test(dataProvider = "validLogin")
    public void correctLogin(String username, String password) throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl();
        homePage.verifyUrl();

        Header header = new Header(driver);
        header.goToLogin();

        LoginPage loginPage = new LoginPage(driver);
        String loginHeader = loginPage.getHeader();
        Assert.assertEquals(loginHeader, "Sign in", "Incorrect login header");
        loginPage.logIn(username, password);

        loginPage.getSuccessToastMsg();
        homePage.verifyUrl();
    }
}
