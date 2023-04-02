package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class OpenedPost extends BasePage {
    private String lastSubmittedComment;
    @FindBy(css = ".comment-form input")
    WebElement commentField;
    @FindBy(css = ".comment-list-container .comment-content")
    List<WebElement> displayedComments;
    @FindBy(css = ".comment-list-container .comment-user")
    List<WebElement> commentedUsers;
    @FindBy(css = ".icons-container .ml-4")
    WebElement dislikeBtn;

    public OpenedPost(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String commentPost(String text) {
        enterText(commentField, text);
        lastSubmittedComment = text;
        return text;
    }

    public String usersComments(String username) {
        wait.until(ExpectedConditions.visibilityOfAllElements(commentedUsers));

        for (int i = 0; i < commentedUsers.size(); i++) {
            WebElement user = commentedUsers.get(i);
            if (user.getText().equals(username)) {
                return user.getText();
            }
        }
        return null;
    }

    public String getComment() {
        smallWait.until(ExpectedConditions.visibilityOfAllElements(displayedComments));

        for (int i = 0; i <= displayedComments.size(); i++) {
            WebElement comment = displayedComments.get(i);
            if (comment.isDisplayed() && comment.getText().equals(lastSubmittedComment)) {
                return comment.getText();
            }
        }
        return null;
    }

    public void dislikePost() {
        clickElement(dislikeBtn);
    }
}
