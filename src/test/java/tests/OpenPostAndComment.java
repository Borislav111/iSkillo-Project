package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.LoginPage;
import pages.OpenedPost;


// Logged-in user writes a comment and the test check if that comment matches the username of commented user
public class OpenPostAndComment extends BaseTest{
    @DataProvider(name = "validCredentials")
    public Object[][] validCredentials() {
        return new Object[][]{
                {"Teet", "Track1", "hi"}
        };
    }
    @Test(dataProvider = "validCredentials")
    public void commentPost(String username, String password, String text){
        HomePage homePage = new HomePage(driver);
        Header header = new Header(driver);
        LoginPage loginPage = new LoginPage(driver);
        OpenedPost openedPost = new OpenedPost(driver);

        homePage.navigateUrl();
        homePage.verifyUrl();

        header.goToLogin();

        loginPage.verifyUrl();
        String loginHeader = loginPage.getHeader();
        Assert.assertEquals(loginHeader, "Sign in", "Incorrect login header");
        loginPage.logIn(username, password);
        loginPage.getSuccessToastMsg();

        homePage.openFirstPost();

        String writtenComment = openedPost.commentPost(text);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();


        String expectedComment = openedPost.getComment();
        Assert.assertEquals(writtenComment, expectedComment, "The comments doesn't match" );

        String expectedUser = openedPost.usersComments(username);
        Assert.assertEquals(username, expectedUser, "The user doesn't match");
        System.out.println("The commented user is " + expectedUser + " and the comment is " + expectedComment);
    }
}
