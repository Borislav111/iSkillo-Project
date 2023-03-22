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
//    @DataProvider(name = "validLogin")
//    public Object[][] validLogin(){
//        return new Object[][]{
//                {"Teet", "Track1"}
//        };
//    }
//    @Test(dataProvider = "validLogin")
    @Test
    public void correctLogin(){
        HomePage homePage = new HomePage(driver);
//        homePage.navigateUrl();
//        homePage.verifyUrl();

//        Header header = new Header(driver);
//        header.goToLogin();
//
//        LoginPage loginPage = new LoginPage(driver);
//
//        loginPage.logIn(username, password);


        homePage.verifyUrl();
    }
}
