package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

// Check that if published posts match their displayed count
public class ProfilePosts extends BaseTest {
    @DataProvider(name = "validCredentials")
    public Object[][] validCredentials() {
        return new Object[][]{
                {"Teet", "Track1"}
        };
    }
        @Test(dataProvider = "validCredentials")
        public void numberOfPosts (String username, String password) throws InterruptedException {
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

            header.goToProfile();

            ProfilePage profilePage = new ProfilePage(driver);
            profilePage.verifyUrl();

            int visiblePosts = profilePage.viewExistingPosts();
            String postsCount = profilePage.displayedNumberOfPosts();
            Assert.assertEquals(visiblePosts, postsCount, "The public posts doesn't match with their count");
        }
}
