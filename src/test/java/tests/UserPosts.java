package tests;

import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.ProfilePage;

public class UserPosts extends BaseTest{

    @Test
    public void numberOfPosts(){
        HomePage homePage = new HomePage(driver);
        homePage.verifyUrl();
        Header header = new Header(driver);
        header.goToProfile();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.verifyUrl();
    }
}
