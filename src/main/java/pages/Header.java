package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends BasePage {

    @FindBy(id = "nav-link-login")
    WebElement loginBtn;
    @FindBy(id = "nav-link-profile")
    WebElement profileBtn;

    @FindBy(css = ".nav-link .fas")
    WebElement logoutBtn;

    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToLogin() {
        clickElement(loginBtn);
    }

    public void goToProfile() {
        clickElement(profileBtn);
    }

    public void checkLogoutBtn() {
        smallWait.until(ExpectedConditions.invisibilityOf(logoutBtn));
    }

    public Boolean checkLoginLink() {
        smallWait.until(ExpectedConditions.visibilityOf(loginBtn));
        return loginBtn.isDisplayed();
    }
}
