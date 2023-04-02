package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NotFoundPage;

// Try to open first user's profile page without logging in into system
public class NoLoginUsersPage extends BaseTest{
    private final String infoMsg = "Oops - that's not right!";
    @Test
    public void openProfilePage(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl();
        homePage.verifyUrl();
        homePage.clickLastPostedUser();

        NotFoundPage notFoundPage = new NotFoundPage(driver);
        Assert.assertEquals(notFoundPage.getInfoMsg(), infoMsg, "The message is incorrect");
    }
}
