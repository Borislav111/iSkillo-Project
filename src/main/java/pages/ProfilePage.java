package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage{
    private final String profileUrl = "http://training.skillo-bg.com/users";
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    public void verifyUrl(){
        wait.until(ExpectedConditions.urlContains(profileUrl));
    }
}
