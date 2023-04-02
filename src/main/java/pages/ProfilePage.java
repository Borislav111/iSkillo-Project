package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProfilePage extends BasePage {
    private final String profileUrl = "http://training.skillo-bg.com/users";
    @FindBy(css = ".gallery-item")
    List<WebElement> publicPosts;
    @FindBy(css = "strong")
    List<WebElement> displayedNumberOfPosts;

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyUrl() {
        wait.until(ExpectedConditions.urlContains(profileUrl));
    }

    public int viewExistingPosts() throws InterruptedException {
        Actions actions = new Actions(driver);
        int loadedPostsCount = 0;
        int loadedPostsCountAfterScroll = -1;
        while (loadedPostsCount != loadedPostsCountAfterScroll) {
            List<WebElement> loadedPosts = driver.findElements(By.tagName("app-post"));
            loadedPostsCount = loadedPosts.size();
            actions.moveToElement(publicPosts.get(publicPosts.size() - 1)).perform();
            List<WebElement> loadedPostsAfterScroll = driver.findElements(By.tagName("app-post"));
            loadedPostsCountAfterScroll = loadedPostsAfterScroll.size();
            Thread.sleep(1000);
        }
        return publicPosts.size();
    }
    public String displayedNumberOfPosts() {
        return displayedNumberOfPosts.get(0).getText();
    }

}
