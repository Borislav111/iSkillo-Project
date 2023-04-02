package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {
    private final String homeUrl = "http://training.skillo-bg.com/posts/all";
    private WebElement followBtn;

    @FindBy(css = ".post-feed-img")
    List<WebElement> publishedPosts;
    @FindBy(className = "post-user")
    List<WebElement> postedUsers;
    @FindBy(css = ".follow-buttons button")
    List<WebElement> followButtons;
    @FindBy(xpath = "//button[text()='Unfollow']")
    WebElement unfollowBtn;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateUrl() {
        driver.get(homeUrl);
    }

    public void verifyUrl() {
        verifyUrl(homeUrl);
    }

    public void openFirstPost() {
        wait.until(ExpectedConditions.visibilityOfAllElements(publishedPosts));
        WebElement firstPost = publishedPosts.get(2);
        clickElement(firstPost);
    }

    public void clickLastPostedUser() {
        clickElement(postedUsers.get(0));
    }

    public void followFirstUser(){
        followBtn = followButtons.get(0);
        smallWait.until(ExpectedConditions.textToBePresentInElement(followBtn, "Follow"));
        clickElement(followBtn);
    }

    public String getUnfollowBtnText(){
        followBtn = unfollowBtn;
        return followBtn.getText();
    }
}
