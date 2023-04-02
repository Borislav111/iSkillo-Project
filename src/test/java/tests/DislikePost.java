package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.OpenedPost;

// Dislike a post without log in
public class DislikePost extends  BaseTest{
    @Test
    public void dislikePost() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl();
        homePage.verifyUrl();
        homePage.openFirstPost();

        OpenedPost openedPost = new OpenedPost(driver);
        openedPost.dislikePost();
        LoginPage loginPage = new LoginPage(driver);
        String expectedWarningMsg = loginPage.getWarningToastMsg();
        Assert.assertEquals(expectedWarningMsg, "You must login", "The toast message is invalid");
    }
}
