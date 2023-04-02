package tests;

import org.apache.commons.logging.Log;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.OpenedPost;

import javax.swing.*;

public class CommentPostNonReg extends BaseTest{

    @Test
    public void commentPost(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl();
        homePage.verifyUrl();

        homePage.openFirstPost();
        OpenedPost openedPost = new OpenedPost(driver);
        openedPost.commentPost("Test");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();

        LoginPage loginPage = new LoginPage(driver);
        String warningToastMsg = loginPage.getWarningToastMsg();
        Assert.assertEquals(warningToastMsg, "You must login", "Incorrect toast message");
        loginPage.verifyUrl();
        String loginHeader = loginPage.getHeader();
        Assert.assertEquals(loginHeader, "Sign in", "Incorrect login header");
    }
}
